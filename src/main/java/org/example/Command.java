package org.example;

import com.opencsv.exceptions.CsvException;
import org.example.browser.*;
import org.example.csvRead.CsvFilter;
import org.example.csvRead.CsvRead;
import org.example.oldExel.WrightOldExelArticul;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Command {

    public Command() {
    }

    public void startProgram(String pathCSV) throws IOException, CsvException {

        long start = System.nanoTime();

        // Open browser
        OpenChromeBrowser openBrowser = new OpenChromeBrowser();
        openBrowser.openChrome();
        WebDriver driver = openBrowser.getDriver();
        WebDriverWait wait = openBrowser.getWait();

        // Open website
        new OpenWebSite(driver);

        // login account
        new LoginPage(wait);

        // Read csv
        int cellName = 0;   // Cell with name or articular
        int cellItem = 3;   // Cell with item to order
        //CsvRead csvRead = new CsvRead(pathCSV);
        //Map<String, String> data = csvRead.readCSV(cellName, cellItem);
        CsvFilter csvFilter = new CsvFilter(pathCSV);
        List<String[]> data = csvFilter.csvFilter(cellName, cellItem);


        //Map<String, String> data2 = new HashMap<>();
        //data2.put("BESTWAY Круг для плавания, 56см, ПВХ, дизайнерский", "5");

        ArrayList<String> noFindList = new ArrayList<>();
        AddGoods addGoods = new AddGoods(wait);
        SearchGoods searchGoods = new SearchGoods(wait);

        //for (Map.Entry<String, String> goods : data.entrySet()) {
        for (String[] goods : data) {
            //String goodsName = goods.getKey();
            String goodsName = goods[0];
            String goodsSize = goods[1];
            String goodsPrice = goods[2];
            String goodsItem = goods[3];


            searchGoods.searchProduct(goodsName);

            // от ChatGPT не работает
            //WebElement searchBox = driver.findElement(By.name("input_search"));
            //searchBox.sendKeys(goods.getKey());
            //searchBox.submit();

            // находим несколько имен в поисковике
            List<WebElement> products = driver.findElements(By.className("products"));

            // проверяем на наличие товара
            List<WebElement> product = driver.findElements(By.className("product"));

            // проверяем на ниличие выбора размера
            List<WebElement> size = driver.findElements(By.className("b1c_option"));
            //int getLength = size.get(0).getText().length();

            //System.out.println(size.size() + "*****" + goodsName);
            // если товара в поисковике более 1шт
            if (products.size() > 0) {
                noFindList.add(goodsName);
                System.out.println("Товаров более 1шт." + goodsName);
                // если товар есть
            } else if (product.size() > 0) {
                // если надо выбрать размер
                if (size.get(0).getText().length() > 0) {
                    TextLinks linkButtonSearch = TextLinks.SIZE;
                    WebElement buttonSearch = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(linkButtonSearch.getString())));
                    buttonSearch.click();
                    buttonSearch.sendKeys(goodsSize);
                    System.out.println(size.get(0).getText().length() + "--" + goodsName);

                }//else addGoods.addGoods(goodsItem);  // товар найден, добавляем в корзину
//                System.out.println();
//                System.out.println(goodsName);
//                System.out.println("Длина продукта   _______" + product.size());
//                System.out.println();

            } else noFindList.add(goodsName);
        }
//        System.out.println("************************");
//        for (String x:noFindList
//             ) {
//            System.out.println(x);
//        }
//        System.out.println("*****************************");
        //driver.close();  //закрываем браузер по завершению

        System.out.println("Кол-во не найденных товаров: " + noFindList.size());
        new WrightOldExelArticul(noFindList);

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
