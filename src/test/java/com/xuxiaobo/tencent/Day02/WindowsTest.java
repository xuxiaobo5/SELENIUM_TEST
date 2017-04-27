package com.xuxiaobo.tencent.Day02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

/**
 * Created by Administrator on 2017/4/27 0027.
 */
public class WindowsTest {

    WebDriver driver;

    @BeforeMethod
    public void openChrome(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Administrator\\IdeaProjects\\SELENIUM_TEST\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    /*
    * 打开测试页面
    * 点击Open new window
    * 点击百度
    * */

    @Test
    public void windowTest() throws InterruptedException {
        driver.get("file:///D:/selenium_html/index.html");
        driver.findElement(By.linkText("Open new window")).click();
        Thread.sleep(2000);
        //获取当前window句柄值
        String handle = driver.getWindowHandle();
        //For循环获取到的handls是否跟handle相等
        for(String handles : driver.getWindowHandles()){
            if (handles.equals(handle)){
                continue;
            }else {
                driver.switchTo().window(handles);
            }
        }
        driver.findElement(By.linkText("baidu")).click();
        Thread.sleep(3000);
    }

    @AfterMethod
    public void closeChrome(){
        driver.quit();
    }
}
