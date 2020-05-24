public class Solution{
    public static void main(String[] args) {
        
    }

    static int permCheck(int[] A){
        int xorsum = 0;
        int length = a.length;

        for(int i = 0; i < length; i++){
            xorsum = (i+1) ^ (A[i])^ xorsum;
        }
        if(xorsum == 0)
            return 1;

        return 0;
    }
}