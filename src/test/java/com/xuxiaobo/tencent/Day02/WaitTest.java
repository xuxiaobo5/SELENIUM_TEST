package com.xuxiaobo.tencent.Day02;

import org.junit.experimental.theories.Theories;
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

import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2017/4/27 0027.
 */
public class WaitTest {
    WebDriver driver;

    @BeforeMethod
    public void openChrome(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Administrator\\IdeaProjects\\SELENIUM_TEST\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        //全局等待
        //driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
    }

    /*
    * 打开测试页面
    * 点击wait按钮
    * 获取文本,并判断文本是否为"wait for display
    * */
    @Test
    public void waitTest01() throws InterruptedException {
        driver.get("file:///D:/selenium_html/index.html");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"wait\"]/input")).click();
        String text = driver.findElement(By.xpath("//*[@id=\"display\"]/div")).getText();
        Assert.assertEquals(text,"wait for display");
    }

    @Test
    public void waitTest02() throws InterruptedException {
        driver.get("file:///D:/selenium_html/index.html");
        driver.findElement(By.xpath("//*[@id=\"wait\"]/input")).click();

        //显示等待
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"display\"]/div")));

        Thread.sleep(3000);
        String text = driver.findElement(By.xpath("//*[@id=\"display\"]/div")).getText();
        Assert.assertEquals(text,"wait for display");
    }

    @AfterMethod
    public void closeChrome(){
        driver.quit();
    }
}
