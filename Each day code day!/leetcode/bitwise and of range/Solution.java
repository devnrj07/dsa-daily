public class Solution{
    public static void main(String[] args) {
        
    }

    //The little trick is to return the left common parts of two numbers. When not equal, move right for 1 bit, util equal, return the common parts.
    public int rangeBitwiseAnd(int m, int n) {
        int i = 0; // i means we have how many bits are 0 on the right
        while(m != n){
          m >>= 1;
          n >>= 1;
          i++;  
        }  
        return m << i;  
}