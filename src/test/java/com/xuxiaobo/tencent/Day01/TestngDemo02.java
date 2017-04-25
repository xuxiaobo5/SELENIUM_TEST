package com.xuxiaobo.tencent.Day01;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Administrator on 2017/4/25 0025.
 */
public class TestngDemo02 {

    //校验相等
    @Test
    public void assertEqualTest(){
        String a = "abc";
        String b = "bcd";
        Assert.assertEquals(a,b);
    }

    //校验不相等
    @Test
    public void assertNotEqualTest(){
        int a = 1;
        int b = 2;
        Assert.assertNotEquals(a,b);
    }

    //校验为空
    @Test
    public void assertNullTest(){
        String a = null;
        Assert.assertNull(a);
    }

    //校验不为空
    @Test
    public void assertNotNullTest(){
        String a = "awe";
        Assert.assertNotNull(a);
    }

    @Test
    public void assertFasleTest(){
        Boolean a = false;
        Assert.assertFalse(a);
    }

    @Test
    public void assertTrueTest(){
        Boolean a = true;
        Assert.assertTrue(a);
    }
}
