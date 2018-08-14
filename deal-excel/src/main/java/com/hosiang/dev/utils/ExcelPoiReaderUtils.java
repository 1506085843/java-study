package com.hosiang.dev.utils;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 读取Excel
 *
 * @author Howe Hsiang
 */
public class ExcelPoiReaderUtils {

    /**
     * 读取excel 第1张sheet （xls和xlsx）
     *
     * @param filePath	excel路径
     * @param columns	列名（表头）
     * @author lizixiang ,2018-05-08
     * @return
     */
    public List<Map<String, String>> readExcel(String filePath,String[] columns) {
        Sheet sheet = null;
        Row row = null;
        Row rowHeader = null;
        List<Map<String, String>> list = null;
        String cellData = null;
        Workbook wb = null;
        if (filePath == null) {
            return null;
        }
        String extString = filePath.substring(filePath.lastIndexOf("."));
        InputStream is = null;
        try {
            is = new FileInputStream(filePath);
            if (".xls".equals(extString)) {
                wb = new HSSFWorkbook(is);
            } else if (".xlsx".equals(extString)) {
                wb = new XSSFWorkbook(is);
            } else {
                wb = null;
            }
            if (wb != null) {
                // 用来存放表中数据
                list = new ArrayList<Map<String, String>>();

                //遍历Sheet表
                for (int i = 0; i < wb.getNumberOfSheets(); i++) {
                    //获取每个Sheet表
                    sheet = wb.getSheetAt(i);
                    // 获取最大行数
                    int rownum = sheet.getPhysicalNumberOfRows();
                    // 获取第一行
                    rowHeader = sheet.getRow(0);
                    row = sheet.getRow(0);
                    // 获取最大列数
                    int colnum = row.getPhysicalNumberOfCells();
                    for (int j = 1; j < rownum; j++) {
                        Map<String, String> map = new LinkedHashMap<String, String>();
                        row = sheet.getRow(j);
                        if (row != null) {
                            for (int k = 0; k < colnum; k++) {
                                if (columns[k].equals(getCellFormatValue(rowHeader.getCell(k)))) {
                                    cellData = (String) getCellFormatValue(row
                                            .getCell(k));
                                    map.put(columns[k], cellData);
                                }
                            }
                        } else {
                            break;
                        }
                        list.add(map);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**	获取单个单元格数据
     * @param cell
     * @return
     * @author lizixiang ,2018-05-08
     */
    public Object getCellFormatValue(Cell cell) {
        Object cellValue = null;
        if (null != cell) {
            // 判断cell类型
            switch (cell.getCellType()) {
                case Cell.CELL_TYPE_NUMERIC: // 数字
                if (DateUtil.isCellDateFormatted(cell)) {
                    //如果是date类型则 ，获取该cell的date值
                    cellValue = DateUtil.getJavaDate(cell.getNumericCellValue()).toString();

                 } else { // 纯数字
                    cellValue = String.valueOf(cell.getNumericCellValue());
                 }
                    break;
                case Cell.CELL_TYPE_STRING: // 字符串
                    cellValue = cell.getStringCellValue();
                    break;
                case Cell.CELL_TYPE_BOOLEAN: // Boolean
                    cellValue = cell.getBooleanCellValue();
                    break;
                case Cell.CELL_TYPE_FORMULA: // 公式
                    cellValue = cell.getCellFormula();
                    break;
                case Cell.CELL_TYPE_BLANK: // 空值
                    cellValue = "NULL";
                    break;
                case Cell.CELL_TYPE_ERROR: // 故障
                    cellValue = "ERROR";
                    break;
                default:
                    cellValue = "";
                    break;
            }
        } else {
            cellValue = "-";
        }

        return cellValue;
    }

}
