public class TwoDArrayMethods {
    public static int[][] transpose(int[][] anArray){
        
        if(anArray == null) {
            return null;
        }
        int[][] array = new int[anArray[0].length][anArray.length];

        for(int i = 0; i < anArray.length; i ++) {

            for(int j = 0; j< anArray[0].length; j++) {
                array[j][i] = anArray[i][j];
            }
        }
        return array;
    }
} 
