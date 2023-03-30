package org.example.browser;

import org.example.TextLinks;
import org.openqa.selenium.WebDriver;

public class OpenWebSite {


    public OpenWebSite(WebDriver driver) {

        TextLinks textLinks = TextLinks.ADDRESS;
        driver.get(textLinks.getString());
    }


}
