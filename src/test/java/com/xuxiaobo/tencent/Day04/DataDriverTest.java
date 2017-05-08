package com.xuxiaobo.tencent.Day04;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by Administrator on 2017/5/3 0003.
 */
public class DataDriverTest {

    @DataProvider(name = "loginUser")
    public Object[][] dataTest(){
        return new Object[][]{
                {"user1","pwd1"},
                {"user2","pwd2"}
        };
    }

    @Test(dataProvider = "loginUser")
    public void loginTest(String user, String pwd){
        System.out.println("user"+user);
        System.out.println("pwd"+pwd);
    }
}
