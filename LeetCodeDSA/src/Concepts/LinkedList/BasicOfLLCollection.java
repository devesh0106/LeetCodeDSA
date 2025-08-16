package Concepts.LinkedList;

import java.util.LinkedList;

public class BasicOfLLCollection {
    public static void main(String[] args) {
        LinkedList<String> ll = new LinkedList<>();
        ll.addFirst("a");
        ll.addFirst("is");
        ll.addFirst("This");
        ll.addLast("Linked List");

        for(int i=0;i<ll.size();i++){
            System.out.print(ll.get(i)+"-> ");
        }
        System.out.print("NULL");
    }
}
