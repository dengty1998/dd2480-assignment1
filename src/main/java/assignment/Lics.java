package assignment;

/**
 * The Launch Intercept Conditions (LICs) are the conditions that must be met for the launch to be
 * successful. The Lic interface is a functional interface that takes the parameters and points as
 * arguments and returns a boolean value.
 *
 * @param params The parameters to use for the evaluation.
 * @param points The points to use for the evaluation.
 * @return true if the LIC evaluates to true, false otherwise.
 */

interface Lic {
    boolean check(Parameters params, Point[] points);
}


/**
 * The Lics class contains an array of LaunchInterceptConditions that takes the parameters and
 * points as arguments and returns a boolean value. The index of the LIC in the array corresponds to
 * the LIC number.
 *
 * Lic 0: There exists at least one set of two consecutive data points such that the distance
 * between those two data points is greater than LENGTH1. Lic 1: There exists at least one set of
 * three consecutive data points such that the three data points cannot be contained inside a circle
 * with RADIUS1. Lic 2: There exists at least one set of three consecutive data points such that the
 * second angle between those three data points is less than or equal to EPSILON or greater than or
 * equal to 2π − EPSILON. Lic 3: There exists at least one set of three consecutive data points such
 * that the area of the triangle formed by those three data points is greater than AREA1. Lic 4:
 * There exists at least one set of Q PTS consecutive data points that lie in more than QUADS
 * quadrants. LIC 5:There exists at least one set of two consecutive data points, (X[i],Y[i]) and
 * (X[j],Y[j]), such that X[j] - X[i] < 0. (where i = j-1). LIC 6:There exists at least one set of N
 * PTS consecutive data points such that at least one of the points lies a distance greater than
 * DIST from the line joining the first and last of these N PTS points. LIC 7:There exists at least
 * one set of two data points separated by exactly K PTS consecutive intervening points that are a
 * distance greater than the length, LENGTH1, apart. The conditionis not met when NUMPOINTS < 3. LIC
 * 8:There exists at least one set of three data points separated by exactly A PTS and B PTS
 * consecutive intervening points, respectively, that cannot be contained within or on a circle of
 * radius RADIUS1. The condition is not met when NUMPOINTS < 5. LIC 9:There exists at least one set
 * of three data points separated by exactly C PTS and D PTS consecutive intervening points,
 * respectively, that form an angle such that angle < (PI - EPSILON) or angle > (PI + EPSILON). The
 * condition is not met when NUMPOINTS < 5. LIC 10:There exists at least one set of three data
 * points separated by exactly E PTS and F PTS consecutive intervening points, respectively, that
 * are the vertices of a triangle with area greater than AREA1. The condition is not met when
 * NUMPOINTS < 5. LIC 11:There exists at least one set of two data points, (X[i],Y[i]) and
 * (X[j],Y[j]), separated by exactly G PTS consecutive intervening points, such that X[j] - X[i] <
 * 0. (where i < j ) The condition is not met when NUMPOINTS < 3. LIC 12:There exists at least one
 * set of two data points, separated by exactly K PTS consecutive intervening points, which are a
 * distance greater than the length, LENGTH1 and another set (or the same set) that is a distance
 * less than the length, LENGTH2. The condition is not met when NUMPOINTS < 3. LIC 13:There exists
 * at least one set of three data points separated by exactly A PTS and B PTS consecutive
 * intervening points, respectively, that cannot be contained within or on a circle of radius
 * RADIUS1 and another set (or the same set) that can be contained within or on a circle of radius
 * RADIUS2. The condition is not met when NUMPOINTS < 5. LIC 14:There exists at least one set of
 * three data points separated by exactly E PTS and F PTS consecutive intervening points,
 * respectively, that are the vertices of a triangle with area greater than AREA1 and another set
 * (or the same set) that are the vertices of a triangle with area less than AREA2. The condition is
 * not met when NUMPOINTS < 5.
 */

class Lics {
    static final Lic[] lics = {(params, points) -> { /* LIC 0 */
        for (int i = 0; i < points.length - 1; i++) {
            if (points[i].distanceTo(points[i + 1]) > params.LENGTH1) {
                return true;
            }
        }
        return false;
    }, (params, points) -> { /* LIC 1 */
        for (int i = 0; i < points.length - 2; i++) {
            if (points[i].circumcircleRadius(points[i + 1], points[i + 2]) > params.RADIUS1) {
                return true;
            }
        }
        return false;
    }, (params, points) -> { /* LIC 2 */
        for (int i = 0; i < points.length - 2; i++) {
            Double a = points[i + 1].angle(points[i], points[i + 2]);
            if (a != null && (a < Math.PI - params.EPSILON || Math.PI + params.EPSILON < a)) {
                return true;
            }
        }
        return false;
    }, (params, points) -> { /* LIC 3 */
        for (int i = 0; i < points.length - 2; i++) {
            if (points[i].triangleArea(points[i + 1], points[i + 2]) > params.AREA1) {
                return true;
            }
        }
        return false;
    }, (params, points) -> { /* LIC 4 */
        for (int i = 0; i < points.length - params.Q_PTS + 1; i++) {
            boolean[] quads = {false, false, false, false};
            for (int j = i; j < params.Q_PTS + i; j++) {
                quads[points[j].quadrant()] = true;
            }
            int quadsCount = 0;
            for (int j = 0; j < quads.length; j++) {
                if (quads[j]) {
                    quadsCount++;
                }
            }
            if (quadsCount > params.QUADS) {
                return true;
            }
        }
        return false;
    }, (params, points) -> { /* LIC 5 */
        for (int i = 1; i < points.length; i++) {
            if (points[i].x - points[i - 1].x < 0) {
                return true;
            }
        }
        return false;
    }, (params, points) -> { /* LIC 6 */
        if (points.length < 3) {
            return false;
        }
        for (int i = 0; i < points.length - params.N_PTS; i++) {
            for (int j = i + 1; j < i + params.N_PTS - 1; j++) {
                if (points[j].distanceToLine(points[i], points[i + params.N_PTS]) > params.DIST) {
                    return true;
                }
            }
        }
        return false;
    }, (params, points) -> { /* LIC 7 */
        if (points.length < 3) {
            return false;
        }
        for (int i = 0; i < points.length - params.K_PTS - 1; i++) {
            if (points[i].distanceTo(points[i + params.K_PTS + 1]) > params.LENGTH1) {
                return true;
            }
        }
        return false;
    }, (params, points) -> { /* LIC 8 */
        if (points.length < 5) {
            return false;
        }
        for (int i = 0; i < points.length - params.A_PTS - params.B_PTS - 2; i++) {
            Point a = points[i + params.A_PTS + 1];
            Point b = points[i + params.A_PTS + params.B_PTS + 2];
            if (points[i].circumcircleRadius(a, b) > params.RADIUS1) {
                return true;
            }
        }
        return false;
    }, (params, points) -> { /* LIC 9 */
        if (points.length < 5) {
            return false;
        }
        for (int i = 0; i < points.length - params.C_PTS - params.D_PTS - 2; i++) {
            Point b = points[i + params.C_PTS + 1];
            Point c = points[i + params.C_PTS + params.D_PTS + 2];
            Double a = b.angle(points[i], c);
            if (a != null && (a < Math.PI - params.EPSILON || Math.PI + params.EPSILON < a)) {
                return true;
            }
        }
        return false;
    }, (params, points) -> { /* LIC 10 */
        if (points.length < 5) {
            return false;
        }
        for (int i = 0; i < points.length - params.E_PTS - params.F_PTS - 2; i++) {
            Point b = points[i + params.E_PTS + 1];
            Point c = points[i + params.E_PTS + params.F_PTS + 2];
            if (points[i].triangleArea(b, c) > params.AREA1) {
                return true;
            }
        }
        return false;
    }, (params, points) -> { /* LIC 11 */
        if (points.length < 3) {
            return false;
        }
        for (int i = 0; i < points.length - params.G_PTS - 1; i++) {
            if (points[i + params.G_PTS + 1].x - points[i].x < 0) {
                return true;
            }
        }
        return false;
    }, (params, points) -> { /* LIC 12 */
        if (points.length < 3) {
            return false;
        }
        boolean ok = false;
        for (int i = 0; i < points.length - params.K_PTS - 1; ++i) {
            if (points[i].distanceTo(points[i + params.K_PTS + 1]) > params.LENGTH1) {
                ok = true;
                break;
            }
        }
        if (!ok) {
            return false;
        }
        for (int i = 0; i < points.length - params.K_PTS - 1; ++i) {
            if (points[i].distanceTo(points[i + params.K_PTS + 1]) < params.LENGTH2) {
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
            Point a = points[i + params.A_PTS + 1];
            Point b = points[i + params.A_PTS + params.B_PTS + 2];
            if (points[i].circumcircleRadius(a, b) > params.RADIUS1) {
                ok = true;
                break;
            }
        }
        if (!ok) {
            return false;
        }
        for (int i = 0; i < points.length - params.A_PTS - params.B_PTS - 2; i++) {
            Point a = points[i + params.A_PTS + 1];
            Point b = points[i + params.A_PTS + params.B_PTS + 2];
            if (points[i].circumcircleRadius(a, b) <= params.RADIUS2) {
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
            Point b = points[i + params.E_PTS + 1];
            Point c = points[i + params.E_PTS + params.F_PTS + 2];
            if (points[i].triangleArea(b, c) > params.AREA1) {
                ok = true;
                break;
            }
        }
        if (!ok) {
            return false;
        }
        for (int i = 0; i < points.length - params.E_PTS - params.F_PTS - 2; i++) {
            Point b = points[i + params.E_PTS + 1];
            Point c = points[i + params.E_PTS + params.F_PTS + 2];
            if (points[i].triangleArea(b, c) < params.AREA2) {
                return true;
            }
        }
        return false;
    }};
}
