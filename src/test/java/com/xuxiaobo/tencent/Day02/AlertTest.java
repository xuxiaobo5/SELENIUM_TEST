package com.xuxiaobo.tencent.Day02;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by Administrator on 2017/4/26 0026.
 */
public class AlertTest {

    WebDriver driver;

    @BeforeMethod
    public void openChrome(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Administrator\\IdeaProjects\\SELENIUM_TEST\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    //Alert弹窗测试
    @Test
    public void alertTest() throws InterruptedException {
        driver.get("file:///D:/selenium_html/index.html");
        driver.findElement(By.className("alert")).click();
        Alert alert = driver.switchTo().alert();
        String text = alert.getText();
        Thread.sleep(2000);
        alert.accept();
        Assert.assertEquals(text,"请点击确定");
    }

    //Confirm弹窗测试
    @Test
    public void confirmTest() throws InterruptedException {
        driver.get("file:///D:/selenium_html/index.html");
        driver.findElement(By.className("confirm")).click();
        Thread.sleep(2000);
        //driver转交控制权给alert
        Alert alert = driver.switchTo().alert();
        //点击取消
        alert.dismiss();
        Thread.sleep(2000);
        //点击确定
        alert.accept();
        Thread.sleep(2000);
    }

    //Prompt测试
    @Test
    public void promptTest() throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        driver.get("file:///D:/selenium_html/index.html");
        driver.findElement(By.className("prompt")).click();
        Thread.sleep(2000);
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("这是个Prompt");
        Thread.sleep(2000);
        alert.accept();
        Thread.sleep(2000);
        driver.quit();
    }


    @AfterMethod
    public void closeChrome(){
         driver.quit();
    }
}
