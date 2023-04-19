package org.example.oldExel.createWrite;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

public class WriteOldExel {
    private final HSSFWorkbook workbook;
    private final String fileNamePrice;

    public WriteOldExel(HSSFWorkbook workbook, String fileNamePrice) {
        this.workbook = workbook;
        this.fileNamePrice = fileNamePrice;
    }


    public void writeCellExel(){
        try {
            FileOutputStream outputStream = new FileOutputStream(fileNamePrice);
            workbook.write(outputStream);
            workbook.close();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
