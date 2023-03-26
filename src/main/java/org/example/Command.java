package org.example;

import com.opencsv.exceptions.CsvException;
import org.example.browser.*;
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

        // авторизуемся
        new LoginPage(wait);

        // читаем csv
        int cellName = 0;   // Cell with name or articular
        int cellItem = 3;   // Cell with item to order
        CsvRead csvRead = new CsvRead(pathCSV);
        Map<String, String> data = csvRead.readCSV(cellName, cellItem);

        //Map<String, String> data2 = new HashMap<>();
        //data2.put("BESTWAY Круг для плавания, 56см, ПВХ, дизайнерский", "5");
        ArrayList<String> noFindList = new ArrayList<>();
        for (Map.Entry<String, String> goods : data.entrySet()) {
            String goodsName = goods.getKey();

            SearchGoods searchGoods = new SearchGoods(wait);
            searchGoods.searchProduct(goodsName);

            // от ChatGPT не работает
            //WebElement searchBox = driver.findElement(By.name("input_search"));
            //searchBox.sendKeys(goods.getKey());
            //searchBox.submit();

            List<WebElement> products = driver.findElements(By.className("products"));
            //List<WebElement> products = driver.findElements(By.id("content"));
            List<WebElement> product = driver.findElements(By.className("product"));
            if (products.size() > 0) {
                noFindList.add(goodsName);
            }
            else if (product.size() > 0) {
//                System.out.println();
//                System.out.println(goodsName);
//                System.out.println("Длина продукта   _______" + product.size());
//                System.out.println();
                // товар найден
                //AddGoods addGoods = new AddGoods(wait);
                //addGoods.addGoods(goods.getValue());
            }
            else noFindList.add(goodsName);

        }

        //driver.close();  //закрываем браузер по завершению

        new WrightOldExelArticul(noFindList);

        long end = System.nanoTime();
        long a = end - start;

        System.out.println();
        System.out.println("_________У С П Е Ш Н О________");
        System.out.println();
        System.out.println("Время выполнения: " + a / 1000000000 + "сек");
        System.out.println("_________Оля молодец_________");
        System.out.println();
        System.out.println("_________Попей чайку_________");
        System.out.println();
    }


}
