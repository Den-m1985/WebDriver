package org.example.browser;

import org.example.TextLinks;
import org.example.browser.chrome.XPathWait;
import org.openqa.selenium.WebElement;

public class ShoppingCart {


    public void clickCart() {
        XPathWait pathWait = new XPathWait();
        TextLinks linkCart = TextLinks.FIELDCART;
        WebElement buttonSearch = pathWait.xPath(linkCart.getString());
        buttonSearch.click();
    }


    public void countGoodsInCart() {
        /*
        Не удается сделать подсчет кол-ва товара в корзине.
         */
    }

}
