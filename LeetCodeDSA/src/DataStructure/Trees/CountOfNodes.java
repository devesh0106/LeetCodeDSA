package DataStructure.Trees;

//To get the count of nodes, get count of left subtree(x) and count of right subtree(y).
//So Total Count of Nodes = x+y+1. 1 for their root.
//Each level will count of nodes and will send to the above level

public class CountOfNodes {

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

    static int countOfNode(Node root){
        if(root==null){
            return 0;
        }

        int leftNode = countOfNode(root.left);
        int rightNode = countOfNode(root.right);
        return leftNode+rightNode+1;
    }

    public static void main(String[] args) {
        int[] node= new int[]{1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        BinaryTree  binaryTree = new BinaryTree();
        Node root= binaryTree.buildTree(node);
        System.out.println(countOfNode(root));
    }
}
