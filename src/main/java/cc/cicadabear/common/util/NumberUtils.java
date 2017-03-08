package cc.cicadabear.common.util;

import java.text.DecimalFormat;

/**
 * Created by Jack on 3/9/17.
 */
public class NumberUtils {

    public static DecimalFormat df2 = new DecimalFormat(".##");

    public static double round2(double num) {
        return Math.round(num * 100.0) / 100.0;
    }

    public static String df2(double num) {
        return df2.format(num);
    }

    public static String roundDf2(double num) {
        return df2(Math.round(num * 100.0) / 100.0);
    }
}
