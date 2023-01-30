package assignment;

import org.junit.Assert;
import org.junit.Test;

public class DecideTest {

    private double[][] points;
    private Input input;
    private Input.Connect[][] lcm;


    @Test
    public void DecideFalseInput() {
        points = new double[50][2];
        for (int i = 0; i != points.length; ++i) {
            points[i][0] = i;
            points[i][1] = i / 2.0;
        }
        Parameters params =
            new Parameters(points.length, 5, 5, 1, 5, 5, 1, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5);

        lcm = new Input.Connect[15][15];
        for (int i = 0; i != 15; ++i) {
            for (int j = 0; j != 15; ++j) {
                lcm[i][j] = Input.Connect.ANDD;
            }
        }
        boolean[] puv = new boolean[15];
        for (int i = 0; i != 15; ++i) {
            puv[i] = true;
        }
        input = new Input(points.length, points, params, lcm, puv);
        Assert.assertFalse(Decide.decide(input));
    }

    @Test
    public void DecideTrueInput() {
        points = new double[50][2];
        // generate some different points
        for (int i = 0; i != points.length; ++i) {
            points[i][0] = i * 10;
            points[i][1] = i * 10;
        }
        Parameters params = new Parameters(points.length,
                                           0.5,
                                           5,
                                           1,
                                           5,
                                           5,
                                           1,
                                           5,
                                           5,
                                           5,
                                           5,
                                           5,
                                           5,
                                           5,
                                           5,
                                           5,
                                           5,
                                           5,
                                           5,
                                           5);

        lcm = new Input.Connect[15][15];
        for (int i = 0; i != 15; ++i) {
            for (int j = 0; j != 15; ++j) {
                lcm[i][j] = Input.Connect.ANDD;
            }
        }
        boolean[] puv = new boolean[15];
        for (int i = 0; i != 15; ++i) {
            puv[i] = false;
        }

        input = new Input(points.length, points, params, lcm, puv);
        Assert.assertTrue(Decide.decide(input));
    }

}
