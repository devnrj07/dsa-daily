public class Solution{
    public static void main(String[] args) {
        
        int[] A = {0,1,0,1,1};
        System.out.println(getPairCount(A));
    }

    static int getPairCount(int[] N){
        int length = N.length;
        int no_of_pairs_passed = 0;
        int zeros = 0;

        for(int i = 0; i < length; i++){
            if(0 == N[i]){
                ++zeros;
            }
            if( 1 == N[i]){
                no_of_pairs_passed +=zeros;
                if(no_of_pairs_passed > 1000000000){
                    return -1;
                }
            }
        }
        return no_of_pairs_passed;
    }
}