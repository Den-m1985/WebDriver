package org.example.browser;

import org.example.TextLinks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ClowdWindow {

    public ClowdWindow(WebDriver driver, int i) {

        WebElement cloudWindow = driver.findElement(By.id("dontgo"));
        if (cloudWindow.isDisplayed()) {
            TextLinks closeWindow = TextLinks.CLOSEWINDOW;
            cloudWindow.findElement(By.xpath(closeWindow.getString())).click();
            System.out.println("Попался" + i);
        }
    }
}
