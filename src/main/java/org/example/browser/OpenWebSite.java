package org.example.browser;

import org.example.TextLinks;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class OpenWebSite {
    //public WebDriver driver;


    public OpenWebSite(WebDriver driver) {
        //PageFactory.initElements(driver, this);
        //this.driver = driver;
        TextLinks textLinks = TextLinks.ADDRESS;
        driver.get(textLinks.getString());
        //openSite();
    }


//    void openSite(){
//        TextLinks textLinks = TextLinks.ADDRESS;
//        driver.get(textLinks.getString());
//    }

}
