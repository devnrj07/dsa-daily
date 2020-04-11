import java.util.HashMap;
import java.util.HashSet;

/* 

Given two Linked Lists, create union and intersection lists that contain union and intersection of the elements present in the given lists. Order of elments in output lists doesn’t matter.

Example:

Input:
   List1: 10->15->4->20
   lsit2:  8->4->2->10
Output:
   Intersection List: 4->10
   Union List: 2->8->20->4->15->10

 using hashing
*/

public class Solution2{

   public static void main(String[] args) {
      
      LinkedList llist1 = new LinkedList(); 
      LinkedList llist2 = new LinkedList(); 
      LinkedList union = new LinkedList(); 
      // LinkedList intersection = new LinkedList(); 

      /*create a linked list 10->15->4->20 */
      llist1.insert(20); 
      llist1.insert(4); 
      llist1.insert(15); 
      llist1.insert(10); 

      /*create a linked list 8->4->2->10 */
      llist2.insert(10); 
      llist2.insert(2); 
      llist2.insert(4); 
      llist2.insert(8); 

      //intersection.getIntersection(llist1.head, llist2.head); 
      union.getUnion(llist1.head, llist2.head);
      System.out.println("First List is"); 
        llist1.printList(); 
  
        System.out.println("Second List is"); 
        llist2.printList(); 
  
        System.out.println("Intersection List is"); 
        union.printList();                                             

   }

   
}

class Node{

   int data;
   Node next;

   Node(int data){
      this.data = data;
   }

   public int getData() {
      return data;
   }

   public void setData(int data) {
      this.data = data;
   }

   public Node getNext() {
      return next;
   }

   public void setNext(Node next) {
      this.next = next;
   }

   @Override
   public String toString() {
      return "Node [data=" + data + ", next=" + next + "]";
   }

   
}


class LinkedList{

      Node head;

      LinkedList(){
         this.head = null;
      }

      void insert(int data){
         Node current = head;
      
         Node newNode = new Node(data);
         newNode.setNext(current);
         head = newNode;
      }

      void printList() { 
        Node temp = head; 
        while(temp != null) 
        { 
            System.out.print(temp.getData()+" "); 
            temp = temp.getNext(); 
        } 
        System.out.println(); 
    }   
    
    void getIntersection(Node head1, Node head2){
         HashSet<Integer> hset = new HashSet<>();
         //LinkedList resultList = new LinkedList();
         Node n1 = head1, n2 = head2;
         //insert all data of l1
         while(n1!=null){
            hset.add(n1.getData());
            n1 = n1.getNext();
         }

         while(n2!=null){
            if(hset.contains(n2.getData())){
               this.insert(n2.getData());
               
            }
         }
      }

      void getUnion(Node head1, Node head2 ){
         HashMap<Integer,Integer> hmap = new HashMap<>();
         Node n1 = head1, n2 = head2;

         while(n1 != null){
            if(hmap.containsKey(n1.getData())){
               int count = hmap.get(n1.getData());
               hmap.put(n1.getData(), count+1);
            }else{
               hmap.put(n1.getData(),1);
            }
         }

         while(n2 !=null){
            if(hmap.containsKey(n2.getData())){
               int count = hmap.get(n2.getData());
               hmap.put(n2.getData(), count+1);
            }else{
               hmap.put(n2.getData(),1);
            }
         }

         for(int a:hmap.keySet()){

           this.insert(a); 
    } 
      }
}