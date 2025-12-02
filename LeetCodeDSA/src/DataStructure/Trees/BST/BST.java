package DataStructure.Trees.BST;

public class BST {
            static class Node {
                int data;
                Node left;
                Node right;

                Node(int data){
                    this.data=data;
                }
            }

            //Build BST
    static Node insert(Node root, int values){
           if(root == null){
               root = new Node(values);
               return root;
           }

           if(root.data>values){
               //insert left
              root.left= insert(root.left, values);
           }
           else {
               //insert right
               root.right= insert(root.right, values);
           }

           return root;
    }

    //inorder
    static void inorder(Node root){
                if(root==null){
                    return ;
                }
                inorder(root.left);
                System.out.print(root.data+" ");
                inorder(root.right);
    }

    static  boolean search(Node root, int key){
                if(root==null){
                    return false;
                }
                if(root.data< key){
                    //search right
                     return search(root.right,key);
                }
                else if (root.data==key) {
                    return true;
                }
                else {
                    //search right
                    return  search(root.left,key);
                }
    }
    public static void main(String[] args) {
        int[] values= {5,2,1,3,4,7};
        Node root=  null;
        for(int i=0;i<values.length;i++){
            root = insert(root, values[i]);
        }

        //to display
        inorder(root);
        System.out.println();
        /*for(int i=0;i<values.length;i++){
            System.out.print(values[i]+ " ");
        }*/
        if(search(root, 4)){
            System.out.println("found");
        }
        else {
            System.out.println("not found");
        }
    }
}
