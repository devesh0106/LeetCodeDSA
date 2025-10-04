package DataStructure.Trees;

import java.util.LinkedList;
import java.util.Queue;

//LevelOrder won't have recursion but use of Iteration ...Will use Queue
/*
* 1. Before sibling is poped/processed, push children into Queue
* 2. after every push of level, put null which will be next line
* 3. used BFS property in LevelOrder...but Pre,in,Post Order followed DFS
* */
public class BinaryTreeLevelOrder {
    //Creating Node
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

    //Creating Tree
    static class BinaryTree{
        static int idX=-1;
        static Node buildTree(int[] node){
            idX++;
            if(node[idX]==-1){
                return null;
            }
            Node newNode = new Node(node[idX]);
            newNode.left = buildTree(node);
            newNode.right= buildTree(node);
            return newNode;
        }
    }

    //LevelOrder Traversal
    static void levelOrder(Node root){
        if(root==null){
            return;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        //iteration
        while(!q.isEmpty()){
           Node currNode = q.remove();
           if(currNode==null){
               System.out.println();
               if(q.isEmpty()){
                   break;
               }
               else{
                   q.add(null);
               }
           }else{
               System.out.print(currNode.data+" ");
               if(currNode.left!=null) {
                   q.add(currNode.left);
               }
               if(currNode.right!=null){
                   q.add(currNode.right);
               }
           }
        }
    }

    public static void main(String[] args) {
        int[] node= new int[]{1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        BinaryTree binaryTree = new BinaryTree();
        Node root=binaryTree.buildTree(node);
        levelOrder(root);
    }
}
