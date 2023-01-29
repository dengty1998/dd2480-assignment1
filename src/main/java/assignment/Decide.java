package assignment;

public class Decide {
    public static boolean decide(Input input) {
        boolean[] cmv = calculateCmv(input.PARAMS, input.POINTS);
        boolean[][] pum = calculatePum(cmv, input.LCM);
        boolean[] fuv = calculateFuv(pum, input.PUV);
        for (int i = 0; i != fuv.length; ++i) {
            if (!fuv[i]) {
                return false;
            }
        }
        return true;
    }

    private static boolean[] calculateCmv(Parameters params, Point[] points) {
        boolean[] cmv = new boolean[15];
        for (int i = 0; i != 15; ++i) {
            cmv[i] = Lics.lics[i].check(params, points);
        }
        return cmv;
    }

    private static boolean[][] calculatePum(boolean[] cmv, Input.Connect[][] lcm) {
        // TODO
        return new boolean[15][15];
    }

    private static boolean[] calculateFuv(boolean[][] pum, boolean[] puv) {
        boolean[] fuv = new boolean[15];
        for (int i = 0; i < 15; i++) {
            if (!puv[i]) {
                fuv[i] = true;
            } else {
                fuv[i] = true;
                for (int j = 0; j < 15; j++) {
                    if (!pum[i][j]) {
                        fuv[i] = false;
                        break;
                    }
                }
            }
        }
        return fuv;
    }
}
