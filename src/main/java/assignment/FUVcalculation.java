package assignment;

public class FUVcalculation {

    public boolean[] setupFUV(boolean[] PUV, boolean[][] PUM) {

        boolean[] FUV = new boolean[15];

        for(int i = 0; i < 15; i++){
            if(!PUV[i]){
                FUV[i] = true;
            }
            else{
                FUV[i] = true;
                for(int j = 0; j < 15; j++){
                    if(!PUM[i][j]){
                        FUV[i] = false;
                        break;
                    }
                }
            }
        }
        return FUV;


    }

}