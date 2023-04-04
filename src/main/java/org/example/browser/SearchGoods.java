package org.example.browser;

import org.example.TextLinks;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchGoods {

    private final WebDriverWait wait;

    public SearchGoods(WebDriverWait wait) {
        this.wait = wait;
    }


    public void searchProduct(String article, WebDriver driver) throws InterruptedException {

        XPathWait pathWait = new XPathWait(wait);

        TextLinks LinksSearch = TextLinks.SEARCHFIELD;
        WebElement search = pathWait.xPath(LinksSearch.getString());

        new ClowdWindow(driver);

        search.click();

        new ClowdWindow(driver);

        search.sendKeys(article);

        new ClowdWindow(driver);

        TextLinks linkButtonSearch = TextLinks.BUTTONSEARCH;
        WebElement buttonSearch = pathWait.xPath(linkButtonSearch.getString());

        new ClowdWindow(driver);

        buttonSearch.click();

        new ClowdWindow(driver);

    }

}
