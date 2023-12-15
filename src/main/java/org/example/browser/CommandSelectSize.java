package org.example.browser;

import org.example.browser.checkSize.AnalyzeText;
import org.example.browser.chrome.DriverChrome;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CommandSelectSize {
    private String[] reportList;


    public CommandSelectSize(String goodsName, String goodsSize, int intGoodsPrice, int goodsItem) {
        WebDriver driver = DriverChrome.getChromeDriver();
        WebElement size = driver.findElement(By.className("b1c_option"));

        String text = size.getText();

        /*
        частая ошибка, что спарсено не так как с сайта
        то вместо запятой /
        то регистры разные
        здесь исправляем все эти косяки
         */
        String res = new AnalyzeText().substituteValues(goodsSize, text);

        try {
            Select select = new Select(size);
            select.selectByVisibleText(res);  // выбираем размер

            new ClowdWindow();

            CheckPrice check = new CheckPrice(intGoodsPrice);
            if (check.checkPrice()) {
                new AddGoods(goodsItem);  // товар найден, добавляем в корзину
            } else reportList = check.getErrorPrice(goodsName);

        } catch (Exception e) {
            reportList = new String[]{goodsName, "ошибка товара с размером"};
        }
    }

    public String[] getReportList() {
        return reportList;
    }
}
