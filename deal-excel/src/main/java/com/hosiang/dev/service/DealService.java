package com.hosiang.dev.service;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 业务处理
 *
 * @author Howe Hsiang
 */
public class DealService {

    //业务处理dealService
    public static ArrayList<Map<String,String>> dealData(List<Map<String, String>> list,
                 List<Map<String, String>> list2) throws Exception{

        Map<String,String> newMap = new HashMap<String,String>();
        ArrayList<Map<String,String>> maplist = new ArrayList<Map<String,String>>();

        //遍历解析出来的list
        for (Map<String,String> map : list) {
            for (Map.Entry<String,String> entry : map.entrySet()) {
                //System.out.print(entry.getKey()+":"+entry.getValue()+",");

                for (Map<String,String> map2 : list2) {
                    for (Map.Entry<String,String> entry2 : map2.entrySet()) {

                        if (("证券帐号").equals(entry.getKey())){
                            if (entry.getKey() == entry2.getKey()
                                    &&entry.getValue().equals(entry2.getValue())){
                                //System.out.print(entry.getKey()+":"+entry.getValue()+","+entry2.getValue()+",");

                                String defaultValue = map.getOrDefault("开户时间","");
                                newMap.put("开户时间",defaultValue);
                                newMap.putAll(map2);
                            }

                        }
                    }
                }
            }
        }

        maplist.add(newMap);

        String listjson = JSON.toJSONString(list);
        String list2json = JSON.toJSONString(list2);
        String newlistjson = JSON.toJSONString(maplist);

        System.out.println("list---- "+listjson);
        System.out.println("list2---- "+list2json);
        System.out.println("newlistjson---- "+newlistjson);

        return maplist;
    }
}
