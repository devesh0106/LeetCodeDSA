package DataStructure.SlowAndFastPointer;

import java.util.LinkedList;

/*
Input: head = [1,2,3,4,5]
Output: [3,4,5]
Explanation: The middle node of the list is node 3.
**/

public class MiddleOfLinkedList {
    public static class ListNode{
    int data;
    ListNode next;
    public  ListNode(int data){
        this.data=data;
        this.next=null;
    }
    }
    public ListNode midOfLL(ListNode head){
    ListNode slow=head;
    ListNode fast=head;

    while(fast!=null && fast.next!=null){
        slow=slow.next;
        fast=fast.next.next;
    }
    return slow;
    }

    public static void main(String[] args) {
        MiddleOfLinkedList linkedList = new MiddleOfLinkedList();
        ListNode head = new ListNode(1);
        head.next= new ListNode(2);
        head.next.next= new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        System.out.println(linkedList.midOfLL(head).data);
    }
}
