package org.example.browser.chrome;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;

public class DriverChrome {

    public WebDriver DriverChrome() {
        String chromedriver = System.getProperty("user.home") + File.separator +
                "chromedriver_win32"+"\\" + "chromedriver.exe";

        // установливаем зависимость, определяющую путь к chromedriver
        ChromeOptions options = new ChromeOptions();
        System.setProperty("webdriver.chrome.driver", chromedriver);
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-notifications");

        //Used by default, waits for all resources to download
        //options.setPageLoadStrategy(PageLoadStrategy.NORMAL);


        //options.addArguments("--user-agent='Mozilla/5.0 (Windows Phone 10.0; Android 4.2.1; Microsoft; Lumia 640 XL LTE) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/42.0.2311.135 Mobile Safari/537.36 Edge/12.10166'");
        //options.addArguments("--user-agent='Mozilla/5.0 (Windows NT 4.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/37.0.2049.0 Safari/537.36'");
        //options.addArguments("--user-agent='Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/33.0.1750.517 Safari/537.36'");
        options.addArguments("--user-agent='Mozilla/5.0 (Macintosh; Intel Mac OS X 10_8_2) AppleWebKit/537.17 (KHTML, like Gecko) Chrome/24.0.1309.0 Safari/537.17'");

        //options.setBrowserName(java.lang.String browserName)
        //options.setPlatform(Platform platform)
        //options.setVersion(java.lang.String version)

        //ожидание каждый раз когда выполняется команда на сайте
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //driver.manage().window().fullscreen();  // не работает на полный экран

        return new ChromeDriver(options);
    }


}
