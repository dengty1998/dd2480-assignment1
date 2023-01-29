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
        for (int i = 0; i < points.length - params.Q_PTS + 1; i++) {
            boolean[] FoundQuads = {false, false, false, false};
            for (int j = i; j < params.Q_PTS + i; j++) {
                if (points[j][0] >= 0 && points[j][1] >= 0) {
                    FoundQuads[0] = true;
                }
                if (points[j][0] < 0 && points[j][1] >= 0) {
                    FoundQuads[1] = true;
                }
                if (points[j][0] <= 0 && points[j][1] < 0) {
                    FoundQuads[2] = true;
                }
                if (points[j][0] > 0 && points[j][1] < 0) {
                    FoundQuads[3] = true;
                }
            }

            int QuadsWithPoints = 0;
            for (int l = 0; l < FoundQuads.length; l++) {
                if (FoundQuads[i]) {
                    QuadsWithPoints++;
                }
            }
            if (QuadsWithPoints > params.QUADS) {
                return true;
            }
        }

        return false;
    }, (params, points) -> { /* LIC 5 */
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] - points[i - 1][0] < 0) {
                return true;
            }
        }
        return false;
    }, (params, points) -> { /* LIC 6 */
        for (int i = 0; i < points.length - params.N_PTS; i++) {
            // First loop changes the data set moving it from start of NUMPOINTS to end.
            if (points[i][0] == points[i + params.N_PTS][0]
                            && points[i][1] == points[i + params.N_PTS][1]) {
                // checking to see if start and end points are the same

                for (int j = i + 1; j < i + params.N_PTS - 1; j++) { // i is the start point so
                                                                     // start on +1
                    // -1 so that we don't waste time on end point
                    // Second loop iterates through every point checking distance compared to DIST.
                    if (HelperFunction.calculateDistance(points[i], points[j]) > params.DIST) {
                        return true;
                    }
                }
            } else {
                double x1 = points[i][0];
                double x2 = points[i + params.N_PTS][0];
                double y1 = points[i][1];
                double y2 = points[i + params.N_PTS][1];
                double a = y2 - y1;
                double b = x1 - x2;
                double c = x2 * y1 - x1 * y2;
                for (int j = i + 1; j < i + params.N_PTS; j++) {
                    if (Math.abs((a * points[j][0] + b * points[j][1] + c)
                                    / Math.sqrt(a * a + b * b)) > params.DIST) {
                        return true;
                    }

                }
            }
        }
        return false;
    }, (params, points) -> { /* LIC 7 */
        for (int i = 0; i < points.length - params.K_PTS - 1; i++) {
            if (HelperFunction.calculateDistance(points[i],
                                                 points[i + params.K_PTS + 1]) > params.LENGTH1) {
                return true;
            }
        }
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
