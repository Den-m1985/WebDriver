package org.example.browser;

import org.example.TextLinks;
import org.example.browser.chrome.DriverChrome;
import org.openqa.selenium.WebDriver;

public class OpenWebSite {

    public OpenWebSite() {
        WebDriver driver = DriverChrome.getChromeDriver();
        String webAddress = TextLinks.ADDRESS.getString();
        driver.get(webAddress);
    }

}
