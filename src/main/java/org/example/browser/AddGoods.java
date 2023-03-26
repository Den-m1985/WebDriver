package org.example.browser;

import org.example.TextLinks;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddGoods {
    private final WebDriverWait wait;


    public AddGoods(WebDriverWait wait) {
        this.wait = wait;
    }


    public void addGoods(String item){

        XPathWait xPathWait = new XPathWait(wait);

        TextLinks linkAddItem = TextLinks.ADDITEM;
        WebElement search = xPathWait.xPath(linkAddItem.getString());
        search.click();
        search.clear();
        search.sendKeys(item);

        TextLinks linkClickBay = TextLinks.CLICKBAY;
        WebElement buttonSearch = xPathWait.xPath(linkClickBay.getString());
        buttonSearch.click();

        /*
        добавить проверку на всплывающее окно
        if()
        TextLinks linkWindow = TextLinks.CLOUDWINDOW;
         */

        TextLinks linkCloseWindow = TextLinks.CLOSEWINDOW;
        WebElement buttonClose = xPathWait.xPath(linkCloseWindow.getString());
        buttonClose.click();

    }

}
