package org.example.csvRead.csv;

import java.util.ArrayList;
import java.util.List;

public class UniqueGoods {
    private List<String[]> duplicateNames;

    public UniqueGoods() {
    }

    public List<String[]> uniqueGoods(List<String[]> dataWithItem, int cellName) {

        List<String[]> uniqueValues = new ArrayList<>();
        duplicateNames = new ArrayList<>();
        int i = 0;
        for (String[] row : dataWithItem) {
            String name = row[cellName];
            for (String[] value : dataWithItem) {
                String name2 = value[cellName];
                if (name.equals(name2)) {
                    i++;
                    if (i > 1) {
                        duplicateNames.add(row);
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

    public List<String[]> getDuplicateNames() {
        return duplicateNames;
    }
}
