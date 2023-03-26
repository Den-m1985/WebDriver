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
    private List<String[]> rows;


    public CsvRead(String fileName) {
        this.rows = new ArrayList<>();
        this.fileName = fileName;
    }


    //public Map<String, String> readCSV(int cellName, int cellItem) throws IOException, CsvException {
    public List<String[]> readCSV(int cellName, int cellItem) throws IOException, CsvException {
        Reader reader = new InputStreamReader(new FileInputStream(fileName), "windows-1251");
        CSVParser parser = new CSVParserBuilder().withSeparator(';').build(); // separator with ;
        CSVReader csvReader = new CSVReaderBuilder(reader).withCSVParser(parser).build();
        List<String[]> rows = csvReader.readAll(); // read all rows in the file

        reader.close();

        return rows;
    }

}
