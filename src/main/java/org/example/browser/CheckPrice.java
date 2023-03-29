package org.example.browser;

import org.example.TextLinks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckPrice {

    private final WebDriver driver;
    private int intGoodsPrice;
    private int intParsePrice;
    int procent;


    public CheckPrice(WebDriver driver, int intGoodsPrice) {
        this.driver = driver;
        this.intGoodsPrice = intGoodsPrice;

    }

    public boolean checkPrice() {

        TextLinks priceField = TextLinks.PRICE;
        WebElement priceClass = driver.findElement(By.cssSelector(priceField.getString()));
        String[] x = priceClass.getText().split("\\.");
        intParsePrice = Integer.parseInt(x[0]);

        procent = (intParsePrice / intGoodsPrice) * 100;
        if (procent < 110) {
            System.out.println("price--" + priceClass.getText() + "**" + intParsePrice + "**" + intGoodsPrice);
            return true;
        }
        return false;
    }

    public String[] getCheckPrice(String goodsName) {
        System.out.println(goodsName + "Процент разницы: цена на сайте / цену с csv " + procent + "%");
        return new String[]{goodsName, "цена на сайте больше на " + procent + "%"};
    }

}
