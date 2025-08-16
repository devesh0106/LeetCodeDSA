package DataStructure.LinkedList;

public class BasicOfLinkedList {
    //Every Linked List has Node
    public class Node{
        String data;
        Node next;
        public Node(String data) {
            this.data = data;
            this.next=null;
        }
    }
    Node head;
    //add from First
    public void addFirst(String data){
        Node newNode = new Node(data);
        if(head==null){
            head=newNode;
            return;
        }
        newNode.next=head;
        head=newNode;
    }

    //add from Last
    public void addLast(String data){
        Node newNode = new Node(data);
        if(head==null){
            head=newNode;
            return;
        }
        Node currNode = head; //assigning head value

        //then keep updating cuurrNode
        while(currNode.next!=null){
            currNode=currNode.next;
        }
        currNode.next=newNode;
    }

    //print LL
    public void printLL(){
        Node currNode = head; //assigning head value
        if(head==null){
            System.out.println("List is Empty");
            return;
        }
        //then keep updating cuurrNode
        while(currNode!=null){
            System.out.print(currNode.data +"-> ");
            currNode=currNode.next;
        }
        System.out.println("NULL");
    }

    //delete it from first
    public void deleteFirst(){
        if(head==null){
            System.out.println("List is Empty");
        }
        head=head.next;
    }

    //delete it from last
    public void deleteLast(){
        if(head==null){
            System.out.println("List is Empty");
        }

        if(head.next==null){
            head=null;
        }

        Node secondLast =head;
        Node lastNode = head.next;
        while(lastNode.next!=null){
            lastNode=lastNode.next;
            secondLast= secondLast.next;
        }
        secondLast.next=null;
    }

    public static void main(String[] args) {
        BasicOfLinkedList linkedList = new BasicOfLinkedList();
        linkedList.addFirst("a");
        linkedList.addFirst("is");
        linkedList.addFirst("This");
        linkedList.printLL();

        linkedList.addLast("Linked List");
        linkedList.printLL();

        linkedList.deleteFirst();
        linkedList.printLL();

        linkedList.deleteLast();
        linkedList.printLL();
    }
}
