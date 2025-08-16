package DataStructure.SlowAndFastPointer;
/*
Input: head = [3,2,0,-4], pos = 1
Output: true
Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).
* */
public class DetectCycleLL {
    public static class ListNode{
        int data;
        DetectCycleLL.ListNode next;
        public  ListNode(int data){
            this.data=data;
            this.next=null;
        }
    }
    public boolean detectCycle(ListNode head){
        if(head==null){
            return false;
        }
        ListNode slow= head;
        ListNode fast= head.next;

        while(slow!=fast){
            if(fast==null || fast.next==null){
                return false;
            }
            slow=slow.next;
            fast=fast.next.next;
        }

        return true;
    }

    public static void main(String[] args) {
        DetectCycleLL linkedList = new DetectCycleLL();
        DetectCycleLL.ListNode head = new DetectCycleLL.ListNode(3);
        head.next= new DetectCycleLL.ListNode(2);
        head.next.next= new DetectCycleLL.ListNode(0);
        head.next.next.next = new DetectCycleLL.ListNode(-4);
        head.next.next.next.next = head.next; // cycle
        System.out.println(linkedList.detectCycle(head));
    }
}
