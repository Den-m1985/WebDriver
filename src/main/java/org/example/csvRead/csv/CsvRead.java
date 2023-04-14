package org.example.csvRead.csv;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;

import java.io.*;
import java.util.*;


public class CsvRead {
    private final String fileName;


    public CsvRead(String fileName) {
        this.fileName = fileName;
    }


    public List<String[]> readCSV() throws IOException, CsvException {
        Reader reader = new InputStreamReader(new FileInputStream(fileName), "windows-1251");
        CSVParser parser = new CSVParserBuilder().withSeparator(';').build(); // separator with ;
        CSVReader csvReader = new CSVReaderBuilder(reader).withCSVParser(parser).build();
        List<String[]> rows = csvReader.readAll(); // read all rows in the file

        reader.close();

        return rows;
    }

}
