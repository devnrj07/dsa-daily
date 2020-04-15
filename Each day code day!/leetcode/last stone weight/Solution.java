import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {

    public static void main(String[] args) {
        int[] stones = { 2, 7, 4, 1, 8, 1 };
        findLastStone(stones);

    }

    static int findLastStone(int[] stones) {
        int length = stones.length;
        while (length > 1) {
            Arrays.sort(stones, 0, length);
            int a = stones[length - 1];
            int b = stones[length - 2];

            if (a > b) {
                stones[length-2] = a - b;
                length--;
            } else {
                length -= 2;
            }
           
            
        }

        return length == 0 ? 0 : stones[length - 1];
    }


    //using priorityQueue
    static int findLastWeightStone(int[] stones){
        //based on largest element
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);

        for (int i : stones){
            pq.offer(i);
        }

        while(pq.size() > 1){
            int a = pq.poll();
            int b = pq.poll();

            if(a > b){
                pq.offer(a-b);
            }
        }
        return pq.size() == 0 ? 0 : pq.poll();
    }
}