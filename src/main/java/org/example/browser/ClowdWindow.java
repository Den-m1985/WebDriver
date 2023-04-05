package org.example.browser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ClowdWindow {

    public ClowdWindow(WebDriver driver) throws InterruptedException {

        WebElement cloudWindow = driver.findElement(By.id("dontgo"));
        if (cloudWindow.isDisplayed()) {
            Thread.sleep(2000);
            WebElement cloudWindowClose = driver.findElement(By.id("fancybox-close"));
            cloudWindowClose.click();
            System.out.println("Закрыл всплывающее окно");

        }
    }
}
