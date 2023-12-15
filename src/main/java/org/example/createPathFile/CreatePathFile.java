package org.example.createPathFile;

import java.io.File;

public class CreatePathFile {
    String DOWNLOAD = "Downloads";

    public String createPathFile(String fileName, String extension) {

        Date date = new Date();
        String str = date.currentDate();

//        return System.getProperty("user.home") + File.separator +
//                defaultFolder + "\\" + fileName + "_" + str + "." + extension;

        String joinFileName = System.getProperty("user.home") + File.separator +
                DOWNLOAD + File.separator + fileName + "_" + str + "." + extension;

        return checkSameName(joinFileName);
    }

    private String checkSameName(String fileName){
        File file = new File(fileName);
        String baseName = fileName.substring(0, fileName.lastIndexOf('.'));
        String extension = fileName.substring(fileName.lastIndexOf('.') + 1);

        int count = 1;
        while (file.exists()) {
            fileName = baseName + "(" + count + ")" + "." + extension;
            file = new File(fileName);
            count++;
        }
        return fileName;
    }

}
