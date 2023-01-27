package assignment;

import org.junit.Test;
import org.junit.Assert;

public class LaunchInterceptorConditionsTest {
    @Test
    public void testConditionZero() {
        int[][] points = {{0, 0}, {0, 1}, {1, 1}, {1, 0}};
        Assert.assertEquals(
            LaunchInterceptorConditions.ConditionZero(
                1.0,
                points
            ),
            false
        );
    }
}
