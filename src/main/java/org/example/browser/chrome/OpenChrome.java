package org.example.browser.chrome;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OpenChrome {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public OpenChrome() {

        DriverChrome driverChrome = new DriverChrome();
       driver = driverChrome.DriverChrome();

        WaitChrome waitChrome = new WaitChrome();
        wait = waitChrome.waitChromeBrowser(driver);

    }

    public WebDriver getDriver() {
        return driver;
    }

    public WebDriverWait getWait() {
        return wait;
    }
}
