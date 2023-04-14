package org.example.csvRead.csv;

import java.util.ArrayList;
import java.util.List;

public class DuplicateGoods {



    public List<StructureCSV> duplicateGoods(List<StructureCSV> duplicateNames) {


        List<StructureCSV> Names = new ArrayList<>();
        for (StructureCSV row : duplicateNames) {
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
                    }
                }
            }
            if (!duplicated) {
                Names.add(new StructureCSV (name, size, price, item));
            }
        }

//        List<String[]> Names = new ArrayList<>();
//        for (String[] row : duplicateNames) {
//            String name = row[0];
//            String size = row[1];
//            String price = row[2];
//            String item = row[3];
//            boolean duplicated = false;
//            for (String[] existing : Names) {
//                String str1 = existing[0];
//                String str2 = existing[1];
//
//                if (str1.equals(name)) {
//                    if (str2.equals(size)) {
//                        existing[3] = String.valueOf(Integer.parseInt(existing[3]) + Integer.parseInt(item));
//                        duplicated = true;
//                        break;
//                    }
//                }
//            }
//            if (!duplicated) {
//                Names.add(new String[]{name, size, price, item});
//            }
//        }
        return Names;
    }


}
