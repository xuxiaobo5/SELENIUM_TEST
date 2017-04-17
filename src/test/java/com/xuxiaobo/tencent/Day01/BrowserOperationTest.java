package com.xuxiaobo.tencent.Day01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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

    @Test
    public void operateBrowser1() throws InterruptedException {
        driver.get("http://www.baidu.com");
        Thread.sleep(5000);
        driver.navigate().back();
        Thread.sleep(5000);
    }

    @Test
    public void operateBrowser2(){
        driver.get("http://www.baidu.com");
        String url = driver.getCurrentUrl();
        System.out.print("URL地址是"+url);
        Assert.assertEquals(url,"https://www.baidu.com/");
    }

    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }
}
