package org.example.createPathFile;

import org.example.TextLinks;

import java.io.File;

public class CreatePathFile {

    public CreatePathFile() {
    }


    public String  createPathFile (String fileName, String extension){

        Date date = new Date();
        String str = date.currentDate();

        TextLinks textLinks = TextLinks.SAVEFILEPATH;
        String defaultFolder = textLinks.getString();

        return System.getProperty("user.home") + File.separator +
                defaultFolder+"\\" + fileName + "_" + str + "." + extension;
    }


}
