package assignment;


interface Lic {
    boolean check(Parameters params, Point[] points);
}


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
