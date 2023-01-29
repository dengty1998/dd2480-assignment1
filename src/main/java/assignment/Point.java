package assignment;

public class HelperFunction {
    public static double calculateDistance(double[] point1, double[] point2) {
        double x1 = point1[0];
        double y1 = point1[1];
        double x2 = point2[0];
        double y2 = point2[1];
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    }

    public static boolean checkTriangelFitCircle(double[] point1,
                                                 double[] point2,
                                                 double[] point3,
                                                 double radius) {
        double a = calculateDistance(point1, point2);
        double b = calculateDistance(point2, point3);
        double c = calculateDistance(point3, point1);
        double r = a * b * c / Math.sqrt((a + b + c) * (a + b - c) * (a - b + c) * (-a + b + c));
        return r <= radius;
    }

    public static boolean checkAngle(double[] point1,
                                     double[] point2,
                                     double[] point3,
                                     double EPSILON) {
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

    public static boolean checkArea(double[] point1,
                                    double[] point2,
                                    double[] point3,
                                    double AREA1) {
        double area =
            Math.abs((point1[0] * (point2[1] - point3[1]) + point2[0] * (point3[1] - point1[1])
                            + point3[0] * (point1[1] - point2[1])) / 2.0);
        return area > AREA1;
    }
}
