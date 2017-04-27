package com.xuxiaobo.tencent.Day02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by Administrator on 2017/4/26 0026.
 */
public class IframeTest {

    WebDriver driver;

    @BeforeMethod
    public void openChrome(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Administrator\\IdeaProjects\\SELENIUM_TEST\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void iframeTest() throws InterruptedException {
        driver.get("file:///D:/selenium_html/index.html");
        //通过 id 或者 name 方式
        //driver.switchTo().frame("aa");
        //通过 webelement 方式
        WebElement iframe = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.linkText("baidu")).click();
        Thread.sleep(3000);
        driver.switchTo().defaultContent();
        driver.findElement(By.linkText("登陆界面")).click();
    }

    @AfterMethod
    public void closeChrome(){
        driver.quit();
    }
}
