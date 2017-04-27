package com.xuxiaobo.tencent.Day02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by Administrator on 2017/4/27 0027.
 */
public class ActionTest2 {

    WebDriver driver;

    @BeforeMethod
    public void openChrome(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Administrator\\IdeaProjects\\SELENIUM_TEST\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    /*
    * 打开百度页面
    * 在百度一下按钮上右键
    * */
    @Test
    public void rightClickTest() throws InterruptedException {
        driver.get("http://www.baidu.com");
        WebElement btn = driver.findElement(By.id("su"));
        //实例化Actions
        Actions actions = new Actions(driver);
        //在百度一下按钮上右键
        actions.contextClick(btn).perform();
        Thread.sleep(3000);
    }

    /*
    * 打开百度页面
    * 双击百度一下按钮
    * */
    @Test
    public void doubleClickTest(){
        driver.get("http://www.baidu.com");
        WebElement btn = driver.findElement(By.id("su"));
        Actions actions = new Actions(driver);
        actions.doubleClick(btn).perform();
    }

    /*
    * 打开测试页面
    * 鼠标移动到action按钮
    * 那么显示hello world*/
    @Test
    public void moveToElementTest() throws InterruptedException {
        driver.get("file:///D:/selenium_html/index.html");
        WebElement btn = driver.findElement(By.xpath("//*[@id=\"action\"]/input"));
        Actions actions = new Actions(driver);
        actions.moveToElement(btn).perform();
        Thread.sleep(3000);
        String text = driver.findElement(By.xpath(".//*[text()='Hello World!']")).getText();
        Assert.assertEquals(text,"Hello World!");
    }

    @Test
    public void dragTest() throws InterruptedException {
        driver.get("file:///D:/selenium_html/dragAndDrop.html");
        WebElement element = driver.findElement(By.id("drag"));
        Actions actions = new Actions(driver);
        actions.dragAndDropBy(element,500,500).perform();
        Thread.sleep(5000);
    }

    @Test
    public void dragToEleTest() throws InterruptedException {
        driver.get("file:///D:/selenium_html/dragAndDrop.html");
        WebElement ele1 = driver.findElement(By.id("drag"));
        WebElement ele2 = driver.findElement(By.xpath("/html/body/h1"));
        Actions actions = new Actions(driver);
        actions.dragAndDrop(ele1,ele2).perform();
        Thread.sleep(5000);
    }


    @Test
    public void saveTest() throws AWTException, InterruptedException {
        driver.get("http://www.baidu.com");
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_S);
        Thread.sleep(5000);
    }

    @Test
    public void uploadTest() throws InterruptedException {
        driver.get("file:///D:/selenium_html/index.html");
        driver.findElement(By.id("load"))
                .sendKeys("D:\\1.jpg");
        Thread.sleep(5000);
    }

    @AfterMethod
    public void closeChrome(){
        driver.quit();
    }
}


