package org.example.browser.checkSize;

public class AnalyzeText {


    public String substituteValues(String goodsSize, String webSiteSize) {
        String valueStr = "";
        String temp = "";

        if (goodsSize.equals(webSiteSize)) {
            //System.out.println("1-й");
            return goodsSize;
        }

        temp = goodsSize.trim();
        valueStr = webSiteSize.trim();
        if (temp.equals(valueStr)) {
            //System.out.println("2-й");
            return valueStr;
        }

        // разделяем на слова. если слова одинаковые, но разные символы, то делим на слова и проверяем.
        SplitString splitString = new SplitString();
        String[] partsGoods = splitString.divideString(goodsSize);
        String[] partsSite = splitString.divideString(webSiteSize);
        int fromSpSize = partsGoods.length;
        int fromSiteSize = partsSite.length;

        // проверяем на совпадение каждого слова
        boolean check = false;
        check = new CheckNames().checkSizeSpAndWebsite(partsGoods, partsSite);
        // если одинаковая длина и равным то возвращаем исходник
        if (fromSpSize == fromSiteSize && check) {
            //System.out.println("3-й");
            return webSiteSize;
        }

        // здесь можно переделать: поднять/опустить регист во всех словах, вернуть оригинал.
        // если последний символ с сайта СП39 в нижнем регистре, то меняем его на верхний и проверяем с текстом с сайта.
        for (int i = 0; i < partsGoods.length; i++) {
            partsGoods[i] = partsGoods[i].toUpperCase();
        }
        for (int i = 0; i < partsSite.length; i++) {
            partsSite[i] = partsSite[i].toUpperCase();
        }
        String str = String.join(" ", partsGoods); // собираем в строку
        String str2 = String.join(" ", partsSite); // собираем в строку
        if (str.equals(str2)){
           return webSiteSize.trim();
        }

        return goodsSize;
    }

       /*
    --------         набор-2шт (KH-3263,4611)

*********Антипригарный Тефлоновый коврик в коробке 2шт. Non stick Over liner 30X40
Закрыл всплывающее окно
--------         размер S
         размер M
         размер L

Горшок для рассады 7х7х7 см   ----10шт (ТФ3127)
				10шт (ТФ3127)

Лейкопластырь медицинский с акринолом
(60штук)
				 (60штук)

Полиэтиленовый пакет с застёжкой ZIP-LOCK (100шт)
(6х8 см)
				 (4х6 см)
				 (5х7 см)
				 (6х8 см)


Пряжа для вязания и рукоделия 50 гр
бордовый
     */

}
