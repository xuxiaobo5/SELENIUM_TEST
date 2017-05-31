package com.xuxiaobo.tencent.Day01;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by Administrator on 2017/3/31 0031.
 */
public class BrowserOperationTest {
    WebDriver driver;

    @BeforeMethod
    public void openChrome(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Administrator\\IdeaProjects\\seleniumtest\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    //浏览器进行后退操作
    @Test
    public void getTest() throws InterruptedException {
        driver.get("http://www.baidu.com");
        Thread.sleep(5000);
        driver.navigate().back();
        driver.navigate().forward();
        Thread.sleep(5000);
    }

    //获取当前页面的Title
    @Test
    public void getTitleTest(){
        driver.get("http://www.baidu.com");
        String title = driver.getTitle();
        System.out.println(title);
    }

    //获取浏览器的URL并且做断言与预期是否相等
    @Test
    public void getUrlTest(){
        driver.get("http://www.baidu.com");
        String url = driver.getCurrentUrl();
        System.out.print("URL地址是"+url);
        Assert.assertEquals(url,"https://www.baidu.com/");
    }

    //刷新页面
    @Test
    public void refreshTest() throws InterruptedException {
        driver.get("http://www.baidu.com");
        Thread.sleep(3000);
        driver.navigate().refresh();
        Thread.sleep(5000);
    }

    //设置窗口大小,最大化浏览器
    @Test
    public void sizeTest() throws InterruptedException {
        //设置浏览器宽和高都是500的大小
        Dimension dimension = new Dimension(500,500);
        driver.manage().window().setSize(dimension);
        Thread.sleep(5000);
        //设置浏览器最大化
        driver.manage().window().maximize();
        Thread.sleep(5000);
        List<WebElement> list = driver.findElements(By.xpath("xxx"));
        for (int i = 0; i < list.size() ; i++) {
            list.get(i).click();
        }
    }

    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }
}
