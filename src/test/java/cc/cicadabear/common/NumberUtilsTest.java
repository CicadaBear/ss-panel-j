package cc.cicadabear.common;

import cc.cicadabear.common.util.NumberUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Jack on 3/10/17.
 */
public class NumberUtilsTest {

    @Test
    public void test() {
        System.out.println((232345 / 100));
        double dou = 23.2345;
        System.out.println(NumberUtils.df2(23.2345));
        Assert.assertEquals(NumberUtils.df2(23.23345), "23.23");
        Assert.assertEquals(NumberUtils.round2(23.2345), 23.23);
    }
}
