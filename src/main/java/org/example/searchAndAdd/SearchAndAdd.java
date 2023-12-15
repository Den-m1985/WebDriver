package org.example.searchAndAdd;

import org.example.browser.*;
import org.example.browser.chrome.DriverChrome;
import org.example.csvRead.csv.StructureCSV;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchAndAdd {
    private final List<String[]> reportList;

    public SearchAndAdd(List<String[]> reportList) {
        this.reportList = reportList;
    }

    public void executeProcess(StructureCSV goods) throws InterruptedException {
        WebDriver driver = DriverChrome.getChromeDriver();

        String goodsName = goods.getName();
        String goodsSize = goods.getArtucul();
        int intGoodsPrice = goods.getPrice();
        int goodsItem = goods.getItem();

        new ClowdWindow();

        // Search goods
        new SearchGoods(goodsName);

        new ClowdWindow();

        // находим несколько имен в поисковике
        List<WebElement> products = driver.findElements(By.className("products"));

        // проверяем на наличие товара
        List<WebElement> product = driver.findElements(By.className("product"));

        // проверяем на ниличие выбора размера
        List<WebElement> size = driver.findElements(By.className("b1c_option"));
        //System.out.println("goodsName---" + goodsName);
        // если товара в поисковике более 1шт
        if (products.size() > 0) {
            //System.out.println("Если товара более 1--" + product.size());
            // работаем с несколькими товарами
            new ManyGoods(products, goodsName);
            String[] noFind = {goodsName, "товаров более 1шт."};
            reportList.add(noFind);

            // если товар есть
        } else if (product.size() > 0) {
            //System.out.println("Если товара есть--" + product.size());
            // если надо выбрать размер
            if (size.get(0).getText().length() > 0) {
                CommandSelectSize selectSize = new CommandSelectSize(goodsName, goodsSize, intGoodsPrice, goodsItem);
                new ClowdWindow();

                if (selectSize.getReportList() != null) {
                    reportList.add(selectSize.getReportList());
                }

            } else {
                CheckPrice check = new CheckPrice(intGoodsPrice);
                if (check.checkPrice()) {
                    new AddGoods(goodsItem);  // товар найден, добавляем в корзину
                    new ClowdWindow();
                } else reportList.add(check.getErrorPrice(goodsName));
            }
        } else {
            String[] noFind = {goodsName, "товар НЕ найден"};
            reportList.add(noFind);
        }
    }

}
