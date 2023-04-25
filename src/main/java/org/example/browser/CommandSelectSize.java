package org.example.browser;

import org.example.browser.checkSize.AnalyzeText;
import org.example.searchAndAdd.SearchAndAdd;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CommandSelectSize {
    private final WebDriver driver;
    private final AddGoods addGoods;
    private String[] reportList;

    public CommandSelectSize(WebDriver driver, AddGoods addGoods) {
        this.driver = driver;
        this.addGoods = addGoods;
    }


    public void commandSelectSize(String goodsName, String goodsSize, int intGoodsPrice, int goodsItem) throws InterruptedException {

        WebElement size = driver.findElement(By.className("b1c_option"));

        String text = size.getText();
//        System.out.println("text--------" + text);
//        System.out.println("goodsName*********" + goodsName);
        String res = new AnalyzeText().substituteValues(goodsSize, text);


        try {
            Select select = new Select(size);
            select.selectByVisibleText(res);  // выбираем размер

            new ClowdWindow(driver);

            CheckPrice check = new CheckPrice(driver, intGoodsPrice);
            if (check.checkPrice()) {
                addGoods.addGoods(goodsItem, driver);  // товар найден, добавляем в корзину
            } else reportList = check.getErrorPrice(goodsName);

        } catch (Exception e) {
            reportList = new String[]{goodsName, "ошибка товара с размером"};
        }

//        if (textContain) {
//            Select select = new Select(size);
//            select.selectByVisibleText(res);  // выбираем размер
//
//            new ClowdWindow(driver);
//
//            CheckPrice check = new CheckPrice(driver, intGoodsPrice);
//            if (check.checkPrice()) {
//                addGoods.addGoods(goodsItem, driver);  // товар найден, добавляем в корзину
//            } else reportList = check.getErrorPrice(goodsName);
//
//        } else {
//            reportList = new String[]{goodsName, "ошибка товара с размером"};
//        }
    }

    public String[] getReportList() {
        return reportList;
    }
}
