package com.nostalgia.phone_store_backend.util;

import java.util.Random;

public class OrderUtil {
    public static String getUniqueKey(){
        Random random=new Random();
        return random.nextInt(1000000)+""+System.currentTimeMillis();
    }
}
