package assignment;

public class Parameters {
    final double LENGTH1;
    final double RADIUS1;
    final double EPSILON;
    final double AREA1;
    final int Q_PTS;
    final int QUADS;
    final double DIST;
    final int N_PTS;
    final int K_PTS;
    final int A_PTS;
    final int B_PTS;
    final int C_PTS;
    final int D_PTS;
    final int E_PTS;
    final int F_PTS;
    final int G_PTS;
    final double LENGTH2;
    final double RADIUS2;
    final double AREA2;

    public Parameters(int numpoints,
                      double length1,
                      double radius1,
                      double epsilon,
                      double area1,
                      int q_pts,
                      int quads,
                      double dist,
                      int n_pts,
                      int k_pts,
                      int a_pts,
                      int b_pts,
                      int c_pts,
                      int d_pts,
                      int e_pts,
                      int f_pts,
                      int g_pts,
                      double length2,
                      double radius2,
                      double area2) {
        if (!(0 <= length1)) {
            throw new IllegalArgumentException("LENGTH1 should be >= 0.");
        }
        if (!(0 <= radius1)) {
            throw new IllegalArgumentException("RADIUS1 should be >= 0.");
        }
        if (!(0 <= epsilon && epsilon < Math.PI)) {
            throw new IllegalArgumentException("EPSILON should be >= 0 and < pi.");
        }
        if (!(0 <= area1)) {
            throw new IllegalArgumentException("AREA1 should be >= 0.");
        }
        if (!(2 <= q_pts && q_pts <= numpoints)) {
            throw new IllegalArgumentException("Q_PTS should be >= 2 and <= NUMPOINTS.");
        }
        if (!(1 <= quads && quads <= 3)) {
            throw new IllegalArgumentException("QUADS should be >= 1 and <= 3.");
        }
        if (!(0 <= dist)) {
            throw new IllegalArgumentException("DIST should be >= 0.");
        }
        if (!(numpoints < 3) && !(3 <= n_pts && n_pts <= numpoints)) {
            throw new IllegalArgumentException("N_PTS should be >= 3 and <= NUMPOINTS.");
        }
        if (!(numpoints < 3) && !(1 <= k_pts && k_pts <= numpoints - 2)) {
            throw new IllegalArgumentException("K_PTS should be >= 1 and <= NUMPOINTS-2.");
        }
        if (!(1 <= a_pts)) {
            throw new IllegalArgumentException("A_PTS should be >= 1.");
        }
        if (!(1 <= b_pts)) {
            throw new IllegalArgumentException("B_PTS should be >= 1.");
        }
        if (!(numpoints < 5) && !(a_pts + b_pts <= numpoints - 3)) {
            throw new IllegalArgumentException("A_PTS + B_PTS should be <= NUMPOINTS-3.");
        }
        if (!(1 <= c_pts)) {
            throw new IllegalArgumentException("C_PTS should be >= 1.");
        }
        if (!(1 <= d_pts)) {
            throw new IllegalArgumentException("D_PTS should be >= 1.");
        }
        if (!(numpoints < 5) && !(c_pts + d_pts <= numpoints - 3)) {
            throw new IllegalArgumentException("C_PTS + D_PTS should be <= NUMPOINTS-3.");
        }
        if (!(1 <= e_pts)) {
            throw new IllegalArgumentException("E_PTS should be >= 1.");
        }
        if (!(1 <= f_pts)) {
            throw new IllegalArgumentException("F_PTS should be >= 1.");
        }
        if (!(numpoints < 5) && !(e_pts + f_pts <= numpoints - 3)) {
            throw new IllegalArgumentException("E_PTS + F_PTS should be <= NUMPOINTS-3.");
        }
        if (!(numpoints < 3) && !(1 <= g_pts && g_pts <= numpoints - 2)) {
            throw new IllegalArgumentException("G_PTS should be >= 1 and <= NUMPOINTS-2.");
        }
        if (!(0 <= length2)) {
            throw new IllegalArgumentException("LENGTH2 should be >= 0.");
        }
        if (!(0 <= radius2)) {
            throw new IllegalArgumentException("RADIUS2 should be >= 0.");
        }
        if (!(0 <= area2)) {
            throw new IllegalArgumentException("AREA2 should be >= 0.");
        }
        LENGTH1 = length1;
        RADIUS1 = radius1;
        EPSILON = epsilon;
        AREA1 = area1;
        Q_PTS = q_pts;
        QUADS = quads;
        DIST = dist;
        N_PTS = n_pts;
        K_PTS = k_pts;
        A_PTS = a_pts;
        B_PTS = b_pts;
        C_PTS = c_pts;
        D_PTS = d_pts;
        E_PTS = e_pts;
        F_PTS = f_pts;
        G_PTS = g_pts;
        LENGTH2 = length2;
        RADIUS2 = radius2;
        AREA2 = area2;
    }
}
