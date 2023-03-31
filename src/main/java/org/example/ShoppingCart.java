package org.example;

import org.example.browser.XPathWait;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShoppingCart {


    private final WebDriverWait wait;

    public ShoppingCart(WebDriverWait wait) {
        this.wait = wait;
    }


    void deleteGoodsInCart() {

        XPathWait pathWait = new XPathWait(wait);

        TextLinks linkButtonSearch = TextLinks.BUTTONSEARCH;
        WebElement buttonSearch = pathWait.xPath(linkButtonSearch.getString());
        buttonSearch.click();

    }


}
