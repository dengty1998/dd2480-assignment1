package assignment;

import assignment.Input.Connect;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;

public class Main {
    public static void main(String[] args) {
        JSONObject json;
        try {
            String content = new String(Files.readAllBytes(Paths.get("input.json")));
            json = new JSONObject(content);
        } catch (IOException e) {
            System.out.println("Unable to read and parse JSON from input.json.");
            return;
        } catch (JSONException e) {
            System.out.println("Unable to read and parse JSON from input.json.");
            return;
        }

        ParametersBuilder builder = new ParametersBuilder();
        try {
            builder.length1 = json.getDouble("LENGTH1");
        } catch (JSONException e) {}
        try {
            builder.radius1 = json.getDouble("RADIUS1");
        } catch (JSONException e) {}
        try {
            builder.epsilon = json.getDouble("EPSILON");
        } catch (JSONException e) {}
        try {
            builder.area1 = json.getDouble("AREA1");
        } catch (JSONException e) {}
        try {
            builder.q_pts = json.getInt("Q_PTS");
        } catch (JSONException e) {}
        try {
            builder.quads = json.getInt("QUADS");
        } catch (JSONException e) {}
        try {
            builder.dist = json.getDouble("DIST");
        } catch (JSONException e) {}
        try {
            builder.n_pts = json.getInt("N_PTS");
        } catch (JSONException e) {}
        try {
            builder.k_pts = json.getInt("K_PTS");
        } catch (JSONException e) {}
        try {
            builder.a_pts = json.getInt("A_PTS");
        } catch (JSONException e) {}
        try {
            builder.b_pts = json.getInt("B_PTS");
        } catch (JSONException e) {}
        try {
            builder.c_pts = json.getInt("C_PTS");
        } catch (JSONException e) {}
        try {
            builder.d_pts = json.getInt("D_PTS");
        } catch (JSONException e) {}
        try {
            builder.e_pts = json.getInt("E_PTS");
        } catch (JSONException e) {}
        try {
            builder.f_pts = json.getInt("F_PTS");
        } catch (JSONException e) {}
        try {
            builder.g_pts = json.getInt("G_PTS");
        } catch (JSONException e) {}
        try {
            builder.length2 = json.getDouble("LENGTH2");
        } catch (JSONException e) {}
        try {
            builder.radius2 = json.getDouble("RADIUS2");
        } catch (JSONException e) {}
        try {
            builder.area2 = json.getDouble("AREA2");
        } catch (JSONException e) {}

        double[][] points;
        try {
            JSONArray jsonPoints = json.getJSONArray("POINTS");
            points = new double[jsonPoints.length()][2];
            for (int i = 0; i != jsonPoints.length(); ++i) {
                JSONArray point = jsonPoints.getJSONArray(i);
                points[i][0] = point.getInt(0);
                points[i][1] = point.getInt(1);
            }
        } catch (JSONException e) {
            System.out.println("Unable to load POINTS from input.json.");
            return;
        }

        int numpoints;
        try {
            numpoints = json.getInt("NUMPOINTS");
        } catch (JSONException e) {
            numpoints = points.length;
        }

        Parameters params = builder.build(numpoints);

        Connect[][] lcm = new Connect[15][15];
        try {
            JSONArray jsonLcm = json.getJSONArray("LCM");
            for (int i = 0; i != 15; ++i) {
                JSONArray row = jsonLcm.getJSONArray(i);
                for (int j = 0; j != 15; ++j) {
                    lcm[i][j] = row.getEnum(Connect.class, j);
                }
            }
        } catch (JSONException e) {
            System.out.println("Unable to load LCM from input.json.");
            return;
        }

        boolean[] puv = new boolean[15];
        try {
            JSONArray jsonLcm = json.getJSONArray("PUV");
            for (int i = 0; i != 15; ++i) {
                puv[i] = jsonLcm.getBoolean(i);
            }
        } catch (JSONException e) {
            System.out.println("Unable to load PUV from input.json.");
            return;
        }

        Input input = new Input(numpoints, points, params, lcm, puv);
        System.out.println(Decide.decide(input));
    }
}
