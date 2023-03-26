package org.example.browser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class XPathWait {
    private final WebDriverWait wait;

    public XPathWait(WebDriverWait wait) {
        this.wait = wait;
    }

    public WebElement xPath(String str){
        return wait.until(ExpectedConditions.elementToBeClickable(By.xpath(str)));
    }
}
