


//Kadane's algorithm , maintain two flags local and global max

public class Solution{
    public static void main(String[] args) {
        int[] arr = {5, 7, -3, 2, 9, 6, 16, 22, 21, 29, -14, 10, 12};
      System.out.println("max sum :"+  maximumSubArray(arr));
    }

    static int maximumSubArray(int[] array){
    
    //without helper methods
    int localMax= array[0];
    int globalMax = array[0];
    int length = array.length;
    int startIndex = 0, endIndex = 0, tempIndex = 0;
    

    for(int i =1 ; i < length ; i++){

        if(localMax < 0){
            localMax = array[i];
            tempIndex = i+1; // start of new subarray
        }else{
            localMax += array[i];
        }

        //check if localmax is greater than global max 
        if(localMax > globalMax){
            globalMax = localMax;
            startIndex = tempIndex;
             endIndex = i; //found global max yay;
        }
    }
    
    System.out.println("start index :"+ startIndex + "end index :"+ endIndex);

    return globalMax;
    
    
    
    
        // int currentMax = Integer.MIN_VALUE;
    // int totalMax =  Integer.MIN_VALUE;

    // for(int i = 0; i < array.length; i++){
    //     currentMax = Math.max(currentMax, 0) + array[i];
    //     totalMax = Math.max(totalMax, currentMax);
    // }
    // return totalMax;
} 
}