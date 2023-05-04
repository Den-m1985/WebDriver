package org.example.browser.clickAndSend;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitConditionalElement {


    public WebElement waitDriver(WebDriverWait wait, String str){
        return wait.until(ExpectedConditions.elementToBeClickable(By.xpath(str)));
    }
}
