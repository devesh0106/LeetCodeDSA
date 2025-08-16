package Concepts.LinkedList;

import java.util.LinkedList;

/*
Input: 5 → 7 → 9 → null, search 7
Output: true
* */
public class SearchLL {
    public boolean isSearchLL(LinkedList<Integer> ll, int key){
        for(int i=0;i<ll.size();i++){
            if(ll.get(i)==key){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<>();
        ll.add(5);
        ll.add(7);
        ll.add(9);
        SearchLL searchLL = new SearchLL();
        System.out.println( searchLL.isSearchLL(ll,11));
    }
}
