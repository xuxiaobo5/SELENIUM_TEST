package com.xuxiaobo.tencent.Day03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by Administrator on 2017/4/17 0017.
 */
public class LoginTest {
    WebDriver driver;

    @BeforeMethod
    public void openChrome(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Administrator\\IdeaProjects\\seleniumtest\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://mail.163.com");
    }

    @Test
    public void testLoginSuccess(){
        //driver转交控制权
        driver.switchTo().frame("x-URS-iframe");
        //输入邮箱用户名
        driver.findElement(By.name("email")).sendKeys("xuxiaobo5");
        //输入邮箱密码
        driver.findElement(By.name("password")).sendKeys("Xxb520Hjj@");
        //点击登录按钮
        driver.findElement(By.id("dologin")).click();

        //显式等待
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='spnUid']")));

        String username = driver.findElement(By.xpath(".//*[@id='spnUid']")).getText();
        Assert.assertEquals(username,"xuxiaobo5@163.com");
    }

    @Test
    public void testLoginFail(){
        //driver转交控制权
        driver.switchTo().frame("x-URS-iframe");
        //输入邮箱用户名
        driver.findElement(By.name("email")).sendKeys("xuxiaobo5");
        //输入邮箱密码
        driver.findElement(By.name("password")).sendKeys("123456");
        //点击登录按钮
        driver.findElement(By.id("dologin")).click();

        //显式等待
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='nerror']/div[2]")));

        String errInfo = driver.findElement(By.xpath(".//*[@id='nerror']/div[2]")).getText();
        Assert.assertEquals(errInfo,"帐号或密码错误");
    }

    @AfterMethod
    public void closeChrome(){
        driver.quit();
    }
}