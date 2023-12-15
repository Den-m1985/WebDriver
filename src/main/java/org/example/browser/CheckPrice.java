package org.example.browser;

import org.example.TextLinks;
import org.example.browser.chrome.DriverChrome;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckPrice {
    private final int intGoodsPrice;
    int procent;


    public CheckPrice(int intGoodsPrice) {
        this.intGoodsPrice = intGoodsPrice;

    }

    public boolean checkPrice() {
        WebDriver driver = DriverChrome.getChromeDriver();

        TextLinks priceField = TextLinks.PRICE;
        WebElement priceClass = driver.findElement(By.cssSelector(priceField.getString()));
        String[] x = priceClass.getText().split("\\.");
        String webPrice = x[0];

        if (webPrice.contains(" ")) {
            webPrice = webPrice.replaceAll(" ", "");
        }
        int intParsePrice = Integer.parseInt(webPrice);
        procent = (intParsePrice * 100) / intGoodsPrice;
        if (procent < 101) {
            return true;
        }
        return false;
    }

    public String[] getErrorPrice(String goodsName) {
        return new String[]{goodsName, "цена на сайте больше на " + procent + "%"};
    }

}
