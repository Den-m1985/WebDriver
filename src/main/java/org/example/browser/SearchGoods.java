package org.example.browser;

import org.example.TextLinks;
import org.example.browser.chrome.XPathWait;
import org.openqa.selenium.WebElement;

public class SearchGoods {


    public SearchGoods(String article) throws InterruptedException {
        XPathWait pathWait = new XPathWait();

        TextLinks LinksSearch = TextLinks.SEARCHFIELD;
        WebElement search = pathWait.xPath(LinksSearch.getString());

        new ClowdWindow();

        search.click();

        new ClowdWindow();

        search.sendKeys(article);

        new ClowdWindow();

        TextLinks linkButtonSearch = TextLinks.BUTTONSEARCH;
        WebElement buttonSearch = pathWait.xPath(linkButtonSearch.getString());

        new ClowdWindow();

        buttonSearch.click();

        new ClowdWindow();
    }

}
