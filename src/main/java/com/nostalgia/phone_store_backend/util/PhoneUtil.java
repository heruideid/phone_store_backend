package com.nostalgia.phone_store_backend.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneUtil {
    public static List<Map<String,String>> getTags(String s){
        List<Map<String,String>> tagList=new ArrayList<>();
        String[] strings=s.split("&");
        Map<String,String> map;
        for (String string : strings) {
            map=new HashMap<>();
            map.put("name",string);
            tagList.add(map);
        }
        return tagList;
    }
}
