package com.beatdev.apiname;

import java.util.HashMap;
import java.util.Map;

public class Mani {
    public static void main(String[] args){
        Map<Long, Long> map = new HashMap<>();
        System.out.println(map.size());
        //map.put(Long.valueOf(1),Long.valueOf(1));
        long i = map.get(Long.valueOf(1));
        System.out.println(i);
    }
}
