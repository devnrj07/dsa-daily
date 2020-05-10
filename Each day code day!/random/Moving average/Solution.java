// using inbuilt ds queue or linkedlist add the values in the queue to hold the sum and divide it by the queue.length to get the average
/* 
We can simply persist the current sum of elements in queue in global variable. Thus, reducing the computation in next() method.
*/

public class MovingAverage {
    LinkedList queue;
    int size;  //sliding window
    int sum = 0; // holds sum the queue
    
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
    this.queue = new LinkedList();
    this.size = size;
    }
    
    public double next(int val) {
    queue.offer(val);
    sum += val;
    if(queue.size()>this.size){
    sum -= queue.poll();
    }
    
    return (double)sum/queue.size();
    }
    }