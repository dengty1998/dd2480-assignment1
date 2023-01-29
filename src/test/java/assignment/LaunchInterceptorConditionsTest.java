package assignment;

import org.junit.Assert;
import org.junit.Test;

public class LaunchInterceptorConditionsTest {
    @Test
    public void testConditionZero() {
        int[][] points = {{0, 0}, {0, 1}, {1, 1}, {1, 0}};
        // length 1 is greater than the length of the given points so it should return false
        Assert.assertEquals(LaunchInterceptorConditions.ConditionZero(1.0, points), false);
        // length 0.5 is less than the length of the given points so it should return true
        Assert.assertEquals(LaunchInterceptorConditions.ConditionZero(0.5, points), true);
        // length 0 lower bound gives false
        Assert.assertEquals(LaunchInterceptorConditions.ConditionZero(0, points), false);
    }

    @Test
    public void testConditionOne() {
        int[][] points = {{0, 0}, {0, 1}, {1, 1}, {1, 0}};
        // radius 1 cannot fit the given points so it should return false
        Assert.assertEquals(LaunchInterceptorConditions.ConditionOne(1.0, points), false);
        // radius 0.5 can fit the given points so it should return true
        Assert.assertEquals(LaunchInterceptorConditions.ConditionOne(0.5, points), true);
        // radius 0 lower bound gives false
        Assert.assertEquals(LaunchInterceptorConditions.ConditionOne(0, points), false);
    }

    @Test
    public void testConditionTwo() {
        int[][] points = {{0, 0}, {0, 1}, {1, 1}, {1, 0}};
        // epsilon 1 gives true with the given points
        Assert.assertEquals(LaunchInterceptorConditions.ConditionTwo(1.0, points), true);
        // epsilon upper bound gives false
        Assert.assertEquals(LaunchInterceptorConditions.ConditionTwo(10, points), false);
        // epsilon lower bound gives false
        Assert.assertEquals(LaunchInterceptorConditions.ConditionTwo(0, points), false);
    }

    @Test
    public void testConditionThree() {
        int[][] points = {{0, 0}, {0, 4}, {4, 4}, {4, 0}};
        // area 1 is less than the area of the given points so it should return true
        Assert.assertEquals(LaunchInterceptorConditions.ConditionThree(1.0, points), true);
        // area 10 is greater than the area of the given points so it should return false
        Assert.assertEquals(LaunchInterceptorConditions.ConditionThree(10, points), false);
        // area 1 lower bound gives false
        Assert.assertEquals(LaunchInterceptorConditions.ConditionThree(0, points), false);
    }

    @Test
    public void testConditionEight() {
        int[][] points = {{1, 0}, {0, 10}, {0, 1}, {10, 10}, {1, 0}, {1, 1}, {10, 0}, {1, 1}};
        int numpoints = points.length;
        //
        Assert.assertEquals(LaunchInterceptorConditions.ConditionEight(0,2, 10.0, numpoints, points), false);
        //
        Assert.assertEquals(LaunchInterceptorConditions.ConditionEight(1,2, 10.0, numpoints, points), false);
        //
        Assert.assertEquals(LaunchInterceptorConditions.ConditionEight(1,2, 1.0, numpoints, points), true);
    }

    @Test
    public void testConditionNine() {
        int[][] points = {{1, 0}, {0, 10}, {1, 1}, {10, 0}, {1, 0}, {0, 1}, {10, 10}, {0, 0}};
        int numpoints = points.length;
        //
        Assert.assertEquals(LaunchInterceptorConditions.ConditionNine(0,2, 1.0, numpoints, points), false);
        //
        Assert.assertEquals(LaunchInterceptorConditions.ConditionNine(1,2, 1.0, numpoints, points), true);
        //
        Assert.assertEquals(LaunchInterceptorConditions.ConditionNine(1,2, 10.0, numpoints, points), false);
    }

    @Test
    public void testConditionTen() {
        int[][] points = {{1, 0}, {0, 10}, {1, 1}, {10, 0}, {1, 0}, {0, 1}, {10, 10}, {0, 0}};
        int numpoints = points.length;
        //
        Assert.assertEquals(LaunchInterceptorConditions.ConditionTen(0,2, 10.0, numpoints, points), false);
        //
        Assert.assertEquals(LaunchInterceptorConditions.ConditionTen(1,2, 10.0, numpoints, points), true);
        //
        Assert.assertEquals(LaunchInterceptorConditions.ConditionTen(1,2, 100.0, numpoints, points), false);
    }

    @Test
    public void testConditionEleven() {
        int[][] points1 = {{2, 0}, {0, 0}, {1, 0}};
        int[][] points2 = {{1, 0}, {0, 0}, {2, 0}};
        int numpoints1 = points1.length;
        int numpoints2 = points2.length;
        //
        Assert.assertEquals(LaunchInterceptorConditions.ConditionEleven(0, numpoints1, points1), false);
        //
        Assert.assertEquals(LaunchInterceptorConditions.ConditionEleven(1, numpoints1, points1), true);
        //
        Assert.assertEquals(LaunchInterceptorConditions.ConditionEleven(1, numpoints2, points2), false);
    }
}