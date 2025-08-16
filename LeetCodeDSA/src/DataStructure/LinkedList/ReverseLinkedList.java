package DataStructure.LinkedList;
/*
Input: head = [1,2,3,4,5]
Output: [5,4,3,2,1]
* */
class ListNode{
    Integer data;
    ListNode next;
    public ListNode(Integer data) {
        this.data = data;
        this.next=null;
    }
}
public class ReverseLinkedList {

        public ListNode reverseList(ListNode head) {
            ListNode prev = null;
            ListNode curr = head;

            while (curr != null) {
                ListNode nextNode = curr.next; // save next node
                curr.next = prev;              // reverse the link
                prev = curr;                   // move prev forward
                curr = nextNode;               // move curr forward
            }

            return prev; // new head
        }

    public static void main(String[] args) {
        // Example: 1->2->3->4->5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ReverseLinkedList solver = new ReverseLinkedList();
        ListNode newHead = solver.reverseList(head);

        // Print reversed list
        while (newHead != null) {
            System.out.print(newHead.data + " ");
            newHead = newHead.next;
        }
        // Output: 5 4 3 2 1
    }
}
