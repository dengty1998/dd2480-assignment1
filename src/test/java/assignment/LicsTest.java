package assignment;

import org.junit.Assert;
import org.junit.Test;

public class LicsTest {
    @Test
    public void testLic0() {
        double[][] points = {{0.01, 0.01}, {0, 0}, {0, 1}, {1, 1}, {1, 0}};
        ParametersBuilder builder = new ParametersBuilder();
        // length 1 is greater than the length of the given points so it should return false
        builder.length1 = 1.0;
        Assert.assertFalse(Lics.lics[0].check(builder.build(points.length), points));
        // length 0.5 is less than the length of the given points so it should return true
        builder.length1 = 0.5;
        Assert.assertTrue(Lics.lics[0].check(builder.build(points.length), points));
    }

    @Test
    public void testLic1() {
        double[][] points = {{0.01, 0.01}, {0, 0}, {0, 1}, {1, 1}, {1, 0}};
        ParametersBuilder builder = new ParametersBuilder();
        // radius 1 can fit the given points so it should return false
        builder.radius1 = 1.0;
        Assert.assertFalse(Lics.lics[1].check(builder.build(points.length), points));
        // radius 0.5 cannot fit the given points so it should return true
        builder.radius1 = 0.1;
        Assert.assertTrue(Lics.lics[1].check(builder.build(points.length), points));
    }

    @Test
    public void testLic2() {
        double[][] points = {{0.01, 0.01}, {0, 0}, {0, 1}, {1, 1}, {1, 0}};
        ParametersBuilder builder = new ParametersBuilder();
        // epsilon 1 gives true with the given points
        builder.epsilon = 1.0;
        Assert.assertTrue(Lics.lics[2].check(builder.build(points.length), points));
    }

    @Test
    public void testLic3() {
        double[][] points = {{0.01, 0.01}, {0, 0}, {0, 4}, {4, 4}, {4, 0}};
        ParametersBuilder builder = new ParametersBuilder();
        // area 1 is less than the area of the given points so it should return true
        builder.area1 = 1.0;
        Assert.assertTrue(Lics.lics[3].check(builder.build(points.length), points));
        // area 10 is greater than the area of the given points so it should return false
        builder.area1 = 10.0;
        Assert.assertFalse(Lics.lics[3].check(builder.build(points.length), points));
    }
}
