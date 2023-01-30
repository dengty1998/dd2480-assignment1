package assignment;

class ParametersBuilder {
    double length1;
    double radius1;
    double epsilon;
    double area1;
    int q_pts;
    int quads;
    double dist;
    int n_pts;
    int k_pts;
    int a_pts;
    int b_pts;
    int c_pts;
    int d_pts;
    int e_pts;
    int f_pts;
    int g_pts;
    double length2;
    double radius2;
    double area2;

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

    Parameters build(int numpoints) {
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
