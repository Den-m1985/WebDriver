package org.example.browser.clickAndSend;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ClickAndSend{

    private WebDriverWait wait;
    private WaitConditionalElement waitDriver;

    public ClickAndSend(WebDriverWait wait) {
        this.wait = wait;
        waitDriver = new WaitConditionalElement();
    }


    public void click(String str){

        WebElement element = waitDriver.waitDriver(wait, str);
        element.click();
    }

    public void send(String field, String str){
        WebElement element = waitDriver.waitDriver(wait, field);
        element.click();
        element.sendKeys(str);
    }
}
