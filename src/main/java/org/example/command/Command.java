package org.example.command;

import com.opencsv.exceptions.CsvException;
import org.example.browser.*;
import org.example.browser.chrome.OpenChrome;
import org.example.csvRead.CsvFilter;
import org.example.csvRead.csv.StructureCSV;
import org.example.oldExel.WrightOldExelArticul;
import org.example.searchAndAdd.SearchAndAdd;
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

    public void startProgram(String pathCSV) throws IOException, CsvException, InterruptedException {

        long start = System.nanoTime();

        reportList = new ArrayList<>();

        // Read csv
        //int cellName = 0;   // Cell with name or articular
        int cellPrice = 2;
        int cellItem = 3;   // Cell with item to order
        CsvFilter csvFilter = new CsvFilter(pathCSV);
        List<StructureCSV> data = csvFilter.csvFilter(cellPrice, cellItem);


        // Open browser
        OpenChrome openChrome = new OpenChrome();
        WebDriver driver = openChrome.getDriver();
        WebDriverWait wait = openChrome.getWait();

        // Open website
        new OpenWebSite(driver);

        new ClowdWindow(driver);

        // login account
        new LoginPage(wait);

        new ClowdWindow(driver);

        // delete shoping cart  TO DO
        List<WebElement> goodsInCart = driver.findElements(By.className("cart"));
        //ShoppingCart shoppingCart = new ShoppingCart(wait);
        for (WebElement x : goodsInCart) {
            System.out.println(x.getText());
        }


        for (StructureCSV goods : data) {
            String goodsName = goods.getName();
            try {
                SearchAndAdd searchAndAdd = new SearchAndAdd(driver, wait, reportList);
                searchAndAdd.executeProcess(goods);
            } catch (Exception e) {
                System.out.println("Произошла ошибка: " + e.getMessage());
                String[] noAdd = {goodsName, "Какая-то общая ошибка"};
                reportList.add(noAdd);
            }
        }

        // по завершению заходим в корзину
        new ClowdWindow(driver);
        ShoppingCart shoppingCart2 = new ShoppingCart(wait);
        shoppingCart2.clickCart();
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
