package org.example.csvRead.csv;

import java.util.ArrayList;
import java.util.List;

public class OnlyGoods {


    public List<String[]> onlyGoods(List<String[]> rows, int cellPrice, int cellItem) {

        List<String[]> dataWithItem = new ArrayList<>();
        for (String[] row : rows) {
            if (isInteger(row[cellItem]) && isInteger(row[cellPrice]))
                dataWithItem.add(row);
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
