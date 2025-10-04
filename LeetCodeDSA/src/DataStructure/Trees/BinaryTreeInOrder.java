package DataStructure.Trees;

public class BinaryTreeInOrder {
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }
    //Create Tree
   static class BinaryTree{
        static int idX=-1;
       public static Node buildTree(int node[]){
            idX++;
            if(node[idX]==-1){
                return null;
            }
            Node newNode = new Node(node[idX]);
            newNode.left= buildTree(node);
            newNode.right= buildTree(node);

            return newNode;
        }
   }
    //inOrder Traversal
   static void inOrder(Node root){
    if(root==null){
        return;
    }

    inOrder(root.left);
    System.out.print(root.data+" ");
    inOrder(root.right);
   }

    public static void main(String[] args) {
        int[] node= new int[]{1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        BinaryTree binaryTree = new BinaryTree();
        Node root= binaryTree.buildTree(node);
        inOrder(root);
    }
}
