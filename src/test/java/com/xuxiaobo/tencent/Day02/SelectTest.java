package com.xuxiaobo.tencent.Day02;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;

/**
 * Created by Administrator on 2017/4/27 0027.
 */
public class SelectTest {
    WebDriver driver;
    @BeforeMethod
    public void openChrome(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Administrator\\IdeaProjects\\SELENIUM_TEST\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    /*
    * 打开测试页面
    * 下拉框选择vivo
    * 第二次选择huawei
    * 第三次选择iphone
    * */

    @Test
    public void selectTest() throws InterruptedException {
        driver.get("file:///D:/selenium_html/index.html");
        WebElement selectEle = driver.findElement(By.id("moreSelect"));
        //实例化Select类
        Select select = new Select(selectEle);
        //通过索引选择下拉框
        select.selectByIndex(2);
        Thread.sleep(2000);
        //通过属性Value值来选择下拉框
        select.selectByValue("huawei");
        Thread.sleep(2000);
        //通过文本值来选择下拉框
        select.selectByVisibleText("iphone");
        Thread.sleep(2000);
    }

    @Test
    public void mutiSelectTest() throws InterruptedException {
        driver.get("file:///D:/selenium_html/index.html");
        WebElement element = driver.findElement(By.id("selectWithMultipleEqualsMultiple"));
        List<WebElement> list = driver.findElements(By.xpath("//*[@id=\"selectWithMultipleEqualsMultiple\"]/option"));
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.SHIFT)
                .click(list.get(2))
                .perform();
        Thread.sleep(5000);
    }

    @Test
    public void crossSelectTest() throws InterruptedException {
        driver.get("file:///D:/selenium_html/index.html");
        WebElement element = driver.findElement(By.id("selectWithMultipleEqualsMultiple"));
        List<WebElement> list = driver.findElements(By.xpath("//*[@id=\"selectWithMultipleEqualsMultiple\"]/option"));
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.CONTROL)
                .click(list.get(3))
                .perform();
        Thread.sleep(5000);
    }

    @AfterMethod
    public void closeChrome(){
        driver.quit();
    }

}
