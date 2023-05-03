package org.example.csvRead.csv;

import java.util.ArrayList;
import java.util.List;

public class OnlyGoods {


    public List<StructureCSV> onlyGoods(List<String[]> rows, int cellPrice, int cellItem) {

        List<StructureCSV> dataWithItem = new ArrayList<>();
        for (String[] row : rows) {
            if (isInteger(row[cellItem]) && isInteger(row[cellPrice])) {
                int price = Integer.parseInt(row[cellPrice]);
                int item = Integer.parseInt(row[cellItem]);

                dataWithItem.add(new StructureCSV(row[0], row[1], price, item));
            }
        }
        return dataWithItem;
    }


    static boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
