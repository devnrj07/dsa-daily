
/* 


*/


public class Solution{

    public static void main(String[] args) {
        int[] heights = {3, 6, 3, 4, 1};
        int[] heights2 = {3, 4, 4, 4, 1};
        int [] heights3 = {-1, -3, -7, -2};
        System.out.println(findWitnesses(heights));
        System.out.println(findWitnesses(heights2));
        System.out.println(findWitnesses(heights3));

    }
    //start from the back, so last element or (first during the loop will always be greater)
    static int findWitnesses(int heights[]){
        int maxHeight =  -(int)1000.5 ; // -infinity float
        int witnessCount = 0;
        for(int i =heights.length-1 ; i > 0 ; i--){
            if(heights[i] > maxHeight){
                witnessCount++;
                maxHeight = heights[i];
            }
        }
        return witnessCount;
    }

    
}