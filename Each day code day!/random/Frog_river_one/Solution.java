public class Solution{
    public static void main(String[] args) {
        int[] A = {1,2,3,4,5};
        solution(11, A);
    }

    static int solution(int X, int[] A){
        int steps = X;
        boolean[] bitmap = new boolean[steps+1];
        for(int i = 0; i < A.length; i++){
            if(!bitmap[A[i]]){
                bitmap[A[i]] = true;
                steps--;
                if(steps == 0) return i;
            }

        }
        return -1;
    }
}