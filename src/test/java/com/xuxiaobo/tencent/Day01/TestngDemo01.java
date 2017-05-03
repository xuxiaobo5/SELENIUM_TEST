package com.xuxiaobo.tencent.Day01;

import org.testng.annotations.*;

/**
 * Created by Administrator on 2017/4/25 0025.
 */
public class TestngDemo01 {

    @BeforeTest
    public void beforeTest(){
        System.out.println("这是@Before注解");
    }

    @BeforeMethod
    public void beforeMethodTest(){
        System.out.println("这是@BeoforeMethod注解");
    }

    @Test
    public void testCase01() throws InterruptedException {
        Thread.sleep(5000);
        System.out.println("这是@Test注解,case1");
    }

    @Test
    public void testCase02() throws InterruptedException {
        Thread.sleep(5000);
        System.out.println("这是@Test注解,case2");
    }

    @AfterMethod
    public void afterMethodTest(){
        System.out.println("这是AfterMethod注解");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("这是@After注解");
    }

}
