package org.example.browser;

import org.example.TextLinks;
import org.example.browser.chrome.XPathWait;
import org.openqa.selenium.WebElement;

public class AddGoods {


    public AddGoods(int item) throws InterruptedException {
        XPathWait pathWait = new XPathWait();

        WebElement search;

        TextLinks linkAddItem = TextLinks.ADDITEM;
        //search = pathWait.xPath(linkAddItem.getString());
        search = pathWait.xPathVisibility(linkAddItem.getString());
        search.click();



        new ClowdWindow();

        search.clear();
        String strItem = String.valueOf(item);
        search.sendKeys(strItem);

        new ClowdWindow();

        TextLinks linkClickBay = TextLinks.CLICKBAY;
        WebElement buttonSearch = pathWait.xPath(linkClickBay.getString());
        buttonSearch.click();

        new ClowdWindow();

        TextLinks linkCloseWindow = TextLinks.CLOSEWINDOW;
        WebElement buttonClose = pathWait.xPath(linkCloseWindow.getString());
        buttonClose.click();

        new ClowdWindow();
    }

}
