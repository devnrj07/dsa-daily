
/* 
Given a non-empty, singly linked list with head node head, return a middle node of linked list.

If there are two middle nodes, return the second middle node.
*/

public class Solution{

    private static class ListNode{
        int data;
        ListNode next;
    }

    public ListNode findMiddle(ListNode head){
        ListNode slow = head, fast = head;

        while(fast!=null && fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}