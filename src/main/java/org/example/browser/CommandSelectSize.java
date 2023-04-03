package org.example.browser;

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


    public void commandSelectSize(String goodsName, String goodsSize, int intGoodsPrice, String goodsItem) {

        WebElement size2 = driver.findElement(By.className("b1c_option"));

        String text = size2.getText();
        //System.out.println(goodsName + "*****Выбор размера*****" + size2.getText() + "--" + goodsSize);
        //System.out.println(size2.getText().contains(goodsSize));
        if (text.contains(goodsSize)) {

            Select select1 = new Select(size2);
            select1.selectByVisibleText(goodsSize);  // выбираем размер

            CheckPrice check = new CheckPrice(driver, intGoodsPrice);
            if (check.checkPrice()) {
                addGoods.addGoods(goodsItem);  // товар найден, добавляем в корзину
                //System.out.println(goodsName);

            } else reportList = check.getErrorPrice(goodsName);

        } else {
            reportList = new String[]{goodsName, "ошибка товара с размером"};

            //System.out.println("Не выбрал размер");
        }
    }

    public String[] getReportList() {
        return reportList;
    }
}
