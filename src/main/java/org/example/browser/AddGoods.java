package org.example.browser;

import org.example.TextLinks;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddGoods {
    private final WebDriverWait wait;


    public AddGoods(WebDriverWait wait) {
        this.wait = wait;
    }


    public void addGoods(String item,  WebDriver driver) throws InterruptedException {

        XPathWait xPathWait = new XPathWait(wait);

        TextLinks linkAddItem = TextLinks.ADDITEM;
        WebElement search = xPathWait.xPath(linkAddItem.getString());
        search.click();

        new ClowdWindow(driver);

        search.clear();
        search.sendKeys(item);

        new ClowdWindow(driver);

        TextLinks linkClickBay = TextLinks.CLICKBAY;
        WebElement buttonSearch = xPathWait.xPath(linkClickBay.getString());
        buttonSearch.click();

        new ClowdWindow(driver);

        TextLinks linkCloseWindow = TextLinks.CLOSEWINDOW;
        WebElement buttonClose = xPathWait.xPath(linkCloseWindow.getString());
        buttonClose.click();

        new ClowdWindow(driver);

    }

}
