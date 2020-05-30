public class Solution{
    public static void main(String[] args) {
        
    }

    static int missingInteger(int[] A){
        int length = A.length;

        Boolean[] exists = new Boolean[length+1];
        for(int i = 0; i < length ; i++){
            exists[i] = false;
        }

        for(int i = 0 ; i < length; i++){
            if( (A[i] > 0) && (A[i] <= length)){
                exists[A[i]] = true;
            }
        }

        //iterate the exists array and look for first false and return it
        for(int i = 0; i < length ; i++){
            if(!exists[i]) return i;
        }
        //for sequences like [1,2,3]
        return A[length]+1;     
    }
}