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
        csvFilter.getReportListCsv();
        if (csvFilter.getReportListCsv() != null) {
            reportList.add(csvFilter.getReportListCsv());
            System.out.println(csvFilter.getReportListCsv().length);
            System.out.println(csvFilter.getReportListCsv()[0]);
            System.out.println(csvFilter.getReportListCsv()[1]);
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

        /*
        Сделать проверку корзины и ее очистку по запросу.
         */

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
//            for (WebElement x : products) {
//                System.out.println("Несколько товаров" + x + "--" + goodsName);
//            }

            // проверяем на наличие товара
            List<WebElement> product = driver.findElements(By.className("product"));

            // проверяем на ниличие выбора размера
            List<WebElement> size = driver.findElements(By.className("b1c_option"));
//            for (WebElement x : size) {
//                System.out.println("выбора размера" + x.getText() + "--" + goodsName);
//            }

            // если товара в поисковике более 1шт
            if (products.size() > 0) {
                //noFindList.add(goodsName);
                System.out.println("Товаров более 1шт." + goodsName);
                String[] noFind = {goodsName, "товаров более 1шт."};
                reportList.add(noFind);

                // если товар есть
            } else if (product.size() > 0) {

                // если надо выбрать размер
                if (size.get(0).getText().length() > 0) {

                    CommandSelectSize selectSize = new CommandSelectSize(driver, addGoods);
                    selectSize.commandSelectSize(goodsName, goodsSize, intGoodsPrice, goodsItem);
                    reportList.add(selectSize.getReportList());
//                    if (selectSize.getReportList() != null) {
//                        reportList.add(selectSize.getReportList());
//                        System.out.println(selectSize.getReportList().length);
//                        System.out.println(selectSize.getReportList()[0]);
//                        System.out.println(selectSize.getReportList()[1]);
//                    }

//                    WebElement size2 = driver.findElement(By.className("b1c_option"));
//                    if (size2.getText().contains(goodsSize)) {
//                        Select select1 = new Select(size2);
//                        select1.selectByVisibleText(goodsSize);  // выбираем размер
//
//                        CheckPrice check = new CheckPrice(driver, intGoodsPrice);
//                        if (check.checkPrice()) {
//                            addGoods.addGoods(goodsItem);  // товар найден, добавляем в корзину
//                            System.out.println(goodsName);
//                            System.out.println("успешно выбран");
//
//                        } else reportList.add(check.getCheckPrice(goodsName));
//
//                    } else {
//                        String[] noFind = {goodsName, "ошибка товара с размером"};
//                        reportList.add(noFind);
//                        System.out.println("Не выбрал размер");
//                    }


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

        //driver.close();  //закрываем браузер по завершению

        System.out.println("Кол-во товаров в отчете: " + reportList.size());
        System.out.println("*******************************************");
        for (String[] x : reportList) {
            System.out.println(x.length + "***" + x[0] + "**" + x[1]);
        }
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
