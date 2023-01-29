package assignment;

import assignment.Input.Connect;

public class Main {
    public static void main(String[] args) {
        Parameters params = new Parameters(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

        Connect[][] lcm = new Connect[15][15];
        for (int i = 0; i != 15; ++i) {
            for (int j = 0; j != 15; ++j) {
                lcm[i][j] = Connect.ANDD;
            }
        }

        boolean[] puv = new boolean[15];
        for (int i = 0; i != 15; ++i) {
            puv[i] = true;
        }

        double[][] points = new double[50][2];
        for (int i = 0; i != points.length; ++i) {
            points[i][0] = i;
            points[i][1] = i / 2.0;
        }

        Input input = new Input(points.length, points, params, lcm, puv);
        System.out.println(Decide.decide(input));
    }
}
