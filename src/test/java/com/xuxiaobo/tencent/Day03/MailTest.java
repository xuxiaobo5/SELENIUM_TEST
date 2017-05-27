package com.xuxiaobo.tencent.Day03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2017/4/18 0018.
 */

public class MailTest {
    WebDriver driver;

    @BeforeMethod
    public void openChrome(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Administrator\\IdeaProjects\\SELENIUM_TEST\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://mail.163.com");
    }

    @Test
    public void testSendMail() throws InterruptedException {
        LoginTest.login(driver,"xuxiaobo5","Xxb520Hjj@");
        WebDriverWait wait = new WebDriverWait(driver,10);
        String logoutInfo = wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("退出"))).getText();
        Assert.assertEquals(logoutInfo,"退出");

        //点击写信按钮
        driver.findElement(By.xpath("./*//*[@id='dvNavTop']/ul/li[2]/span[2]")).click();
        //*[@id="_mail_component_68_68"]/span[2]
        //输入收件人地址
        driver.findElement(By.xpath(".//*[@aria-label='收件人地址输入框，请输入邮件地址，多人时地址请以分号隔开']")).sendKeys("234508021@qq.com");
        //输入邮件主题
        driver.findElement(By.xpath("./*//*[@aria-label='邮件主题输入框，请输入邮件主题']/input")).sendKeys("Test Send Email");
        //上传附件
        driver.findElement(By.xpath(".//*[@title='一次可发送2000张照片，600首MP3，一部高清电影']/input")).sendKeys("D:\\1.jpg");
        //定位frame
        WebElement frame = driver.findElement(By.className("APP-editor-iframe"));
        //转交frame控制权
        driver.switchTo().frame(frame);
        //输入内容
        driver.findElement(By.xpath("/html/body")).sendKeys("This is content");
        //转交回去
        driver.switchTo().defaultContent();
        //点击发送按钮
        driver.findElement(By.xpath("./*//*[text()='发送']")).click();
        //校验页面是否出现发送成字样
        Boolean bl = driver.findElement(By.xpath("./*//*[text()='发送成功']")).isDisplayed();
        Assert.assertTrue(bl);
    }

    @AfterMethod
    public void closeChrome(){
        //driver.quit();
    }
}
