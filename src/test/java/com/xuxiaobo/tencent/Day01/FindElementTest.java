package com.xuxiaobo.tencent.Day01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;


/**
 * 自动化测试学习D01
 */
public class FindElementTest {

    WebDriver driver;

    @BeforeMethod
    public void openChrome(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Administrator\\IdeaProjects\\seleniumtest\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void locateById(){
        driver.get("http://www.baidu.com");
        driver.findElement(By.id("kw")).sendKeys("selenium");
    }

    @Test
    public void locateByName(){
        driver.get("http://www.baidu.com");
        driver.findElement(By.name("wd")).sendKeys("selenium");
    }

    @Test
    public void locateByClass(){
        driver.get("http://www.baidu.com");
        driver.findElement(By.name("wd")).sendKeys("hjj");
        driver.findElement(By.className("s_btn")).click();
    }

    @Test
    public void locateByLinkText(){
        driver.get("http://www.baidu.com");
        driver.findElement(By.linkText("糯米")).click();
    }

    @Test
    public void locateByPartialLinkText(){
        driver.get("http://www.baidu.com");
        driver.findElement(By.partialLinkText("闻")).click();
    }

    @Test
    public void locateByXpath(){
        driver.get("http://www.baidu.com");
        driver.findElement(By.xpath(".//input[@id='su']")).click();
    }

    @Test
    public void locateByXpath02(){
        driver.get("http://www.baidu.com");
        List<WebElement> list = driver.findElements(By.xpath(".//*[@id='u1']/a"));
        for (int i = 0; i < list.size(); i++) {
            String text = list.get(i).getText();
            System.out.println(text);
        }
    }

    @AfterMethod
    public void closeChrome(){
        //driver.quit();
    }

}
