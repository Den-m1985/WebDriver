package org.example.csvRead.csv;

import java.util.ArrayList;
import java.util.List;

public class DuplicateGoods {



    public List<String[]> duplicateGoods(List<String[]> duplicateNames) {
        List<String[]> Names = new ArrayList<>();
        for (String[] row : duplicateNames) {
            String name = row[0];
            String size = row[1];
            String price = row[2];
            String item = row[3];
            boolean duplicated = false;
            for (String[] existing : Names) {
                String str1 = existing[0];
                String str2 = existing[1];

                if (str1.equals(name)) {
                    if (str2.equals(size)) {
                        existing[3] = String.valueOf(Integer.parseInt(existing[3]) + Integer.parseInt(item));
                        duplicated = true;
                        break;
                    }
                }
            }
            if (!duplicated) {
                Names.add(new String[]{name, size, price, item});
            }
        }
        return Names;
    }


}
