import java.util.List;
import java.util.ArrayList;
public class Solution{

    public static void main(String[] args) {
        

        MinStack obj = new MinStack();
                obj.push(-2);
                obj.push(0);
                obj.push(-1);
                System.out.println(obj.getMin());
                System.out.println(obj.top());
                obj.pop();
               
                System.out.println(obj.getMin());
    }


}

class MinStack {
    
    private List<Integer> count;
    private List<Integer> stack;
    
    /* initialize your data structure here. */
    public MinStack() {
        stack = new ArrayList<>();
        count = new ArrayList<>();
        
    }
    
    public void push(int x) {
        if(count.size() == 0) {count.add(x);}
        else{
        int newMin = Math.min(x,count.get(0));
        count.add(0,newMin); 
        }
        stack.add(0,x);
    
    }
    
    public void pop() {
        count.remove(0);
        stack.remove(0);
    }
    
    public int top() {
        return stack.get(0);
    }
    
    public int getMin() {
        return count.get(0);
    }
}