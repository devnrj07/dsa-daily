public class Solution{
    public static void main(String[] args) {
        
    }
    static int countDiv(int A, int B, int K){
        int a = 0, b = B/K;

        if(A>0){
            a = (A-1)/k;
        }else{
            // If A == 0 we need to count 
        // it in because 0 is divisible by any positive number
            b++;
        }

        return b - a;
    }
}