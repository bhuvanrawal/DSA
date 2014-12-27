package dataStructures;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by bhuvan on 27/12/14.
 */
public class TreeDS {
    public static Tree getNewTree(){
        Tree<Integer> head = new Tree<Integer>(5);
        head.left = new Tree<Integer>(2);
        head.left.left = new Tree<Integer>(1);
        head.left.right = new Tree<Integer>(3);
        head.right = new Tree<Integer>(7);
        head.right.left = new Tree<Integer>(6);
        head.right.right = new Tree<Integer>(8);
        return head;
    }
    public static void levelOrderTraversal(Tree root){
        System.out.println("***Level Order Traversal***");
        Queue<Tree> queue = new LinkedList<Tree>();
        queue.add(root);
        Tree temp = null;
        Tree node = new Tree<Integer>(0);
        queue.add(node);
        int count = 0;
        while(!queue.isEmpty() && queue.size() != 1){
            temp = (Tree)queue.remove();
            if(Integer.valueOf(temp.value.toString()) == 0) {
                queue.add(temp);
                count++;
            } else {
                System.out.println(temp.value + " Level is " + count);
            }
            if (temp.left != null)
                queue.add(temp.left);
            if(temp.right != null)
                queue.add(temp.right);
        }
    }
    public static List<Tree> getAllLeaves(Tree root){
        List<Tree> ll = new LinkedList<Tree>();
        System.out.print("The leaves are: ");
        getAllLeaves(root, ll);
        return ll;
    }
    public static void getAllLeaves(Tree root, List<Tree> leaves){
        if (root.left == null && root.right == null){
            leaves.add(root);
            return;
        }
        if (root.left != null)
            getAllLeaves(root.left, leaves);
        if (root.right != null)
            getAllLeaves(root.right, leaves);
    }
    public static void printTree(Tree root){
        if (root == null)
            return;
        printTree(root.left);
        System.out.println(root.value+"\n");
        printTree(root.right);
    }
    public static int findHeight(Tree root){
        if (root == null)
            return 0;
        return 1 + Math.max(findHeight(root.left),findHeight(root.right));
    }
    public static void main(String [] args){
        Tree h = getNewTree();
        printTree(h);
        levelOrderTraversal(h);
        List leaves = getAllLeaves(h);
        for (Object value : leaves) {
            Tree leaf = (Tree)value;
            System.out.print(leaf.value + " ");
        }
        System.out.println(findHeight(h));
    }
    static class  Tree<E>{
        E value;
        Tree<E> left;
        Tree<E> right;
        Tree(E value){
            this.value = value;
        }
    }
}
