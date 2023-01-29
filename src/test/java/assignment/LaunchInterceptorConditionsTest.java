package assignment;

import org.junit.Assert;
import org.junit.Test;

public class LaunchInterceptorConditionsTest {
    @Test
    public void testConditionZero() {
        int[][] points = {{0, 0}, {0, 1}, {1, 1}, {1, 0}};
        // length 1 is greater than the length of the given points so it should return false
        Assert.assertFalse(LaunchInterceptorConditions.ConditionZero(1.0, points));
        // length 0.5 is less than the length of the given points so it should return true
        Assert.assertTrue(LaunchInterceptorConditions.ConditionZero(0.5, points));
        // length 0 lower bound gives false
        Assert.assertFalse(LaunchInterceptorConditions.ConditionZero(0, points));
    }

    @Test
    public void testConditionOne() {
        int[][] points = {{0, 0}, {0, 1}, {1, 1}, {1, 0}};
        // radius 1 cannot fit the given points so it should return false
        Assert.assertFalse(LaunchInterceptorConditions.ConditionOne(1.0, points));
        // radius 0.5 can fit the given points so it should return true
        Assert.assertTrue(LaunchInterceptorConditions.ConditionOne(0.5, points));
        // radius 0 lower bound gives false
        Assert.assertFalse(LaunchInterceptorConditions.ConditionOne(0, points));
    }

    @Test
    public void testConditionTwo() {
        int[][] points = {{0, 0}, {0, 1}, {1, 1}, {1, 0}};
        // epsilon 1 gives true with the given points
        Assert.assertTrue(LaunchInterceptorConditions.ConditionTwo(1.0, points));
        // epsilon upper bound gives false
        Assert.assertFalse(LaunchInterceptorConditions.ConditionTwo(10, points));
        // epsilon lower bound gives false
        Assert.assertFalse(LaunchInterceptorConditions.ConditionTwo(0, points));
    }

    @Test
    public void testConditionThree() {
        int[][] points = {{0, 0}, {0, 4}, {4, 4}, {4, 0}};
        // area 1 is less than the area of the given points so it should return true
        Assert.assertTrue(LaunchInterceptorConditions.ConditionThree(1.0, points));
        // area 10 is greater than the area of the given points so it should return false
        Assert.assertFalse(LaunchInterceptorConditions.ConditionThree(10, points));
        // area 1 lower bound gives false
        Assert.assertFalse(LaunchInterceptorConditions.ConditionThree(0, points));
    }
}
