package DataStructure.Trees;

public class HeightOfTree {

    //Create Node
    static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    //build Tree
    static class BinaryTree{
        static int idx=-1;
        static Node buildTree(int[] node){
            idx++;
            if(node[idx]==-1){
                return null;
            }

            Node newNode = new Node(node[idx]);
            newNode.left= buildTree(node);
            newNode.right= buildTree(node);
            return newNode;
        }
    }

    //Height Of Node
    static int heightOfNode(Node root){
        if(root==null){
            return 0;
        }

        int leftSum = heightOfNode(root.left);
        int rightSum = heightOfNode(root.right);
        return Math.max(leftSum,rightSum)+1;
    }
    public static void main(String[] args) {
        int[] node= new int[]{1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        BinaryTree binaryTree = new BinaryTree();
        Node root= binaryTree.buildTree(node);
        System.out.println(heightOfNode(root));
    }
}
