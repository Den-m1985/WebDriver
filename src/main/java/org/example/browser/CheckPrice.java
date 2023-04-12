package org.example.browser;

import org.example.TextLinks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckPrice {

    private final WebDriver driver;
    private final int intGoodsPrice;
    int procent;


    public CheckPrice(WebDriver driver, int intGoodsPrice) {
        this.driver = driver;
        this.intGoodsPrice = intGoodsPrice;

    }

    public boolean checkPrice() {

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
