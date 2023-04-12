package org.example.csvRead;

import com.opencsv.exceptions.CsvException;
import org.example.TextLinks;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TestCsv {

    private static List<StructureCSV> dublicatNames;

    public static void main(String[] args) throws IOException, CsvException {
        int cellName = 0;   // Cell with name or articular
        int cellPrice = 2;
        int cellItem = 3;


        CsvRead csvRead = new CsvRead("C:\\Users\\Den\\Downloads\\альфа 11.04 ТЕСТ.csv");
        List<String[]> rows = csvRead.readCSV();

        // В этом блоке оставляем только те колонки где есть цена и кол-во

        // check - if cell item is integer?
        List<StructureCSV> dataWithItem = metod1(rows, cellPrice, cellItem);


        int rtyghsb = 1000000;
        long start = System.nanoTime();


        // этот блок возвращает иникальные элементы

        List<StructureCSV> uniqueValues = metod2(dataWithItem);

        // этот блок работатет с повторяющимися именами.
        List<StructureCSV> dublicatNames2 = new ArrayList<>();
        dublicatNames2 = metod3();
        uniqueValues.addAll(dublicatNames2);

        for (StructureCSV x : uniqueValues) {
            System.out.println(x.getName() + "---" + x.getArtucul() + "---" + x.getItem());
        }


        long end = System.nanoTime();
        long a = end - start;
        long time = a / rtyghsb;
        System.out.println();
        System.out.println("Время выполнения: " + time);
        System.out.println();
/*
        java.
        есть: List<String[]> dublicatNames = new ArrayList<>();
        List<String[]> Names = new ArrayList<>();
        for (String[] row : dublicatNames) {
            String name = row[0];
            String size = row[1];
            String price = row[2];
            String item = row[3];
        }
        В dublicatNames есть повторяющиеся name.
        Напиши метод - если name и size повторяется то item нужно сложить, добавляем в Names.
        если name повторяется, а size нет, то добавляем в Names.
*/



        /*
        Вариант 2
         */
//        long start2 = System.nanoTime();
//
//        Collections.sort(dublicatNames, Comparator.comparing(arr -> arr[0]));
//
//        for (String[] x : dublicatNames) {
//            System.out.println(x[0] + "---" + x[1] + "---" + x[3]);
//        }
//
//        long end2 = System.nanoTime();
//        long a2 = end2 - start2;
//        long time2 = a2 / rtyghsb;
//        System.out.println();
//        System.out.println("Время выполнения: " + time2);

    }


    static boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }


    public static List<StructureCSV> metod1(List<String[]> rows, int cellPrice, int cellItem) {


        List<StructureCSV> dataWithItem = new ArrayList<>();
        for (String[] row : rows) {
            if (isInteger(row[cellItem]) && isInteger(row[cellPrice])) {
                int price = Integer.parseInt(row[cellPrice]);
                int item = Integer.parseInt(row[cellItem]);

                dataWithItem.add(new StructureCSV(row[0], row[1], price, item));
                //dataWithItem.add(row);
            }
        }
        return dataWithItem;
    }


    public static List<StructureCSV> metod2(List<StructureCSV> dataWithItem) {

        List<StructureCSV> uniqueValues = new ArrayList<>();
        dublicatNames = new ArrayList<>();
        int i = 0;
        for (StructureCSV row : dataWithItem) {
            String name = row.getName();
            for (StructureCSV value : dataWithItem) {
                String name2 = value.getName();
                if (name.equals(name2)) {
                    i++;
                    if (i > 1) {
                        dublicatNames.add(row);
                        break;
                    }
                }
            }
            if (i == 1) {
                uniqueValues.add(row);
            }
            i = 0;
        }
        return uniqueValues;
    }


    public static List<StructureCSV> metod3() {
        List<StructureCSV> Names = new ArrayList<>();
        for (StructureCSV row : dublicatNames) {
            String name = row.getName();
            String size = row.getArtucul();
            int price = row.getPrice();
            int item = row.getItem();
            boolean duplicated = false;
            for (StructureCSV existing : Names) {
                String str1 = existing.getName();
                String str2 = existing.getArtucul();
                int existingItem = existing.getItem();
                if (str1.equals(name)) {
                    if (str2.equals(size)) {
                        existing.setItem(existingItem + item);
                        duplicated = true;
                        break;
                    } else {
                        continue;
                    }
                }
            }
            if (!duplicated) {
                Names.add(new StructureCSV (name, size, price, item));
            }
        }
        return Names;
    }


}
