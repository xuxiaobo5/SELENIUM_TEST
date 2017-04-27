package com.xuxiaobo.tencent.Day02;

import org.apache.commons.io.FileUtils;
import org.apache.xpath.operations.Bool;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

/**
 * Created by Administrator on 2017/4/12 0012.
 */
public class ActionTest1 {

    WebDriver driver;

    @BeforeMethod
    public void openChrome(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Administrator\\IdeaProjects\\SELENIUM_TEST\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    //点击元素
    @Test
    public void clickTest(){
        driver.get("http://www.baidu.com");
        WebElement newslink = driver.findElement(By.name("tj_trnews"));
        newslink.click();
    }

    //输入元素
    @Test
    public void sendKeysTest() throws InterruptedException {
        driver.get("http://www.baidu.com");
        WebElement ele = driver.findElement(By.id("kw"));
        ele.sendKeys("selenium");
        WebElement btn = driver.findElement(By.id("su"));
        btn.click();
        Thread.sleep(5000);
    }

    //获取Title
    @Test
    public void getTitleTest() throws InterruptedException {
        driver.get("http://www.baidu.com");
        WebElement ele = driver.findElement(By.id("kw"));
        ele.sendKeys("selenium");
        WebElement btn = driver.findElement(By.id("su"));
        btn.click();
        Thread.sleep(5000);
        String title = driver.getTitle();
        System.out.println(title);
        Assert.assertEquals(title,"selenium_百度搜索");
    }

    //获取文本
    @Test
    public void getTextTest(){
        driver.get("http://www.baidu.com");
        String news = driver.findElement(By.name("tj_trnews")).getText();
        Assert.assertEquals(news,"新闻");
    }

    //清除文本
    @Test
    public void clearTest() throws InterruptedException {
        driver.get("http://www.baidu.com");
        WebElement ele = driver.findElement(By.id("kw"));
        ele.sendKeys("selenium");
        Thread.sleep(5000);
        ele.clear();
        Thread.sleep(5000);
    }

    //获取TagName
    @Test
    public void getTagNameTest(){
        driver.get("http://www.baidu.com");
        String tagName = driver.findElement(By.id("kw")).getTagName();
        System.out.println(tagName);
        Assert.assertEquals(tagName,"input");
    }

    //获取属性值
    @Test
    public void getAttributeTest(){
        driver.get("http://www.baidu.com");
        String attributeText =  driver.findElement(By.id("su")).getAttribute("value");
        Assert.assertEquals(attributeText,"百度一下");
    }

    //判断元素是否展示
    @Test
    public void isDisplayTest(){
        driver.get("http://www.baidu.com");
        Boolean b = driver.findElement(By.id("su")).isDisplayed();
        Assert.assertTrue(b);
    }

    //判断元素是否选中
    @Test
    public void isSelectTest(){
        driver.get("file:///D:/selenium_html/index.html");
        WebElement element = driver.findElement(By.xpath("//*[@id=\"radio\"]/input[1]"));
        element.click();
        Boolean b = element.isSelected();
        Assert.assertTrue(b);
    }

    //判断元素是否激活
    @Test
    public void isEnableTest(){
        driver.get("file:///D:/selenium_html/index.html");
        Boolean b = driver.findElement(By.name("buttonhtml")).isEnabled();
        Assert.assertFalse(b);
    }

    //截图百度首页
    @Test
    public void shotTest(){
        driver.get("http://www.baidu.com");
        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try{
            FileUtils.copyFile(file,new File(("D:\\test.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @AfterMethod
    public void closeChrome(){
        driver.quit();
    }
}
