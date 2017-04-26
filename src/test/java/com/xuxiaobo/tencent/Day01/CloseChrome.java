package com.xuxiaobo.tencent.Day01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

/**
 * Created by Administrator on 2017/4/26 0026.
 */
public class CloseChrome {
    @Test
    public void closeChrome01() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Administrator\\IdeaProjects\\SELENIUM_TEST\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        Thread.sleep(5000);
        //关闭当前窗口
        driver.close();
    }

    @Test
    public void closeChrome02() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Administrator\\IdeaProjects\\SELENIUM_TEST\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        Thread.sleep(5000);
        driver.quit();
    }
}
