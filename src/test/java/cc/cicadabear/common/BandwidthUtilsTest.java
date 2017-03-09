package cc.cicadabear.common;

import cc.cicadabear.common.util.BandwidthUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Jack on 3/10/17.
 */
public class BandwidthUtilsTest {

    @Test
    public void testFlowAutoShow() {
        int kB = 1024;
        int mB = kB * 1024;
        int gB = mB * 1024;
        Assert.assertEquals(BandwidthUtils.flowAutoShow(0), "0MB");
        Assert.assertEquals(BandwidthUtils.flowAutoShow(30 * kB), "30.0KB");
        Assert.assertEquals(BandwidthUtils.flowAutoShow(50 * mB), "50.0MB");
        System.out.println(BandwidthUtils.flowAutoShow(1025 * mB));
        Assert.assertEquals(BandwidthUtils.flowAutoShow(1025 * mB), "1.0GB");
        Assert.assertEquals(BandwidthUtils.flowAutoShow((long) (53.25 * gB)), "53.25GB");
    }
}
