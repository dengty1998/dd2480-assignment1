package assignment;

public class ParametersBuilder {
    public double length1;
    public double radius1;
    public double epsilon;
    public double area1;
    public int q_pts;
    public int quads;
    public double dist;
    public int n_pts;
    public int k_pts;
    public int a_pts;
    public int b_pts;
    public int c_pts;
    public int d_pts;
    public int e_pts;
    public int f_pts;
    public int g_pts;
    public double length2;
    public double radius2;
    public double area2;

    public ParametersBuilder() {
        length1 = 0.0;
        radius1 = 0.0;
        epsilon = 0.0;
        area1 = 0.0;
        q_pts = 2;
        quads = 1;
        dist = 0.0;
        n_pts = 3;
        k_pts = 1;
        a_pts = 1;
        b_pts = 1;
        c_pts = 1;
        d_pts = 1;
        e_pts = 1;
        f_pts = 1;
        g_pts = 1;
        length2 = 0.0;
        radius2 = 0.0;
        area2 = 0.0;
    }

    public Parameters build(int numpoints) {
        return new Parameters(numpoints,
                              length1,
                              radius1,
                              epsilon,
                              area1,
                              q_pts,
                              quads,
                              dist,
                              n_pts,
                              k_pts,
                              a_pts,
                              b_pts,
                              c_pts,
                              d_pts,
                              e_pts,
                              f_pts,
                              g_pts,
                              length2,
                              radius2,
                              area2);
    }
}
