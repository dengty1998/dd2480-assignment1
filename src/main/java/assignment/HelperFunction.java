package assignment;

public class HelperFunction {
    public static double calculateDistance(int[] point1, int[] point2) {
        int x1 = point1[0];
        int y1 = point1[1];
        int x2 = point2[0];
        int y2 = point2[1];
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    }

    public static boolean checkTriangelFitCircle(int[] point1, int[] point2, int[] point3,
                    double radius) {
        double a = point1[0] - point3[0];
        double b = point2[0] - point3[0];
        double c = point1[1] - point3[1];
        double d = point2[1] - point3[1];
        double e = ((point1[0] * point1[0] - point3[0] * point3[0])
                        + (point1[1] * point1[1] - point3[1] * point3[1])) / 2.0;
        double f = ((point2[0] * point2[0] - point3[0] * point3[0])
                        + (point2[1] * point2[1] - point3[1] * point3[1])) / 2.0;
        double det = a * d - b * c;
        double xcirc = (d * e - b * f) / det;
        double ycirc = (a * f - c * e) / det;
        double r = Math.sqrt((point1[0] - xcirc) * (point1[0] - xcirc)
                        + (point1[1] - ycirc) * (point1[1] - ycirc));

        return r <= radius;
    }

    public static boolean checkAngle(int[] point1, int[] point2, int[] point3, double EPSILON) {
        // point1, point2 and point3 create a triangle, for each angle if angle is less than
        // (pi-epsilon) or greater than (pi+epsilon) return true
        double angle1 = Math.atan2(point2[1] - point1[1], point2[0] - point1[0])
                        - Math.atan2(point3[1] - point1[1], point3[0] - point1[0]);
        double angle2 = Math.atan2(point3[1] - point2[1], point3[0] - point2[0])
                        - Math.atan2(point1[1] - point2[1], point1[0] - point2[0]);
        double angle3 = Math.atan2(point1[1] - point3[1], point1[0] - point3[0])
                        - Math.atan2(point2[1] - point3[1], point2[0] - point3[0]);
        if (angle1 < Math.PI - EPSILON || angle1 > Math.PI + EPSILON) {
            return true;
        }
        if (angle2 < Math.PI - EPSILON || angle2 > Math.PI + EPSILON) {
            return true;
        }
        if (angle3 < Math.PI - EPSILON || angle3 > Math.PI + EPSILON) {
            return true;
        }
        return false;
    }

    public static boolean checkArea(int[] point1, int[] point2, int[] point3, double AREA1) {
        double area = Math.abs(
                        (point1[0] * (point2[1] - point3[1]) + point2[0] * (point3[1] - point1[1])
                                        + point3[0] * (point1[1] - point2[1])) / 2.0);
        System.out.println(area);
        return area > AREA1;
    }
}
