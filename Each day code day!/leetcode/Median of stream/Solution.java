public class Solution{
    public static void main(String[] args) {
        
    }

}
/* 
The invariant of the algorithm is two heaps, small and large, each represent half of the current list. The length of smaller half is kept to be n / 2 at all time and the length of the larger half is either n / 2 or n / 2 + 1 depend on n's parity.

This way we only need to peek the two heaps' top number to calculate median.

Any time before we add a new number, there are two scenarios, (total n numbers, k = n / 2):

Here we take the first scenario for example, we know the large will gain one more item and small will remain the same size, but we cannot just push the item into large. What we should do is we push the new number into small and pop the maximum item from small then push it into large (all the pop and push here are heappop and heappush). By doing this kind of operations for the two scenarios we can keep our invariant.

*/

class MedianFinder {
    // large queue holds the larger elements of the stream with the ability to provide the least element in it in O(1)
//small queue holds the smaller elements of the stream with the ability to provide the largest element in it in O(1)
    private Queue<Long> small, large;
    /** initialize your data structure here. */
    public MedianFinder() {
                        small = new PriorityQueue(Collections.reverseOrder());
                        large = new PriorityQueue();
    }
    
    public void addNum(int num) {
        if (even) {
            large.offer(num);
            small.offer(large.poll());
        } else {
            small.offer(num);
            large.offer(small.poll());
        }
        even = !even;
    }
    
    public double findMedian() {
        if (even)
        return (small.peek() + large.peek()) / 2.0;
    else
        return small.peek();
}
}