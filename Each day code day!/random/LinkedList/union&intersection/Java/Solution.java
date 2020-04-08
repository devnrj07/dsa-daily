/* 

Given two Linked Lists, create union and intersection lists that contain union and intersection of the elements present in the given lists. Order of elments in output lists doesn’t matter.

Example:

Input:
   List1: 10->15->4->20
   lsit2:  8->4->2->10
Output:
   Intersection List: 4->10
   Union List: 2->8->20->4->15->10

 using linear search
*/
public class Solution {

    public static void main(String[] args) {
        
        LinkedList l1 = new LinkedList();
        LinkedList l2 = new LinkedList();
        LinkedList intersecn = new LinkedList();
        LinkedList unin = new LinkedList();

        l1.insertAtHead(1);
        l1.insertAtHead(2);
        l1.insertAtHead(10);
        l1.insertAtHead(4);
        l1.insertAtHead(5);
        

        l2.insertAtHead(8);
        l2.insertAtHead(7);
        l2.insertAtHead(4);
        l2.insertAtHead(11);
       

        intersecn.getIntersection(l1.headNode, l2.headNode); 
        unin.getUnion(l1.headNode, l2.headNode); 

        System.out.println("First List is"); 
        l1.displayList();
  
        System.out.println("Second List is"); 
        l2.displayList(); 
  
        System.out.println("Intersection List is"); 
        intersecn.displayList();
  
        System.out.println("Union List is"); 
        unin.displayList();


        
    }

    


}



class LinkedList {

     Node headNode;

    LinkedList(){
        this.headNode=null;
    }

    
    //using simple logic

    public void getIntersection(Node head1, Node head2){
        Node currentNode1 = head1, tempNode = null;

        while(currentNode1 != null){

            if(isPresent(head2, currentNode1.getData())){
                insertAtHead(currentNode1.getData());
            }

            currentNode1 = currentNode1.getNext();
        }

    }

    public void getUnion(Node head1, Node head2){
        Node currentNode1 = head1, currentNode2 = head2;

        //insert all the elements from list one
        while(currentNode1 != null){
            insertAtHead(currentNode1.getData());
            currentNode1 = currentNode1.getNext();
        }
        //now, add only missing elements from the list
        while(currentNode2 != null){
            if(!isPresent(this.headNode, currentNode2.getData())) insertAtHead(currentNode2.getData());
        
            currentNode2 = currentNode2.getNext();
        }
    }


    public void insertAtHead(int data){

        Node currentNode = headNode;
       if(currentNode == null){
           System.out.println("Empty list");
       }

        Node newNode = new Node(data, currentNode);
        headNode = newNode;
    }

    public boolean isPresent(Node head, int data){
        Node current = head;
        while(current!=null){

            if(current.getData() == data) return true;
            current = current.getNext();
        }
        return false;
    }
    

    /* public void insertAt(int data, int position){
        
        Node nodeAtPosition = getNode(position);
        
        Node newNode = new Node(data,nodeAtPosition);
        nodeAtPosition = newNode;
    }

    public Node getNode(int position){
        Node currentNode = headNode;
            int index = 0;
        while(currentNode.getNext()!=null){
            
            if(position == index){
                return currentNode;
            }
            index++;
            currentNode = currentNode.getNext();
        }
        return null;
    } */

    public void displayList(){
        Node current = headNode;

        if(current == null) System.out.println("Empty List");
        
        System.out.println("Head");
        while(current != null){
            System.out.println("->"+current.getData());
            current = current.getNext();
        }
    }
}



class Node{
    private int data;
    private Node next;

    public Node(int data, Node next){
        this.data = data;
        this.next = next;
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