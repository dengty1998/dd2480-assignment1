package assignment;

public class LaunchInterceptorConditions {

    public static boolean ConditionZero(double LENGTH1, int[][] POINTS) {
        for (int i = 0; i < POINTS.length - 1; i++) {
            if (HelperFunction.calculateDistance(POINTS[i], POINTS[i + 1]) > LENGTH1) {
                return true;
            }
        }
        return false;
    }

    public static boolean ConditionOne(double RADIUS1, int[][] POINTS) {

        for (int i = 0; i < POINTS.length - 2; i++) {
            if (!HelperFunction.checkTriangelFitCircle(POINTS[i], POINTS[i + 1], POINTS[i + 2],
                            RADIUS1)) {
                return true;
            }
        }
        return false;
    }

    public static boolean Conditiontwo(double EPSILON, int[][] POINTS) {
        for (int i = 0; i < POINTS.length - 2; i++) {
            if (HelperFunction.checkAngle(POINTS[i], POINTS[i + 1], POINTS[i + 2], EPSILON)) {
                return true;
            }
        }
        return false;
    }

    public static boolean ConditionThree(double AREA1, int[][] POINTS) {
        for (int i = 0; i < POINTS.length - 2; i++) {
            if (HelperFunction.checkArea(POINTS[i], POINTS[i + 1], POINTS[i + 2], AREA1)) {
                return true;
            }
        }
        return false;
    }

    public static boolean ConditionFour(int QPTS, int QUADS, int[][] POINTS) {
        // do something
        return true;
    }

    public static boolean ConditionFive(int[][] POINTS) {
        // do something
        return true;
    }

    public static boolean ConditionSix(int NPTS, double DIST, int NUMPOINTS, int[][] POINTS) {
        // do something
        return true;
    }

    public static boolean ConditionSeven(double LENGTH1, int KPTS, int NUMPOINTS, int[][] POINTS) {
        // do something
        return true;
    }

    public static boolean ConditionEight(int APTS, int BPTS, double RADIUS1, int NUMPOINTS,
                    int[][] POINTS) {
        // do something
        return true;
    }

    public static boolean ConditionNine(int CPTS, int DPTS, double EPSILON, int NUMPOINTS,
                    int[][] POINTS) {
        // do something
        return true;
    }

    public static boolean ConditionTen(int EPTS, int FPTS, double AREA1, int NUMPOINTS,
                    int[][] POINTS) {
        // do something
        return true;
    }

    public static boolean ConditionEleven(int GPTS, int NUMPOINTS, int[][] POINTS) {
        // do something
        return true;
    }

    public static boolean ConditionTwelve(int KPTS, double LENGTH2, int NUMPOINTS, int[][] POINTS) {
        // do something
        return true;
    }

    public static boolean ConditionThirteen(int APTS, int BPTS, double RADIUS1, double RADIUS2,
                    int NUMPOINTS, int[][] POINTS) {
        // do something
        return true;
    }

    public static boolean ConditionFourteen(int EPTS, int FPTS, double AREA1, double AREA2,
                    int NUMPOINTS, int[][] POINTS) {
        // do something
        return true;
    }
}
