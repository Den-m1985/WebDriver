package org.example.browser;

import org.example.TextLinks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckPrice {

    private WebDriver driver;
    private int intGoodsPrice;

    public CheckPrice(WebDriver driver, int intGoodsPrice) {
        this.driver = driver;
        this.intGoodsPrice = intGoodsPrice;
    }

    public boolean checkPrice(){

        TextLinks priceField = TextLinks.PRICE;
        WebElement priceClass = driver.findElement(By.cssSelector(priceField.getString()));
        String[] x = priceClass.getText().split("\\.");
        int intParsePrice = Integer.parseInt(x[0]);
        System.out.println("price--" + priceClass.getText() + "**" + intParsePrice + "**" + intGoodsPrice);
        System.out.println(intGoodsPrice == intParsePrice);
        System.out.println("****************************************");

        return false;
    }

}
