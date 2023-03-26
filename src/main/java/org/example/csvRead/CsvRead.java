package org.example.csvRead;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;
import org.example.TextLinks;

import java.io.*;
import java.util.*;


public class CsvRead {
    private final String fileName;
    private final Map<String, String> dataCSV;


    public CsvRead(String fileName) {
        this.dataCSV = new HashMap<>();
        this.fileName = fileName;
    }


    public Map<String, String> readCSV(int cellName, int cellItem) throws IOException, CsvException {

        Reader reader = new InputStreamReader(new FileInputStream(fileName), "windows-1251");
        CSVParser parser = new CSVParserBuilder().withSeparator(';').build(); // separator with ;
        CSVReader csvReader = new CSVReaderBuilder(reader).withCSVParser(parser).build();
        List<String[]> rows = csvReader.readAll(); // read all rows in the file

        for (String[] row : rows) {
            if (isInteger(row[cellItem])) {   // check - if cell item is integer?
                dataCSV.put(row[cellName], row[cellItem]);
            }
        }
        reader.close();

        TextLinks textLinks = TextLinks.COUNROWSCSV;
        System.out.println();
        System.out.println(textLinks.getString() + dataCSV.size());
        return dataCSV;
    }


    boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }


}
/*
HashMap
put(K,V) – добавить пару если или изменить значение,если ключ имеется.
putIfAbsent(K,V) – произвести добавление если ключ не найден.
get(K) - получение значения по указанному ключу.
remove(K) – удаляет пару по указанному ключу.
containsValue(V) – проверка наличия значения.
containsKey(V) – проверка наличия ключа.
keySet() – возвращает множество ключей.
values() – возвращает набор значений.
 */
