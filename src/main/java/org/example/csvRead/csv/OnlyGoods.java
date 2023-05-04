package org.example.csvRead.csv;

import org.example.browser.CheckPrice;
import org.example.browser.ClowdWindow;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class OnlyGoods {
    private List<String[]> reportCSV;

    public OnlyGoods() {
    }

    public List<StructureCSV> onlyGoods(List<String[]> rows, int cellPrice, int cellItem) {

        List<StructureCSV> dataWithItem = new ArrayList<>();
        reportCSV = new ArrayList<>();

        for (String[] row : rows) {
            // Бывает, что в исходнике некорректно сделана структура, эти позиции отправляются в итоговый отчет.
            try {
                int wrong = row[4].length();
                if (wrong>0){
                    String[] error = {row[0], "Неверный формат CSV"};
                    reportCSV.add(error);
                }
            } catch (Exception ignored) {}

            // Если в ячейке price и item число, то эту строку добавляем для дальнейшей работы.
            if (isInteger(row[cellItem]) && isInteger(row[cellPrice])) {
                int price = Integer.parseInt(row[cellPrice]);
                int item = Integer.parseInt(row[cellItem]);
                dataWithItem.add(new StructureCSV(row[0], row[1], price, item));
            }
        }
        return dataWithItem;
    }


    public List<String[]> reportCSV() {
        return reportCSV;
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
