package org.example;

import org.example.browser.XPathWait;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShoppingCart {


    private final WebDriverWait wait;

    public ShoppingCart(WebDriverWait wait) {
        this.wait = wait;
    }

    public void clickCart() {
        XPathWait pathWait = new XPathWait(wait);

        TextLinks linkCart = TextLinks.FIELDCART;
        WebElement buttonSearch = pathWait.xPath(linkCart.getString());
        buttonSearch.click();
    }


    void deleteGoodsInCart() {
        XPathWait pathWait = new XPathWait(wait);

        TextLinks linkButtonSearch = TextLinks.BUTTONSEARCH;
        WebElement buttonSearch = pathWait.xPath(linkButtonSearch.getString());
        buttonSearch.click();
    }


}
