package com.rayworks.java.iaq;

/**
 * Created by Shirley on 6/26/16.
 */
public class ObjSize {
    public static void main(String[] args){
        Runtime runtime = Runtime.getRuntime();

        long start, end;
        Object obj;
        runtime.gc();
        start = runtime.freeMemory(); //runtime.freememory();
        obj = new Object(); // Or whatever you want to look at
        end =  runtime.freeMemory();
        System.out.println(
                "That took " + (start-end) + " bytes.");
    }
}
