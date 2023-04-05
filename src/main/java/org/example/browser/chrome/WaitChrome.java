package org.example.browser.chrome;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitChrome {

    public WebDriverWait waitChromeBrowser(WebDriver driver) {

        /*
        Таким образом, если элемент не найден, то драйвер будет ждать его появления
        в течении заданного времени (10 секунд) и шагом в 500 мс.
        Как только элемент будет найден, драйвер продолжит работу, однако,
        в противном случае тест упадем по истечению времени
         */
        Duration duration = Duration.ofSeconds(10);

        return new WebDriverWait(driver, duration);
    }
}
