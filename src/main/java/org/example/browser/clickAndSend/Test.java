package org.example.browser.clickAndSend;

import org.example.TextLinks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test {


    public Test(WebDriverWait wait, WebDriver driver) {


        TextLinks linkAddItem = TextLinks.ADDITEM;
        String str = linkAddItem.getString();
        WebElement search = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(str)));
        search.click();
        search.sendKeys();


        driver.findElement(By.id("fancybox-close")).click();


    }


}
