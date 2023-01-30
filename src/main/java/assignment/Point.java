package assignment;

public class Point {
    public final double x;
    public final double y;

    public Point(double[] point) {
        x = point[0];
        y = point[1];
    }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public static Point[] makePoints(double[][] data) {
        Point[] points = new Point[data.length];
        for (int i = 0; i != data.length; ++i) {
            points[i] = new Point(data[i]);
        }
        return points;
    }

    public double norm() {
        return Math.sqrt(Math.pow(x, 2.0) + Math.pow(y, 2.0));
    }

    public Point add(Point b) {
        return new Point(x + b.x, y + b.y);
    }

    public Point subtract(Point b) {
        return new Point(x - b.x, y - b.y);
    }

    public double distanceTo(Point b) {
        return subtract(b).norm();
    }

    public double circumcircleRadius(Point b, Point c) {
        if (triangleArea(b, c) == 0) {
            return Math.max(Math.max(distanceTo(b), distanceTo(c)), b.distanceTo(c)) / 2.0;
        }
        double ab = distanceTo(b);
        double bc = b.distanceTo(c);
        double ca = c.distanceTo(this);
        return ab * bc * ca / triangleArea(b, c) / 4.0;
    }

    public double triangleArea(Point b, Point c) {
        return Math.abs((x - c.x) * (b.y - y) - (x - b.x) * (c.y - y)) / 2.0;
    }

    public double dotProduct(Point b) {
        return x * b.x + y * b.y;
    }

    // Finds angle BAC
    public Double angle(Point b, Point c) {
        if (distanceTo(b) == 0 || distanceTo(c) == 0) {
            return null;
        }
        Point ab = subtract(b);
        Point ac = subtract(c);
        return Math.acos(ab.dotProduct(ac) / ab.norm() / ac.norm());
    }

    public int quadrant() {
        if (x >= 0 && y >= 0) {
            return 0;
        } else if (x >= 0 && y < 0) {
            return 1;
        } else if (x < 0 && y >= 0) {
            return 2;
        } else {
            return 3;
        }
    }

    // Distance from A to line BC, if B=C, distance from A to this point
    public double distanceToLine(Point b, Point c) {
        if (b.distanceTo(c) == 0) {
            return distanceTo(b);
        }
        return Math.abs((c.x - b.x) * (b.y - y) - (b.x - x) * (c.y - b.y)) / b.distanceTo(c);
    }
}
