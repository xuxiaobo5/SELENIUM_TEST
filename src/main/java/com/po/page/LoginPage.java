package com.po.page;

import org.openqa.selenium.By;

/**
 * Created by Administrator on 2017/5/3 0003.
 */
public class LoginPage {

    //定义email文本框的定位方式
    public static By emailInput = By.name("email");
    //定义密码输入框的定位方式
    public static By pwdInput = By.name("password");
    //定义登录按钮的定位方式
    public static By loginBtn = By.id("dologin");
    //定义去注册按钮的定位方式
    public static By regBtn = By.id("changepage");
  }
