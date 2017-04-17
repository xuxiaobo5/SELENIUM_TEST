package com.xuxiaobo.tencent.Day03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by Administrator on 2017/4/17 0017.
 */

public class RegisterTest {
    WebDriver driver;

    @BeforeMethod
    public void openChrome(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Administrator\\IdeaProjects\\seleniumtest\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://mail.163.com");
    }

    @Test
    public void registerFailTest(){
        //转交控制权给frame
        driver.switchTo().frame("x-URS-iframe");
        //点击页面上的注册按钮
        driver.findElement(By.id("changepage")).click();
        //获取当前页面handle值
        String handle1 = driver.getWindowHandle();
        //切换新的Window页面
        for (String handles : driver.getWindowHandles()){
            if (handles.equals(handle1)){
                continue;
            }driver.switchTo().window(handles);
        }

        //获取时间戳,强制类型转换为String
        String time = String.valueOf(System.currentTimeMillis()/100);

        driver.findElement(By.id("nameIpt")).sendKeys("email"+time);
        driver.findElement(By.id("mainPwdIpt")).sendKeys("1q2w3e4r");
        driver.findElement(By.id("mainCfmPwdIpt")).sendKeys("1q2w3e4r");
        driver.findElement(By.id("mainMobileIpt")).sendKeys(time);
        driver.findElement(By.id("vcodeIpt")).sendKeys("qwer");
        driver.findElement(By.id("mainAcodeIpt")).sendKeys("123456");
        driver.findElement(By.id("mainRegA")).click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String errInfo = driver.findElement(By.xpath(".//*[@id='m_mainAcode']/span")).getText();
        Assert.assertEquals(errInfo,"  手机验证码不正确，请重新填写");
    }

    @AfterMethod
    public void closeChrome(){
        driver.quit();
    }
}
