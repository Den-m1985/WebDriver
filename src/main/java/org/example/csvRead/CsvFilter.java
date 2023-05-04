package org.example.csvRead;

import com.opencsv.exceptions.CsvException;
import org.example.TextLinks;
import org.example.csvRead.csv.*;

import java.io.IOException;
import java.util.List;

public class CsvFilter {
    private final String fileName;
    private List<String[]> error;


    public CsvFilter(String fileName) {
        this.fileName = fileName;
    }


    public List<StructureCSV> csvFilter(int cellPrice, int cellItem) throws IOException, CsvException {

        CsvRead csvRead = new CsvRead(fileName);
        List<String[]> rows = csvRead.readCSV();

        // В этом блоке оставляем только те колонки где есть цена и кол-во
        OnlyGoods onlyGoods = new OnlyGoods();
        List<StructureCSV> dataWithItem = onlyGoods.onlyGoods(rows, cellPrice,cellItem);
        error = onlyGoods.reportCSV();

        // этот блок возвращает иникальные элементы
        UniqueGoods uniqueGoods = new UniqueGoods();
        List<StructureCSV> uniqueValues = uniqueGoods.uniqueGoods(dataWithItem);
        List<StructureCSV> duplicateNames = uniqueGoods.getDuplicateNames();

        // этот блок работатет с повторяющимися именами.
        List<StructureCSV> resolveDuplicatedNames = new DuplicateGoods().duplicateGoods(duplicateNames);
        uniqueValues.addAll(resolveDuplicatedNames);

        TextLinks textLinks = TextLinks.COUNROWSCSV;
        System.out.println();
        System.out.println(textLinks.getString() + uniqueValues.size());

        return uniqueValues;
    }


    public List<String[]> getError() {
        return error;
    }
}
