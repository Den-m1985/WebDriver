package org.example.oldExel;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.example.TextLinks;
import org.example.createPathFile.CreatePathFile;
import org.example.oldExel.createWrite.CreateOldExel;
import org.example.oldExel.createWrite.WriteOldExel;

import java.util.Comparator;
import java.util.List;

public class WrightOldExelArticul {
    public WrightOldExelArticul(List<String[]> list) {

        list.sort(Comparator.comparing(o -> o[1]));

        //create no find article
        HSSFWorkbook workbook2 = new CreateOldExel().createOldExel(list);

        // создаем имя файла
        CreatePathFile createPathFile = new CreatePathFile();

        //write no find article, xls file in downloads
        TextLinks fileName = TextLinks.FILENAMESAVE;
        String downloadsPath = createPathFile.createPathFile(fileName.getString(), "xls");

        new WriteOldExel(workbook2, downloadsPath);

        System.out.println();
        TextLinks textLinks = TextLinks.TEXTSAVEFILE;
        System.out.println(textLinks.getString());
        System.out.println(downloadsPath);
    }

}
