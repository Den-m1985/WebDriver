package org.example.browser;

import org.example.TextLinks;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchGoods {

    private final WebDriverWait wait;

    public SearchGoods(WebDriverWait wait) {
        this.wait = wait;
    }


    public void searchProduct(String article) {

        XPathWait pathWait = new XPathWait(wait);

        TextLinks LinksSearch = TextLinks.SEARCHFIELD;
        WebElement search = pathWait.xPath(LinksSearch.getString());
        search.click();
        search.sendKeys(article);

        TextLinks linkButtonSearch = TextLinks.BUTTONSEARCH;
        WebElement buttonSearch = pathWait.xPath(linkButtonSearch.getString());
        buttonSearch.click();

    }

}
