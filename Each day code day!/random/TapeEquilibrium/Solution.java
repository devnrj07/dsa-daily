public class Solution{
    public static void main(String[] args) {
        
    }

    static int tapeEquilibrium(int[] A){
        int sumOfLeftPart = 0;
        int sumOfRightPart = 0;
        int differenceBetweenTheParts = Integer.MAX_VALUE;
        
        for(int a : A){
            sumOfRightPart+=a;
        }

        for(int i =1 ; i < A.length; i++){
            sumOfLeftPart+=A[i-1];
            sumOfRightPart-=A[i-1];

            int localDiff = Math.abs((sumOfLeftPart-sumOfRightPart));
            if(differenceBetweenTheParts > localDiff) differenceBetweenTheParts = localDiff;
        }
        return differenceBetweenTheParts;
    }
}