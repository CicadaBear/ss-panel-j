package cc.cicadabear.common.util;

import java.text.DecimalFormat;

/**
 * Created by Jack on 3/8/17.
 */
public class BandwidthUtils {

    public static final long KB = 1024;
    public static final long MB = 1048576;
    public static final long GB = 1073741824;

    private static DecimalFormat df2 = new DecimalFormat(".##");

    /**
     * 根据流量值自动转换单位输出
     */
    public static String flowAutoShow(long bytes) {
        long unit = 1;
        String unitText = "B";
        bytes = Math.abs(bytes);
        if (bytes > GB) {
            unit = GB;
            unitText = "GB";
        } else if (bytes > MB) {
            unit = MB;
            unitText = "MB";
        } else if (bytes > KB) {
            unit = KB;
            unitText = "KB";
        } else if (bytes == 0) {
            return "0MB";
        }
        return NumberUtils.roundDf2(Double.valueOf(bytes) / unit) + unitText;

    }

    public static long toMB(long traffic) {
        return traffic * MB;
    }

    public static long toGB(long traffic) {
        return traffic * GB;
    }

    public static long flowToGB(long traffic) {
        return traffic / GB;
    }

}
