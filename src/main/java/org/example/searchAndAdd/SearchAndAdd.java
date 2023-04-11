package org.example.searchAndAdd;

import org.example.browser.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SearchAndAdd {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final List<String[]> reportList;

    public SearchAndAdd(WebDriver driver, WebDriverWait wait, List<String[]> reportList) {
        this.driver = driver;
        this.wait = wait;
        this.reportList = reportList;
    }

    public void executeProcess(String goodsName, String goodsSize, int intGoodsPrice, String goodsItem) throws InterruptedException {

        AddGoods addGoods = new AddGoods(wait);
        SearchGoods searchGoods = new SearchGoods(wait);


        new ClowdWindow(driver);

        // Search goods
        searchGoods.searchProduct(goodsName, driver);

        new ClowdWindow(driver);

        // находим несколько имен в поисковике
        List<WebElement> products = driver.findElements(By.className("products"));

        // проверяем на наличие товара
        List<WebElement> product = driver.findElements(By.className("product"));

        // проверяем на ниличие выбора размера
        List<WebElement> size = driver.findElements(By.className("b1c_option"));

        // если товара в поисковике более 1шт
        if (products.size() > 0) {
            //System.out.println("Товаров более 1шт." + goodsName);
            String[] noFind = {goodsName, "товаров более 1шт."};
            reportList.add(noFind);

            // если товар есть
        } else if (product.size() > 0) {

            // если надо выбрать размер
            if (size.get(0).getText().length() > 0) {

                CommandSelectSize selectSize = new CommandSelectSize(driver, addGoods);
                selectSize.commandSelectSize(goodsName, goodsSize, intGoodsPrice, goodsItem);
                new ClowdWindow(driver);

                if (selectSize.getReportList() != null) {
                    reportList.add(selectSize.getReportList());
                }

            } else {
                CheckPrice check = new CheckPrice(driver, intGoodsPrice);
                if (check.checkPrice()) {
                    addGoods.addGoods(goodsItem, driver);  // товар найден, добавляем в корзину
                    new ClowdWindow(driver);
                }
            }
        } else {
            String[] noFind = {goodsName, "товар НЕ найден"};
            reportList.add(noFind);
        }
    }


}
