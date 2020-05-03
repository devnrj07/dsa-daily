public class Solution{
    public static void main(String[] args) {
        
    }
    //1-pass
    // swap 0's to left and 2's to the right, 1's will remain in the middle
    public void sortColors(int[] nums) {

        int p1 = 0, p2 = nums.length - 1, index = 0;
        
        while(index <= p2){
            if(nums[index] == 0){
                //if current is 0, swap with p1 pointer, increment p1(left shift)
                nums[index] = nums[p1];
                nums[p1] = 0; //overwrite with zero
                p1++;
            }if(nums[index] == 2){
                //if current is 2, swap with p2 pointer, decrement p2 (right push)
                nums[index] = nums[p2];
                nums[p2] = 2;
                p2--;

                //may have swapped an extra 0 from the end of array that requires extra processing, so decrement index to account for it
                index--;
            }
            //move to next index to make progress
            index++;
        }
    }

    //2-pass
    public void sortColors2(int[] nums) {
        // 2-pass
        int count0 = 0, count1 = 0, count2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {count0++;}
            if (nums[i] == 1) {count1++;}
            if (nums[i] == 2) {count2++;}
        }
        for(int i = 0; i < nums.length; i++) {
            if (i < count0) {nums[i] = 0;}
            else if (i < count0 + count1) {nums[i] = 1;}
            else {nums[i] = 2;}
        }
    }
}