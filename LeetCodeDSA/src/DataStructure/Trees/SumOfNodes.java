package DataStructure.Trees;

//The Total Sum is equal to the sum of a left tree and the sum of a right tree of each level.

public class SumOfNodes {

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

    //Sum Of Node
    static int sumOfNode(Node root){
        if(root==null){
            return 0;
        }

        int leftSum = sumOfNode(root.left);
        int rightSum = sumOfNode(root.right);
        return leftSum+rightSum+root.data;
    }

    public static void main(String[] args) {
        int[] node= new int[]{1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        BinaryTree binaryTree = new BinaryTree();
        Node root= binaryTree.buildTree(node);
        System.out.println(sumOfNode(root));
    }
}
