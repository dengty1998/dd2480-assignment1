package assignment;

public class LaunchInterceptorConditions {

    public static boolean ConditionZero(double LENGTH1, int[][] POINTS) {
        for (int i = 0; i < POINTS.length - 1; i++) {
            if (HelperFunction.calculateDistance(POINTS[i], POINTS[i + 1]) > LENGTH1) {
                return true;
            }
        }
        return false;
    }

    public static boolean ConditionOne(double RADIUS1, int[][] POINTS) {

        for (int i = 0; i < POINTS.length - 2; i++) {
            if (!HelperFunction.checkTriangelFitCircle(POINTS[i], POINTS[i + 1], POINTS[i + 2],
                            RADIUS1)) {
                return true;
            }
        }
        return false;
    }

    public static boolean Conditiontwo(double EPSILON, int[][] POINTS) {
        for (int i = 0; i < POINTS.length - 2; i++) {
            if (HelperFunction.checkAngle(POINTS[i], POINTS[i + 1], POINTS[i + 2], EPSILON)) {
                return true;
            }
        }
        return false;
    }

    public static boolean ConditionThree(double AREA1, int[][] POINTS) {
        for (int i = 0; i < POINTS.length - 2; i++) {
            if (HelperFunction.checkArea(POINTS[i], POINTS[i + 1], POINTS[i + 2], AREA1)) {
                return true;
            }
        }
        return false;
    }

    public static boolean ConditionFour(int QPTS, int QUADS, int[][] POINTS) {
        if(QPTS < 2 || QPTS > POINTS.length){
            return false;
        }
    
        if(QUADS < 1 || QUADS > 3){
            return false;
        }

        for(int i = 0; i < POINTS.length - QPTS -1; i++){
            boolean[] FoundQuads = {false, false, false, false};
            for(int j = 0; i < QPTS; j++){
                if(POINTS[i][0] >= 0 && POINTS[i][1] >= 0){
                    FoundQuads[0] = true;
                }
                if(POINTS[i][0] < 0 && POINTS[i][1] >= 0){
                    FoundQuads[1] = true;
                }
                if(POINTS[i][0] <= 0 && POINTS[i][1] < 0){
                    FoundQuads[2] = true;
                }
                if(POINTS[i][0] > 0 && POINTS[i][1] < 0){
                    FoundQuads[3] = true;
                }
            }

            int QuadsWithPoints = 0;
            for(int l = 0; l < FoundQuads.length; l++){
                if(FoundQuads[i]){
                    QuadsWithPoints++;
                }
            }
            if(QuadsWithPoints > QUADS){
                return true;
            }
        }

        return false;
    }
    

    public static boolean ConditionFive(int[][] POINTS) {
        for(int i = 1; i < POINTS.length; i++){
            if(POINTS[i][0] - POINTS[i-1][0] < 0){
                return true;
            }
        }
        return false;
    }

    public static boolean ConditionSix(int NPTS, double DIST, int NUMPOINTS, int[][] POINTS) {
        if(3 > NPTS || NPTS > NUMPOINTS){
            return false;
        }
        if(0 > DIST){
            return false;
        }
        for(int i = 0; i < POINTS.length - NPTS; i++){
            // First loop changes the data set moving it from start of NUMPOINTS to end.
            if(POINTS[i][0] == POINTS[i + NPTS][0] && POINTS[i][1] == POINTS[i + NPTS][1]){
                // checking to see if start and end points are the same
                
                for(int j = i + 1;j < i + NPTS - 1; j++  ){ // i is the start point so start on +1 
                    //-1 so that we don't waste time on end point
            // Second loop iterates through every point checking distance compared to DIST.
                    if(HelperFunction.calculateDistance(POINTS[i], POINTS[j]) > DIST){
                        return true;
                    }
                }
            }
            else{
                for(int j = i + 1; j < i + NPTS; j++){
                    int[] MidwayPoint = {(POINTS[i][0]-POINTS[i + NPTS][0])/2, (POINTS[i][1]-POINTS[i + NPTS][1])/2};
                    if(HelperFunction.calculateDistance(MidwayPoint, POINTS[j]) > DIST){
                        return true;
                    }
                    
                }
            }
        }


        return false;
    }

    public static boolean ConditionSeven(double LENGTH1, int KPTS, int NUMPOINTS, int[][] POINTS) {
        if(1 > KPTS || KPTS > (NUMPOINTS - 2)){
            return false;
        }
        if(NUMPOINTS < 3){
            return false;
        }
        for(int i = 0; i < NUMPOINTS - KPTS - 1; i++){
            if(HelperFunction.calculateDistance(POINTS[i], POINTS[i + KPTS + 1]) > LENGTH1){
                return true;
            }
        }
        return false;
    }

    public static boolean ConditionEight(int APTS, int BPTS, double RADIUS1, int NUMPOINTS,
                    int[][] POINTS) {
        if (NUMPOINTS < 5 || APTS < 1 || BPTS < 1 || APTS + BPTS > NUMPOINTS - 3) {
            return false;
        }
        for (int i = 0; i < NUMPOINTS - APTS - BPTS - 2; i++) {
            int[] point1 = POINTS[i];
            int[] point2 = POINTS[i + APTS + 1];
            int[] point3 = POINTS[i + APTS + BPTS + 2];
            if (!HelperFunction.checkTriangelFitCircle(point1, point2, point3, RADIUS1)) {
                return true;
            }
        }
        return false;
    }

    public static boolean ConditionNine(int CPTS, int DPTS, double EPSILON, int NUMPOINTS,
                    int[][] POINTS) {
        if (NUMPOINTS < 5 || CPTS < 1 || DPTS < 1 || CPTS + DPTS > NUMPOINTS - 3) {
            return false;
        }
        for (int i = 0; i < NUMPOINTS - CPTS - DPTS - 2; i++) {
            int[] point1 = POINTS[i];
            int[] point2 = POINTS[i + CPTS + 1];
            int[] point3 = POINTS[i + CPTS + DPTS + 2];
            if (HelperFunction.checkAngle(point1, point2, point3, EPSILON)) {
                return true;
            }
        }
        return false;
    }

    public static boolean ConditionTen(int EPTS, int FPTS, double AREA1, int NUMPOINTS,
                    int[][] POINTS) {
        if (NUMPOINTS < 5 || EPTS < 1 || FPTS < 1 || EPTS + FPTS > NUMPOINTS - 3) {
            return false;
        }
        for (int i = 0; i < NUMPOINTS - EPTS - FPTS - 2; i++) {
            int[] point1 = POINTS[i];
            int[] point2 = POINTS[i + EPTS + 1];
            int[] point3 = POINTS[i + EPTS + FPTS + 2];
            if (HelperFunction.checkArea(point1, point2, point3, AREA1)) {
                return true;
            }
        }
        return false;
    }

    public static boolean ConditionEleven(int GPTS, int NUMPOINTS, int[][] POINTS) {
        if (NUMPOINTS < 3 || GPTS < 1 || GPTS > NUMPOINTS - 2) {
            return false;
        }
        for (int i = 0; i < NUMPOINTS - GPTS - 1; i++) {
            int[] point1 = POINTS[i];
            int[] point2 = POINTS[i + GPTS + 1];
            if ((point2[0] - point1[0]) < 0) {
                return true;
            }
        }
        return false;
    }

    public static boolean ConditionTwelve(int KPTS, double LENGTH2, int NUMPOINTS, int[][] POINTS) {
        // do something
        return true;
    }

    public static boolean ConditionThirteen(int APTS, int BPTS, double RADIUS1, double RADIUS2,
                    int NUMPOINTS, int[][] POINTS) {
        // do something
        return true;
    }

    public static boolean ConditionFourteen(int EPTS, int FPTS, double AREA1, double AREA2,
                    int NUMPOINTS, int[][] POINTS) {
        // do something
        return true;
    }
}
