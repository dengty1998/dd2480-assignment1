package assignment;

import org.junit.Assert;
import org.junit.Test;

public class LicsTest {
    private Lic lic;
    private ParametersBuilder builder;
    private double[][] points;

    private void assertFalse() {
        Assert.assertFalse(lic.check(builder.build(points.length), Point.makePoints(points)));
    }

    private void assertTrue() {
        Assert.assertTrue(lic.check(builder.build(points.length), Point.makePoints(points)));
    }

    @Test
    public void testLic0() {
        lic = Lics.lics[0];
        builder = new ParametersBuilder();
        points = new double[][] {{0.01, 0.01}, {0, 0}, {0, 1}, {1, 1}, {1, 0}};
        // length 1 is greater or equal to the length of the given points so it should return false
        builder.length1 = 1.0;
        assertFalse();
        // length 0.5 is less than the length of the given points so it should return true
        builder.length1 = 0.5;
        assertTrue();
    }

    @Test
    public void testLic1() {
        lic = Lics.lics[1];
        builder = new ParametersBuilder();
        points = new double[][] {{0.01, 0.01}, {0, 0}, {0, 1}, {1, 1}, {1, 0}};
        // radius 1 can fit the given points so it should return false
        builder.radius1 = 1.0;
        assertFalse();
        // radius 0.1 cannot fit the given points so it should return true
        builder.radius1 = 0.1;
        assertTrue();
    }

    @Test
    public void testLic2() {
        lic = Lics.lics[2];
        builder = new ParametersBuilder();
        points = new double[][] {{0, 0}, {0, 1}, {1, 1}, {0.01, 0.01}};
        // just as expected, the angle made by points[1][2][3] is almost pi/4 (which fits), another angle is pi/2
        builder.epsilon = 2.0;
        assertTrue();
        // since pi - 3 < pi/4, the result should be false
        builder.epsilon = 3.0;
        assertFalse();
    }

    @Test
    public void testLic3() {
        lic = Lics.lics[3];
        builder = new ParametersBuilder();
        points = new double[][] {{0.01, 0.01}, {0, 0}, {0, 4}, {4, 4}, {4, 0}};
        // area 1 is less than the area of the given points so it should return true
        builder.area1 = 1.0;
        assertTrue();
        // area 10 is greater than the area of the given points so it should return false
        builder.area1 = 10.0;
        assertFalse();
    }

    @Test
    public void testLic8() {
        lic = Lics.lics[8];
        builder = new ParametersBuilder();
        points =
            new double[][] {{1, 0}, {0, 10}, {0, 1}, {10, 10}, {1, 0}, {1, 1}, {10, 0}, {1, 1}};
        builder.a_pts = 1;
        builder.b_pts = 2;
        // just as expected, only points[1][3][6] can fit
        builder.radius1 = 5.0;
        assertTrue();
        // RADIUS is so large that can't fit the given points
        builder.radius1 = 10.0;
        assertFalse();

    }

    @Test
    public void testLic9() {
        lic = Lics.lics[9];
        builder = new ParametersBuilder();
        points =
            new double[][] {{1, 0}, {0, 10}, {1, 1}, {10, 0}, {1, 0}, {0, 1}, {10, 10}, {0, 0}};
        builder.c_pts = 1;
        builder.d_pts = 2;
        // just as expected, the angle made by points[1][3][6] is pi/4 (which fits), other angles are pi/2
        builder.epsilon = 2.0;
        assertTrue();
        // since pi - 3 < pi/4, the result should be false
        builder.epsilon = 3.0;
        assertFalse();
    }

    @Test
    public void testLic10() {
        lic = Lics.lics[10];
        builder = new ParametersBuilder();
        points =
            new double[][] {{1, 0}, {0, 10}, {1, 1}, {10, 0}, {1, 0}, {0, 1}, {10, 10}, {0, 0}};
        builder.e_pts = 1;
        builder.f_pts = 2;
        // just as expected, only the area made by points[1][3][6] is bigger than 10
        builder.area1 = 10.0;
        assertTrue();
        // AREA is so large that can't fit the given points
        builder.area1 = 100.0;
        assertFalse();
    }

    @Test
    public void testLic11() {
        lic = Lics.lics[11];
        builder = new ParametersBuilder();
        builder.g_pts = 1;
        // just as expected
        points = new double[][] {{2, 0}, {0, 0}, {1, 0}};
        assertTrue();
        // {1, 0}[0] is less than {2, 0}[0], then return false
        points = new double[][] {{1, 0}, {0, 0}, {2, 0}};
        assertFalse();
    }

    @Test
    public void testLic12() {
        lic = Lics.lics[12];
        builder = new ParametersBuilder();
        builder.k_pts = 1;
        points = new double[][] {{0, 0}, {0, 1}, {0, 2}, {0, 3}, {0, 4}};
        // The distance between points separated by one point is 2
        builder.length1 = 1;
        builder.length2 = 3;
        assertTrue();
        // LENGTH1 is too big
        builder.length1 = 3;
        builder.length2 = 3;
        assertFalse();
        // LENGTH2 is too small
        builder.length1 = 1;
        builder.length2 = 1;
        assertFalse();
    }

    @Test
    public void testLic13() {
        lic = Lics.lics[13];
        builder = new ParametersBuilder();
        builder.k_pts = 1;
        points =
            new double[][] {{1, 0}, {0, 10}, {0, 1}, {10, 10}, {1, 0}, {1, 1}, {10, 0}, {1, 1}};
        builder.a_pts = 1;
        builder.b_pts = 2;
        builder.radius1 = 0.1;
        builder.radius2 = 10.0;
        assertTrue();
        // RADIUS1 is too big
        builder.radius1 = 10.0;
        builder.radius2 = 10.0;
        assertFalse();
        // RADIUS2 is too small
        builder.radius1 = 0.1;
        builder.radius2 = 0.1;
        assertFalse();
    }

    @Test
    public void testLic14() {
        lic = Lics.lics[14];
        builder = new ParametersBuilder();
        builder.k_pts = 1;
        points =
            new double[][] {{1, 0}, {0, 10}, {1, 1}, {10, 0}, {1, 0}, {0, 1}, {10, 10}, {0, 0}};
        builder.e_pts = 1;
        builder.f_pts = 2;
        builder.area1 = 0.01;
        builder.area2 = 100.0;
        assertTrue();
        // AREA1 is too big
        builder.area1 = 100.0;
        builder.area2 = 100.0;
        assertFalse();
        // AREA2 is too small
        builder.area1 = 0.01;
        builder.area2 = 0.01;
        assertFalse();
    }
}
