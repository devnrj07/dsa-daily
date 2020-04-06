import java.util.Scanner;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;


public class MyClass {

	public static void main (String [] abc)  {
		Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
		
			Stack<Integer> stack=new Stack<>(); boolean isStack=true;
			Queue<Integer> queue=new LinkedList<>(); boolean isQueue=true;
			PriorityQueue<Integer> pqueue=new PriorityQueue<>(Collections.reverseOrder()); boolean isPQ=true;
			
			while( n > 0){
				int type = sc.nextInt();
                int value = sc.nextInt();

				
				if (type == 1) {
					if (isStack) stack.push(value);
					if (isQueue) queue.offer(value);
					if (isPQ) pqueue.offer(value);
				} else if (type == 2) {
					if (isStack && (stack.size()==0 || !stack.pop().equals(value))) isStack=false;
					if (isQueue && (queue.size()==0 || !queue.poll().equals(value))) isQueue=false;
					if (isPQ && (pqueue.size()==0 || !pqueue.poll().equals(value))) isPQ=false;
				}
				n--;
			}
			
			if (!isStack && !isQueue && !isPQ) System.out.println("impossible");
			else if ((isStack && isQueue) || (isStack && isPQ) || (isQueue && isPQ)) System.out.println("not sure");
			else if (isStack) System.out.println("stack");
			else if (isQueue) System.out.println("queue");
			else if (isPQ) System.out.println("priority queue");
		}
	}
}

