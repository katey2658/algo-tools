package com.busyzero.algo.security.http;


import org.junit.Test;

public class IDCardUtilsTest {

    @Test
    public void valid() {
    }

    @Test
    public void overrideId() {
    }

    @Test
    public void overrideId1() {
        // String id = "33068319950515445X";
        String id =  "33068319950515445X";
        String result = IDCardUtils.overrideId(id);
        System.out.println(result);
    }
}