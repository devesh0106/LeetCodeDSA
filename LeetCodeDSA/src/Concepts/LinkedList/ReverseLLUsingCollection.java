package Concepts.LinkedList;

import java.util.LinkedList;

public class ReverseLLUsingCollection {
    public LinkedList<Integer> reverseLinkedList(LinkedList<Integer> ll){
        LinkedList<Integer> revLL = new LinkedList<>();

        for(int i=ll.size()-1;i>=0;i--){
         revLL.add(ll.get(i));
        }
        return revLL;
    }

    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<>();
        ll.add(5);
        ll.add(7);
        ll.add(9);
        ReverseLLUsingCollection reverseLL = new ReverseLLUsingCollection();
        System.out.println(reverseLL.reverseLinkedList(ll));
    }
}
