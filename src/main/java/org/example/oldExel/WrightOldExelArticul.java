package org.example.oldExel;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.example.TextLinks;
import org.example.createPathFile.CreatePathFile;

import java.util.List;

public class WrightOldExelArticul {
    public WrightOldExelArticul( List<String> list) {


        //create no find article
        CreateOldExel createOldExel = new CreateOldExel();
        HSSFWorkbook workbook2 = createOldExel.createOldExel(list);

        // создаем имя файла
        CreatePathFile createPathFile = new CreatePathFile();

        //write no find article, xls file in downloads
        TextLinks fileName = TextLinks.FILENAMESAVE;
        String downloadsPath = createPathFile.createPathFile(fileName.getString());

        WriteOldExel writeOldExel2 = new WriteOldExel(workbook2, downloadsPath);
        writeOldExel2.writeCellExel();

        System.out.println();
        TextLinks textLinks = TextLinks.TEXTSAVEFILE;
        System.out.println(textLinks.getString());
        System.out.println(downloadsPath);

    }

}
