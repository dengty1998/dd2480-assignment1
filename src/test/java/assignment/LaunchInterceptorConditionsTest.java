package assignment;

import org.junit.Assert;
import org.junit.Test;

public class LaunchInterceptorConditionsTest {
    @Test
    public void testConditionZero() {
        int[][] points = {{0, 0}, {0, 1}, {1, 1}, {1, 0}};
        Assert.assertEquals(LaunchInterceptorConditions.ConditionZero(1.0, points), false);
    }
}
