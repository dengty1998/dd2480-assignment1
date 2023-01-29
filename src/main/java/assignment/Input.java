package assignment;

// Input for the decide function
public class Input {
    public final int NUMPOINTS;
    public final int[][] POINTS;
    public final Parameters PARAMETERS;
    public final Connect[][] LCM;
    public final boolean[] PUV;

    public static enum Connect {
        ANDD, ORR, NOTUSED;
    }

    public Input(int NUMPOINTS, int[][] POINTS, Parameters PARAMETERS, Connect[][] LCM,
                    boolean[] PUV) {
        this.NUMPOINTS = NUMPOINTS;
        this.POINTS = POINTS;
        this.PARAMETERS = PARAMETERS;
        this.LCM = LCM;
        this.PUV = PUV;
    }
}
