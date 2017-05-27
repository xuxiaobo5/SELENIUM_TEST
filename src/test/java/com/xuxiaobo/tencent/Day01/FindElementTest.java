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
        String path = System.getProperty("user.dir");
        System.setProperty( "webdriver.chrome.driver", path +"\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    //通过ID定位
    @Test
    public void locateByIdTest(){
        driver.get("http://www.baidu.com");
        driver.findElement(By.id("kw")).sendKeys("selenium");
    }

    //通过Name定位
    @Test
    public void locateByNameTest(){
        driver.get("http://www.baidu.com");
        driver.findElement(By.name("wd")).sendKeys("selenium");
    }

    //通过ClassName定位
    @Test
    public void locateByClassTest(){
        driver.get("http://www.baidu.com");
        driver.findElement(By.name("wd")).sendKeys("hjj");
        driver.findElement(By.className("s_btn")).click();
    }

    //通过文本定位
    @Test
    public void locateByLinkTextTest(){
        driver.get("http://www.baidu.com");
        driver.findElement(By.linkText("糯米")).click();
    }

    //通过部分文本定位
    @Test
    public void locateByPartialLinkTextTest(){
        driver.get("http://www.baidu.com");
        driver.findElement(By.partialLinkText("闻")).click();
    }

    //通过Xpath定位
    @Test
    public void locateByXpathTest01(){
        driver.get("http://www.baidu.com");
        driver.findElement(By.xpath(".//input[@id='su']")).click();
    }

    //通过Xpath定位
    @Test
    public void locateByXpathTest02(){
        driver.get("http://www.baidu.com");
        List<WebElement> list = driver.findElements(By.xpath(".//*[@id='u1']/a"));
        for (int i = 0; i < list.size(); i++) {
            String text = list.get(i).getText();
            System.out.println(text);
        }
    }

    //通过TagName定位
    @Test
    public void locateByTagNameTest(){
        driver.get("http://www.baidu.com");
        List<WebElement> list = driver.findElements(By.tagName("input"));
        System.out.println(list.size());
    }

    //通过css selector定位
    @Test
    public void locateByCss(){
        driver.get("http://www.baidu.com");
        driver.findElement(By.cssSelector("#kw"));
    }

    @AfterMethod
    public void closeChrome(){
        driver.quit();
    }

}
