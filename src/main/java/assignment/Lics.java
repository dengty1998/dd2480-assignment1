package assignment;


interface Lic {
    boolean check(Parameters params, double[][] points);
}


public class Lics {
    public static final Lic[] lics = {(params, points) -> { /* LIC 0 */
        for (int i = 0; i < points.length - 1; i++) {
            if (HelperFunction.calculateDistance(points[i], points[i + 1]) > params.LENGTH1) {
                return true;
            }
        }
        return false;
    }, (params, points) -> { /* LIC 1 */
        for (int i = 0; i < points.length - 2; i++) {
            if (!HelperFunction.checkTriangelFitCircle(points[i],
                                                       points[i + 1],
                                                       points[i + 2],
                                                       params.RADIUS1)) {
                return true;
            }
        }
        return false;
    }, (params, points) -> { /* LIC 2 */
        for (int i = 0; i < points.length - 2; i++) {
            if (HelperFunction.checkAngle(points[i],
                                          points[i + 1],
                                          points[i + 2],
                                          params.EPSILON)) {
                return true;
            }
        }
        return false;
    }, (params, points) -> { /* LIC 3 */
        for (int i = 0; i < points.length - 2; i++) {
            if (HelperFunction.checkArea(points[i], points[i + 1], points[i + 2], params.AREA1)) {
                return true;
            }
        }
        return false;
    }, (params, points) -> { /* LIC 4 */
        return false;
    }, (params, points) -> { /* LIC 5 */
        return false;
    }, (params, points) -> { /* LIC 6 */
        return false;
    }, (params, points) -> { /* LIC 7 */
        return false;
    }, (params, points) -> { /* LIC 8 */
        if (points.length < 5) {
            return false;
        }
        for (int i = 0; i < points.length - params.A_PTS - params.B_PTS - 2; i++) {
            double[] point1 = points[i];
            double[] point2 = points[i + params.A_PTS + 1];
            double[] point3 = points[i + params.A_PTS + params.B_PTS + 2];
            if (!HelperFunction.checkTriangelFitCircle(point1, point2, point3, params.RADIUS1)) {
                return true;
            }
        }
        return false;
    }, (params, points) -> { /* LIC 9 */
        if (points.length < 5) {
            return false;
        }
        for (int i = 0; i < points.length - params.C_PTS - params.D_PTS - 2; i++) {
            double[] point1 = points[i];
            double[] point2 = points[i + params.C_PTS + 1];
            double[] point3 = points[i + params.C_PTS + params.D_PTS + 2];
            if (HelperFunction.checkAngle(point1, point2, point3, params.EPSILON)) {
                return true;
            }
        }
        return false;
    }, (params, points) -> { /* LIC 10 */
        if (points.length < 5) {
            return false;
        }
        for (int i = 0; i < points.length - params.E_PTS - params.F_PTS - 2; i++) {
            double[] point1 = points[i];
            double[] point2 = points[i + params.E_PTS + 1];
            double[] point3 = points[i + params.E_PTS + params.F_PTS + 2];
            if (HelperFunction.checkArea(point1, point2, point3, params.AREA1)) {
                return true;
            }
        }
        return false;
    }, (params, points) -> { /* LIC 11 */
        if (points.length < 3) {
            return false;
        }
        for (int i = 0; i < points.length - params.G_PTS - 1; i++) {
            double[] point1 = points[i];
            double[] point2 = points[i + params.G_PTS + 1];
            if ((point2[0] - point1[0]) < 0) {
                return true;
            }
        }
        return false;
    }, (params, points) -> { /* LIC 12 */
        boolean ok = false;
        for (int i = 0; i < points.length - params.K_PTS - 1; ++i) {
            if (HelperFunction.calculateDistance(points[i],
                                                 points[i + params.K_PTS]) > params.LENGTH1) {
                ok = true;
                break;
            }
        }
        if (!ok) {
            return false;
        }
        for (int i = 0; i < points.length - params.K_PTS - 1; ++i) {
            if (HelperFunction.calculateDistance(points[i],
                                                 points[i + params.K_PTS]) < params.LENGTH2) {
                return true;
            }
        }
        return false;
    }, (params, points) -> { /* LIC 13 */
        if (points.length < 5) {
            return false;
        }
        boolean ok = false;
        for (int i = 0; i < points.length - params.A_PTS - params.B_PTS - 2; i++) {
            double[] point1 = points[i];
            double[] point2 = points[i + params.A_PTS + 1];
            double[] point3 = points[i + params.A_PTS + params.B_PTS + 2];
            if (!HelperFunction.checkTriangelFitCircle(point1, point2, point3, params.RADIUS1)) {
                ok = true;
                break;
            }
        }
        if (!ok) {
            return false;
        }
        for (int i = 0; i < points.length - params.A_PTS - params.B_PTS - 2; i++) {
            double[] point1 = points[i];
            double[] point2 = points[i + params.A_PTS + 1];
            double[] point3 = points[i + params.A_PTS + params.B_PTS + 2];
            if (HelperFunction.checkTriangelFitCircle(point1, point2, point3, params.RADIUS2)) {
                return true;
            }
        }
        return false;
    }, (params, points) -> { /* LIC 14 */
        if (points.length < 5) {
            return false;
        }
        boolean ok = false;
        for (int i = 0; i < points.length - params.E_PTS - params.F_PTS - 2; i++) {
            double[] point1 = points[i];
            double[] point2 = points[i + params.E_PTS + 1];
            double[] point3 = points[i + params.E_PTS + params.F_PTS + 2];
            if (HelperFunction.checkArea(point1, point2, point3, params.AREA1)) {
                ok = true;
                break;
            }
        }
        if (!ok) {
            return false;
        }
        for (int i = 0; i < points.length - params.E_PTS - params.F_PTS - 2; i++) {
            double[] point1 = points[i];
            double[] point2 = points[i + params.E_PTS + 1];
            double[] point3 = points[i + params.E_PTS + params.F_PTS + 2];
            if (!HelperFunction.checkArea(point1, point2, point3, params.AREA2)) {
                return true;
            }
        }
        return false;
    }};
}
