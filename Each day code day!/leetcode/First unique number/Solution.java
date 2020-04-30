import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;

public class Solution{
    public static void main(String[] args) {
        
    }
}
//LRU cache strategy: map with DLL
//using two sets unique and all -> the idea is to add to both if element is not present, if element is present then remove from unique set
class FirstUnique {
    private Set<Integer> uniqueEle = new LinkedHashSet<>(); // this preserves the insertion order
    private Set<Integer> allEle = new HashSet<>();

    public FirstUnique(int[] nums) {
        for(int num : nums){
            add(num);
        }
    }
    
    public int showFirstUnique() {
        if(uniqueEle.isEmpty()) return -1;

        return uniqueEle.iterator().next(); // first element as per insertion order
    }
    
    public void add(int value) {
        if(allEle.add(value)){   // add to both if not present in all set this return true/false(is already present)
            uniqueEle.add(value);
        }else{
            uniqueEle.remove(value);
        }
    }


    class Node{
        Node prev, next;
        int value;
        public Node(int value){
            this.value = value;
        }
    }

    insert(Node node){

    }
}