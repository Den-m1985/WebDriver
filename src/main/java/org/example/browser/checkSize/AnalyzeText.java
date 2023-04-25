package org.example.browser.checkSize;

public class AnalyzeText {


    public String substituteValues(String goodsSize, String webSiteSize) {
        String valueStr = "";
        String temp = "";

//        boolean textContain = webSiteSize.contains(goodsSize);
//        if (textContain) {
//            System.out.println("1-й");
//            return goodsSize;
//        }
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

        // если последний символ с сайта СП39 в нижнем регистре, то меняем его на верхний и проверяем с текстом с сайта.
        String[] dividedStr = splitString.getSizes(webSiteSize);  // делим строку с сайта
        partsGoods[fromSpSize - 1] = partsGoods[fromSpSize - 1].toUpperCase();  // меняем регистр последнего индекса
        String str = String.join(" ", partsGoods); // собираем в строку
        //int length = Math.min(fromSpSize, dividedStr.length);
        for (int i = 0; i < dividedStr.length; i++) {
            String res = dividedStr[i].trim();
            if (str.equals(res)) {
                //System.out.println("4-й");
                return dividedStr[i];
            }
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
