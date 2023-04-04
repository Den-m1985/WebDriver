package org.example.browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class OpenChromeBrowser {
    private WebDriver driver;
    private WebDriverWait wait;

    public OpenChromeBrowser() {
    }

    public WebDriver getDriver() {
        return driver;
    }

    public WebDriverWait getWait() {
        return wait;
    }

    public void openChrome() {

        String chromedriver = System.getProperty("user.home") + File.separator +
                "chromedriver_win32"+"\\" + "chromedriver.exe";

        // установливаем зависимость, определяющую путь к chromedriver
        ChromeOptions options = new ChromeOptions();
        System.setProperty("webdriver.chrome.driver", chromedriver);
        options.addArguments("--remote-allow-origins=*");


        //options.addArguments("--user-agent='Mozilla/5.0 (Windows Phone 10.0; Android 4.2.1; Microsoft; Lumia 640 XL LTE) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/42.0.2311.135 Mobile Safari/537.36 Edge/12.10166'");
        //options.addArguments("--user-agent='Mozilla/5.0 (Windows NT 4.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/37.0.2049.0 Safari/537.36'");
        //options.addArguments("--user-agent='Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/33.0.1750.517 Safari/537.36'");
        options.addArguments("--user-agent='Mozilla/5.0 (Macintosh; Intel Mac OS X 10_8_2) AppleWebKit/537.17 (KHTML, like Gecko) Chrome/24.0.1309.0 Safari/537.17'");

        //options.setBrowserName(java.lang.String browserName)
        //options.setPlatform(Platform platform)
        //options.setVersion(java.lang.String version)

        driver = new ChromeDriver(options);


        /*
        Таким образом, если элемент не найден, то драйвер будет ждать его появления
        в течении заданного времени (10 секунд) и шагом в 500 мс.
        Как только элемент будет найден, драйвер продолжит работу, однако,
        в противном случае тест упадем по истечению времени
         */
        Duration duration = Duration.ofSeconds(10);
        wait = new WebDriverWait(driver, duration);

        //ожидание каждый раз когда выполняется команда на сайте
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //driver.manage().window().fullscreen();  // не работает на полный экран
    }

}
