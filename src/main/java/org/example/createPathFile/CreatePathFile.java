package org.example.createPathFile;

import org.example.TextLinks;

import java.io.File;

public class CreatePathFile {

    public CreatePathFile() {
    }


    public String  createPathFile (String fileName){

        Date date = new Date();
        String str = date.currentDate();

        TextLinks textLinks = TextLinks.OPENFILEPATH;
        String defaultFolder = textLinks.getString();

        return System.getProperty("user.home") + File.separator +
                defaultFolder+"\\" + fileName + "_" + str + ".xls";
    }


}
