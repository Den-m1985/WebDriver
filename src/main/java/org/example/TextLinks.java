package org.example;

public enum TextLinks {
    ADDRESS("https://alfa812.ru/"),
    CABINET("//*[@id=\"adapt-hdr\"]/div[2]/a[2]/span"), // поле Кабинет
    LOGINFIELD("//*[@id=\"content\"]/form/input[1]"),  // поле ввода логина
    PASSWORDFIELD("//*[@id=\"content\"]/form/input[2]"),  //поле ввода пароля
    ENTERACCOUNT("//*[@id=\"content\"]/form/input[3]"),  //поле входа
    SEARCHFIELD("//*[@id=\"search\"]/form/input[2]"),  //поле поиска
    BUTTONSEARCH("//*[@id=\"search\"]/form/input[1]"),  //поле кнопки поска
    NOFIND("//*[@id=\"content\"]/p"),  // поле Товар не найден
    ADDITEM("//*[@id=\"content\"]/div/div[2]/form/div/div[1]/span[1]/input"),  //поле добавить кол-во
    CLICKBAY("//*[@id=\"content\"]/div/div[2]/form/div/input"),  //поле добавить в корзину
    CLOUDWINDOW("//*[@id=\"fancybox-wrap\"]"),  // всплывающее окно
    CLOSEWINDOW("//*[@id=\"fancybox-close\"]"),  //закрыть всплывающее окно
    OPENFILEPATH("Downloads"),  //открываем и сохраняем папку по умолчанию
    COUNROWSCSV("количество товаров в csv: "),
    SHEET("Sheet1"),
    NOARTICUL("Артикулы не найденые на сайте"),
    FILENAMESAVE("Alfa-812_No_Find"),  //имя файла с ненайденными артикулами
    TEXTSAVEFILE("Файл куда сохраняем ненайденные артикулы"),
    TEXTFILEOPEN("Файл исходник:"),
    CSV("csv");

    private final String string;

    TextLinks(String string) {
        this.string = string;
    }

    public String getString() {
        return string;
    }
}
