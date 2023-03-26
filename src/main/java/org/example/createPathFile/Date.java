package org.example.createPathFile;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Date {

    public Date() {

    }


    public String currentDate() {

        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd_MM_yyyy");
        //String formattedDate = currentDate.format(formatter);

        return currentDate.format(formatter);
    }

}
