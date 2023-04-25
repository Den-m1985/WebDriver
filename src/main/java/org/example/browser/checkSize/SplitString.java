package org.example.browser.checkSize;

public class SplitString {
    public SplitString() {
    }

    public String[] divideString(String str) {
        // удаляем пробелы в начале и конце строки
        str = str.trim();
        str = str.replaceAll("[()\\-,./;:]", " "); // заменяем скобки и знаки дефиса и слеша на пробелы
        return str.split("\\s+"); // разбиваем строку на слова по пробелам
    }



    public String[] getSizes(String strWebSite) {
        String[] sizeArray = strWebSite.split("\n"); // разбиваем исходную строку на подстроки по символу переноса строки
        return sizeArray;
    }
}
