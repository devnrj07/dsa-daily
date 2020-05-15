public class Solution{
    public static void main(String[] args) {
        
    }

    static int[] cyclicRotations(int[] arr, int k){
        int[] rotatedArr = new int[arr.length];

        for(int i=0; i < arr.length; i++){
            int newPos = i+k;
            if(newPos < arr.length){
            rotatedArr[newPos] = arr[i];
            }else{
                newPos -= arr.legnth;
                rotatedArr[newPos] = arr[i];
            }
        
        }
        return rotatedArr;
    }
}

public int[] solution(int[] A, int K) {
    int length = A.length;  
   
   if(length < 1) return A;
   for (int i = 0; i < K; i++) {

  // take out the last element
  int temp = A[length - 1];
  for (int j = length - 1; j > 0; j--) {

    // shift array elements towards right by one place
    A[j] = A[j - 1];
  }
  A[0] = temp;
}
return A;

}