package org.example;

import com.opencsv.exceptions.CsvException;
import org.example.browser.*;
import org.example.csvRead.CsvFilter;
import org.example.oldExel.WrightOldExelArticul;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Command {
    private List<String[]> reportList;

    public Command() {
    }

    public void startProgram(String pathCSV) throws IOException, CsvException {

        long start = System.nanoTime();

        reportList = new ArrayList<>();

        // Read csv
        int cellName = 0;   // Cell with name or articular
        int cellItem = 3;   // Cell with item to order
        CsvFilter csvFilter = new CsvFilter(pathCSV);
        List<String[]> data = csvFilter.csvFilter(cellName, cellItem);
        if (csvFilter.getReportListCsv() != null) {
            reportList.addAll(csvFilter.getReportListCsv());
        }

        // Open browser
        OpenChromeBrowser openBrowser = new OpenChromeBrowser();
        openBrowser.openChrome();
        WebDriver driver = openBrowser.getDriver();
        WebDriverWait wait = openBrowser.getWait();

        // Open website
        new OpenWebSite(driver);

        // login account
        new LoginPage(wait);

        // delete shoping cart  TO DO
        List<WebElement> goodsInCart = driver.findElements(By.className("cart"));
        ShoppingCart shoppingCart = new ShoppingCart(wait);
        for (WebElement x:goodsInCart) {
            System.out.println(x.getText());
        }
        if (goodsInCart.size() > 0) {
            shoppingCart.deleteGoodsInCart();
        }

        AddGoods addGoods = new AddGoods(wait);
        SearchGoods searchGoods = new SearchGoods(wait);

        for (String[] goods : data) {
            String goodsName = goods[0];
            String goodsSize = goods[1];
            int intGoodsPrice = Integer.parseInt(goods[2]);
            String goodsItem = goods[3];


            // Надо реализовать - если всплывает окно, то нужно закрыть, а упадем в ошибку.
            //WebElement cloudWindow = driver.findElement(By.id("fancybox-wrap"));
            //TextLinks closeWindow = TextLinks.CLOSEWINDOW;
            //cloudWindow.findElement(By.xpath(closeWindow.getString())).click();
            // хотя если программа работает, то и окго не выходит.

            // Search goods
            searchGoods.searchProduct(goodsName);

            // находим несколько имен в поисковике
            List<WebElement> products = driver.findElements(By.className("products"));

            // проверяем на наличие товара
            List<WebElement> product = driver.findElements(By.className("product"));

            // проверяем на ниличие выбора размера
            List<WebElement> size = driver.findElements(By.className("b1c_option"));

            // если товара в поисковике более 1шт
            if (products.size() > 0) {
                System.out.println("Товаров более 1шт." + goodsName);
                String[] noFind = {goodsName, "товаров более 1шт."};
                reportList.add(noFind);

                // если товар есть
            } else if (product.size() > 0) {

                // если надо выбрать размер
                if (size.get(0).getText().length() > 0) {

                    CommandSelectSize selectSize = new CommandSelectSize(driver, addGoods);
                    selectSize.commandSelectSize(goodsName, goodsSize, intGoodsPrice, goodsItem);
                    if (selectSize.getReportList() != null) {
                        reportList.add(selectSize.getReportList());
                        //System.out.println(selectSize.getReportList().length);
                        //System.out.println(selectSize.getReportList()[0]);
                        //System.out.println(selectSize.getReportList()[1]);
                    }

                } else {
                    System.out.println(goodsName);
                    CheckPrice check = new CheckPrice(driver, intGoodsPrice);
                    if (check.checkPrice())
                        addGoods.addGoods(goodsItem);  // товар найден, добавляем в корзину
                }

            } else {
                //noFindList.add(goodsName);
                String[] noFind = {goodsName, "товар НЕ найден"};
                reportList.add(noFind);
            }
        }
        // по завершению заходим в корзину
        shoppingCart.clickCart();
        //driver.close();  //закрываем браузер по завершению

        new WrightOldExelArticul(reportList);

        long end = System.nanoTime();
        long a = end - start;
        long time = a / 1000000000;

        System.out.println();
        System.out.println("_________У С П Е Ш Н О________");
        System.out.println();
        System.out.println("Время выполнения: " + time / 60 + "мин " + time % 60 + "сек");
        System.out.println("_________Оля молодец_________");
        System.out.println();
        System.out.println("_________Попей чайку_________");
        System.out.println();
    }


}
