package DataStructure.Trees;

public class BinaryTreePostOrder {

    //Creating Node
    static class Node {
        int data;
        Node left;
        Node right;

         Node (int data){
         this.data=data;
         this.left=null;
         this.right=null;
        }
    }
    //Creating Tree
    static class  BinaryTree{
        static int idx = -1;
        static Node buildTree(int[] node) {
        idx++;
        if(node[idx]==-1){
            return null;
        }
            Node newNode = new Node(node[idx]);
            newNode.left= buildTree(node);
            newNode.right=buildTree(node);
            return newNode;
        }
    }

    //PostOrder Traversal
    static void postOrder(Node root){
        if(root == null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data+ " ");
    }

    public static void main(String[] args) {
        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        BinaryTree binaryTree = new BinaryTree();
        Node root= binaryTree.buildTree(nodes);
        postOrder(root);
    }
}
