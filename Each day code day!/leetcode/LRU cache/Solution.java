import java.util.HashMap;
import java.util.Map;

public class Solution{
    public static void main(String[] args) {
        
    }

    class LRUCache{
        // pseudo head and tail for boundaries and easy access
        Node head = new Node(0,0), tail = new Node(0,0);
        //map to store key and list
        Map<Integer, Node> cache = new HashMap<>();
        int capacity = 0;
    
        LRUCache(int capacity){
            this.capacity = capacity;
        }
        
        public void put(int key, int value){
            if(cache.containsKey(key)){
                remove(cache.get(key));
            }
            //invalidate the cache
            if(cache.size() == capacity){
                remove(tail.prev); // from the back
            }

            insert(new Node(key,value));
        }

        public int get(int key){
            if(cache.containsKey(key)){
                Node currNode = cache.get(key);
                //re-validate the 🧖‍♂️ 
                remove(currNode);
                insert(currNode);
                return currNode.value;
            }else{
                return -1;
            }
        }


        //helper methods for doubly linkedlist
        private void insert(Node node){
            cache.put(node.key,node);
            Node headnext = head.next;
            head.next = node;
            node.prev = head;

            headnext.prev = node;
            node.next = headnext;
            
        }

        private void remove(Node node){
            cache.remove(node.key);
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }


        class Node{
            int key, value;
            Node prev, next;

            Node(int key, int value){
                this.key = key;
                this.value = value;
            }
        }
    }
}