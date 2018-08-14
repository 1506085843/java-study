package com.hosiang.dev;

import com.hosiang.dev.contant.Constant;
import com.hosiang.dev.utils.ExcelPoiReaderUtils;
import com.hosiang.dev.utils.ExcelPoiWriteUtils;
import com.hosiang.dev.service.DealService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 程序入口
 *
 * @author Howe Hsiang
 */
public class App {

    public static void main(String[] args) throws Exception {

        //1、读取Excel
        List<Map<String, String>> list = new ExcelPoiReaderUtils().readExcel(Constant.READER_FILE_PATH, Constant.READER_COLUMNS);
        List<Map<String, String>> list2 = new ExcelPoiReaderUtils().readExcel(Constant.READER_FILE_PATH_2, Constant.READER_COLUMNS_2);

        //2、业务处理
        ArrayList<Map<String,String>> mapList = DealService.dealData(list,list2);

        //3、创建新Excel
        ExcelPoiWriteUtils.createExcel(Constant.FILE_PATH,Constant.SHEET,Constant.TITLE);

        //4、写入数据
        ExcelPoiWriteUtils.writeToExcel(Constant.FILE_PATH,Constant.SHEET,mapList);

    }
}
