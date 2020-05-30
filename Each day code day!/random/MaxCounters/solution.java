public class solution {
    public static void main(String[] args) {
        
    }

    static int maxCounters(int N, int[] A){
        int max_global_counter = 0, max_current_counter =0;

        //current Index
        int current_index, length = A.length;
        
        //counters array intialized to zero
        int[] counters = new int[length];
        

        for(int i = 0; i < length;i++){
            counters[i] =0;
        }

        for(int i = 0; i < length;i++){
            current_index = A[i] -1; //this is because counter is 1 index- based not zero

            if(A[i] <= N && A[i] > 1 ){
                counters[current_index] =
                Math.max(max_global_counter, counters[current_index]) +1;

                max_current_counter = Math.max(max_current_counter,counters[current_index]);
            }else if(A[i] == N+1){
                max_global_counter = max_current_counter;
            }
        }
        for(int i = 0; i < length;i++){
            counters[i] = Math.max(max_global_counter, counters[i]);
        }
        return counters;
    }
}