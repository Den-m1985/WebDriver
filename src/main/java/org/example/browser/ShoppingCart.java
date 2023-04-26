package org.example.browser;

import org.example.TextLinks;
import org.example.browser.XPathWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ShoppingCart {
    //private final WebDriverWait wait;
    private final XPathWait pathWait;
    private final WebDriver driver;


    public ShoppingCart(WebDriverWait wait, WebDriver driver) {
        //this.wait = wait;
        this.driver = driver;
        pathWait = new XPathWait(wait);
    }


    public void clickCart() {
        //XPathWait pathWait = new XPathWait(wait);

        TextLinks linkCart = TextLinks.FIELDCART;
        WebElement buttonSearch = pathWait.xPath(linkCart.getString());
        buttonSearch.click();
    }


    void deleteGoodsInCart() {
        //XPathWait pathWait = new XPathWait(wait);

        TextLinks linkButtonSearch = TextLinks.BUTTONSEARCH;
        WebElement buttonSearch = pathWait.xPath(linkButtonSearch.getString());
        buttonSearch.click();
    }


    public void countGoodsInCart() {
        /*
        Не удается сделать подсчет кол-ва товара в корзине.
         */


//        List<WebElement> goodsInCart = driver.findElements(By.id("purchases1"));
//
//        System.out.println("goodsInCart.size()---" + goodsInCart.size());
//        for (WebElement x : goodsInCart) {
//            //System.out.println("x.getText()---" + x.getText());
//            System.out.println(x.findElement(By.className("name")).getText());
//
//        }

//        WebElement buttonSearch = pathWait.xPath("//*[@id=\"purchases1\"]/tbody");
//        System.out.println("buttonSearch.getSize()----" + buttonSearch.getSize());
//        System.out.println("By.className(\"name\")).getText()----" + buttonSearch.findElement(By.className("name")).getText());


//        String count = "";
//        String[] noAdd = {count, "Кол-во товаров"};
        //return noAdd;
    }


}
