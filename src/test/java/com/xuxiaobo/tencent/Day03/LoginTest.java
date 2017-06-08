package com.xuxiaobo.tencent.Day03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

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
        login(driver,"xuxiaobo5","Xxb520Hjj@");
        //显式等待
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='spnUid']")));
        String username = driver.findElement(By.xpath(".//*[@id='spnUid']")).getText();
        Assert.assertEquals(username,"xuxiaobo5@163.com");
    }

    @Test
    public void testLoginFail(){
        login(driver,"xuxiaobo123","123456");
        //显式等待
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='nerror']/div[2]")));
        String errInfo = driver.findElement(By.xpath(".//*[@id='nerror']/div[2]")).getText();
        Assert.assertEquals(errInfo,"帐号或密码错误");
    }

    @Test
    public static void login(WebDriver driver, String email, String pwd){
        driver = new ChromeDriver();
        driver.get("http://mail.163.com");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //driver转交控制权
        driver.switchTo().frame("x-URS-iframe");
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys(pwd);
        driver.findElement(By.id("dologin")).click();
     }

    @AfterMethod
    public void closeChrome(){
        driver.quit();
    }
}
