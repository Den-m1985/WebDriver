package org.example.browser.checkSize;

public class CheckNames {


    public boolean checkSizeSpAndWebsite(String[] fromSP, String[] fromSite) {
        int fromSpSize = fromSP.length;
        int fromSiteSize = fromSite.length;
        //System.out.println(fromSpSize + "  " + fromSiteSize);
        int k = 0;
        if (fromSpSize == fromSiteSize) {
            for (int i = 0; i < fromSpSize; i++) {
                if (fromSP[i].equals(fromSite[i])) {
                    //System.out.println("good");
                    k++;
                }
            }
        }
        if (k == fromSpSize)
            return true;

        return false;
    }


}
