package org.example.oldExel;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.example.TextLinks;
import org.example.createPathFile.CreatePathFile;
import org.example.oldExel.createWrite.CreateOldExel;
import org.example.oldExel.createWrite.WriteOldExel;

import java.util.Comparator;
import java.util.List;

public class WrightOldExelArticul {
    public WrightOldExelArticul( List<String[]> list) {

//        list.stream().sorted(new Comparator<String[]>() {
//            @Override
//            public int compare(String[] o1, String[] o2) {
//                return 0;
//            }
//        });
        list.sort(new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                return o1[1].compareTo(o2[1]);
            }
        });

        //create no find article
        CreateOldExel createOldExel = new CreateOldExel();
        HSSFWorkbook workbook2 = createOldExel.createOldExel(list);

        // создаем имя файла
        CreatePathFile createPathFile = new CreatePathFile();

        //write no find article, xls file in downloads
        TextLinks fileName = TextLinks.FILENAMESAVE;
        String downloadsPath = createPathFile.createPathFile(fileName.getString(), "xls");

        WriteOldExel writeOldExel2 = new WriteOldExel(workbook2, downloadsPath);
        writeOldExel2.writeCellExel();

        System.out.println();
        TextLinks textLinks = TextLinks.TEXTSAVEFILE;
        System.out.println(textLinks.getString());
        System.out.println(downloadsPath);

    }

}
