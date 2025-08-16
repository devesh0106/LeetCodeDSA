package DataStructure.LinkedList;

import java.util.LinkedList;

/*
Input: 10 → 20 → 30 → null
Output: 3
* */
public class CountLL {
        public int countOfLL(LinkedList<Integer> ll){
            int count=0;
            for(int i=0;i<ll.size();i++){
                if(ll.get(i)!=null){
                    count++;
                }
            }
            return count;
        }

    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<>();
        ll.add(5);
        ll.add(7);
        ll.add(9);
        CountLL countLL = new CountLL();
        System.out.println( countLL.countOfLL(ll));
    }
}
