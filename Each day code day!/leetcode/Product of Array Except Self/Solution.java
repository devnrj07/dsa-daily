import java.util.Arrays;

public class Solution{
    public static void main(String[] args) {
        
    }

    //breaking the array into L & R sub array for storing left elements products and right elements product
    static int[] productOfArray(int[] nums){
        int length = nums.length;
        int[] output = new int[length];
        int[] left = new int[length];
        int[] right = new int[length];
        
        //populate the left Array
        left[0] = 1; //nothing on left of it
        for(int i = 1; i < length; i++){
            left[i] = left[i-1] * nums[i-1];
        }

        //populate the right array with product of elements on the right
        right[length-1] = 1; // nothing on the right of it
        for(int i = length -2 ; i > 0; i++){
            right[i] = right[i+1] * nums[i+1];
        }

        //finally constructing the answer array where product[i] = product of elments on it left and right left[i] * right[i]
        for(int i = 0 ; i < length ; i++){
            output[i] = left[i] * right[i];   
        }

        return output;
    }

    //in this approach simple use output array as left array and use a variable R to keep track of product on its right
    static int[] productOfArrayinO1space(int[] nums){
        int length = nums.length;
        int[] output = new int[length];
        int R = 1 ;

        output[0] = 1;
        for(int i = 1; i < length; i++){
            output[i] = output[i-1] * nums[i-1];
        }

        // R contains the product of all the elements to the right
        R = 1;
        for(int i = length - 1; i > 0 ; i--){
            output[i] *=R;
            R*=nums[i];
        }

        return output;
    }
}