package org.example.browser.checkSize;

public class Test {

    public static void main(String[] args) {
//        String strSpSize = "размер s";
//        String strWebSite = "         размер S\n" +
//                "         размер M\n" +
//                "         размер L";

//        String strSpSize = "набор-2шт (KH-3263,4611)";
//        String strWebSite = "         набор-2шт (KH-3263,4611)";

        String strSpSize = "10шт (ТФ3127)";
        String strWebSite = "\n" +
                "\t\t\t\t10шт (ТФ3127) \n" +
                "\t\t\t\t";

        String res = new AnalyzeText().substituteValues(strSpSize, strWebSite);
        System.out.println(res);


    }
}
