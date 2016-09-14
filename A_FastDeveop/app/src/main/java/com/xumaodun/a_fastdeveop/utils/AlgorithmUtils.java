package com.xumaodun.a_fastdeveop.utils;

/**
 * Created by xumaodun on 16/9/12.
 */
public class AlgorithmUtils {

    public static int getPagerSize(int total, int size) {
        return (total + size -1) / size ;
    }
}
