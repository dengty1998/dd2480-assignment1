package assignment;

// Input for the decide function
public class Input {
    final Point[] POINTS;
    final Parameters PARAMS;
    final Connect[][] LCM;
    final boolean[] PUV;

    static enum Connect {
        ANDD, ORR, NOTUSED;
    }

    public Input(int numpoints,
                 double[][] points,
                 Parameters params,
                 Connect[][] lcm,
                 boolean[] puv) {
        if (!(numpoints == points.length)) {
            throw new IllegalArgumentException("Invalid NUMPOINTS value: actual number of points is "
                            + points.length + ", NUMPOINTS provided is " + numpoints + ".");
        }
        if (!(2 <= points.length && points.length <= 100)) {
            throw new IllegalArgumentException("Number of points should be >= 2 and <= 100.");
        }
        for (int i = 0; i != points.length; ++i) {
            if (!(points[i].length == 2)) {
                throw new IllegalArgumentException("Points should be planar: point " + i
                                + " is not.");
            }
        }
        if (!(lcm.length == 15)) {
            throw new IllegalArgumentException("LCM should be 15x15 matrix.");
        }
        for (int i = 0; i != lcm.length; ++i) {
            if (!(lcm[i].length == 15)) {
                throw new IllegalArgumentException("LCM should be 15x15 matrix.");
            }
        }
        if (!(puv.length == 15)) {
            throw new IllegalArgumentException("PUV should be vector of 15 items.");
        }
        POINTS = Point.makePoints(points);
        PARAMS = params;
        LCM = lcm;
        PUV = puv;
    }
}
