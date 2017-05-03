package com.xuxiaobo.tencent.Day03;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;


/**
 * Created by Administrator on 2017/5/2 0002.
 */
public class GridTest {
    @Test
    public void testGrid01() throws MalformedURLException, InterruptedException {
        //创建一个DesiredCapabilities的类型
        DesiredCapabilities dc = DesiredCapabilities.chrome();
        //实例化一个Driver并且新建一个RemoteWebDriver
        WebDriver driver = new RemoteWebDriver(new URL("http://localhost:8888/wd/hub"),dc);

        driver.get("http://www.baidu.com");
        Thread.sleep(5000);
        driver.quit();
    }

    @DataProvider(name = "data")
    public Object[][] testData(){
        return new Object[][]{
                {"firefox","http://localhost:4000"},
                {"chrome","http://localhost:8888"}
        };
    }

    @Test(dataProvider = "data")
    public void testGrid02(String browser, String url) throws MalformedURLException, InterruptedException {
        DesiredCapabilities dc = null;
        if (browser.equals("firefox")){
            dc = DesiredCapabilities.firefox();
        }else if(browser.equals("chrome")){
            dc = DesiredCapabilities.chrome();
        }else{
            System.out.println("error");
        }
        WebDriver driver = new RemoteWebDriver(new URL(url+"/wd/hub"),dc);
        driver.get("http://www.baidu.com");
        Thread.sleep(5000);
        driver.quit();
    }

}
