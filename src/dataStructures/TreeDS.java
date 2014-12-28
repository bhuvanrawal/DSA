package dataStructures;

import java.util.*;

/**
 * Created by bhuvan on 27/12/14.
 */
public class TreeDS {
    /**
     *
     * @return
     */
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
    /**
     * http://www.geeksforgeeks.org/maximum-width-of-a-binary-tree/
     * @param root
     */
    public static int maxWidthBinaryTree(Tree root){
        // do a level order traversal and at each level update the count
        // of that level save the count into max if its greater than previous max
        return 0;
    }

    /**
     * http://www.geeksforgeeks.org/g-fact-18/
     * @param n
     * Catalan number
     */
    public static int totalNoOfBSTWithNKeys(int n){
        return 0;
    }

    /**
     * http://www.geeksforgeeks.org/foldable-binary-trees/
     * One approach is to create mirror of a tree and check if its same as the given tree
     * @param root
     * @return
     */
    public static boolean isFoldableBST(Tree root){
       return true;
    }

    /**
     * http://www.geeksforgeeks.org/print-nodes-at-k-distance-from-root/
     * Two approaches can be thought about:
     * 1. Do a level order traversal and print nodes  at kth level
     * 2. Recursive approach, call the method again with its children and updated length
     *    if length=k print the number and dont call its children
     * @param root
     */
    public static void printKDistanceFromRoot(Tree root){

    }
    /**
     * http://www.geeksforgeeks.org/double-tree/
     * @param root: Tree root
     */
    public static void doubleTree(Tree root){
        if (root == null)
            return;
        Tree newNode = new Tree(root.value);
        newNode.left = root.left;
        root.left = newNode;
        doubleTree(newNode.left);
        doubleTree(root.right);
    }
    /**
     *
     * @param root Root of the tree for which diameter has to be found out
     * @return
     */
    public static int getDiameter(Tree root){
        int leftHeight = findHeight(root.left);
        int rightHeight = findHeight(root.right);
        int leftDia = getDiameter(root.left);
        int rightDia = getDiameter(root.right);
        return Math.max(leftHeight+rightHeight, Math.max(leftDia, rightDia));
    }

    /**
     *
     * @param root
     */
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

    /**
     *
     * @param root
     * @return
     */
    public static List<Tree> getAllLeaves(Tree root){
        List<Tree> ll = new LinkedList<Tree>();
        System.out.print("The leaves are: ");
        getAllLeaves(root, ll);
        return ll;
    }

    /**
     *
     * @param root
     * @param leaves
     */
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

    /**
     *
     * @param root
     */
    public static void printTree(Tree root){
        if (root == null)
            return;
        printTree(root.left);
        System.out.println(root.value+"\n");
        printTree(root.right);
    }

    /**
     *
     * @param root
     * @return
     */
    public static int findHeight(Tree root){
        if (root == null)
            return 0;
        return 1 + Math.max(findHeight(root.left),findHeight(root.right));
    }

    /**
     *
     * @param root
     * @return
     */
    public static boolean checkIfBST(Tree<Integer> root){
        return checkIfBST(root, Integer.MIN_VALUE,Integer.MAX_VALUE);
    }

    /**
     *
     * @param root
     * @param min
     * @param max
     * @return
     */
    public static boolean checkIfBST(Tree<Integer> root, int min, int max){
        if (root == null)
            return true;
        if (root.left != null && root.left.value > root.value)
            return false;
        if (root.right != null && root.right.value < root.value)
            return false;
        if(root.left != null && root.left.value > max){
            return false;
        } else if(root.left != null)
            max = Math.min(root.left.value, max);
        if(root.right != null && root.right.value < min){
            return false;
        } else if (root.right != null)
            min = Math.max(root.right.value, min);
        return checkIfBST(root.left,Integer.MIN_VALUE,max) & checkIfBST(root.right,min,Integer.MAX_VALUE);
    }

    /**
     *
     * @param root
     */
    public static void printLeftView(Tree<Integer> root){
        if (root == null )
            return;
        else {
            System.out.println(root.value);
        }
        if (root.left != null) {
            printLeftView(root.left);
        } else if (root.right != null){
            printLeftView(root.right);
        }
    }

    /**
     *
     * @param root
     */
    public static void printRightView(Tree<Integer> root){
        if (root == null )
            return;
        else {
            System.out.println(root.value);
        }
        if (root.right != null) {
            printRightView(root.right);
        } else if (root.left != null){
            printRightView(root.left);
        }
    }

    /**
     * TODO
     * @param root top of of the tree
     */
    public static void printTopView(Tree<Integer> root){

    }
    /**
     * TODO
     * @param root top of of the tree
     */
    public static void printBottomView(Tree<Integer> root){

    }
    public static List inOrderTraversalRecursion(Tree root){
        List newList = new LinkedList();
        inOrderTraversalRecursion(root, newList);
        return newList;
    }

    /**
     *
     * @param root
     * @param list
     */
    public static void inOrderTraversalRecursion(Tree root, List list){
        if (root == null){
            return;
        }
        else{
            inOrderTraversalRecursion(root.left, list);
            list.add(root);
            inOrderTraversalRecursion(root.right, list);
        }
    }

    /**
     *
     * @param root
     */
    public static void preOrderTraversalRecursion(Tree root){
        List newList = new LinkedList();
        preOrderTraversalRecursion(root,newList);
    }

    /**
     *
     * @param root
     * @param list
     */
    public static void preOrderTraversalRecursion(Tree root, List list){
        if (root == null){
            return;
        }
        else{
            list.add(root);
            preOrderTraversalRecursion(root.left,list);
            preOrderTraversalRecursion(root.right,list);
        }
    }

    /**
     *
     * @param root
     */
    public static void postOrderTraversalRecursion(Tree root){
        List newList = new LinkedList();
        postOrderTraversalRecursion(root,newList);
    }

    /**
     *
     * @param root
     * @param list
     */
    public static void postOrderTraversalRecursion(Tree root, List list){
        if (root == null){
            return;
        }
        else{
            postOrderTraversalRecursion(root.left,list);
            postOrderTraversalRecursion(root.right,list);
            list.add(root);
        }
    }
    /**
     * todo explain the algorithm
     * @param root
     */
    public static void preOrderTraversalIteration(Tree root){
        Stack stack = new Stack();
        stack.push(root);
        while(!stack.isEmpty()){
            Tree temp = (Tree)stack.pop();
            if (temp != null) {
                System.out.print(" " + temp.value);
                stack.push(temp.right);
                stack.push(temp.left);
            }
        }
    }

    /**
     * http://www.geeksforgeeks.org/write-an-efficient-c-function-to-convert-a-tree-into-its-mirror-tree/
     * @param root
     */
    public static void getMirror(Tree<Integer> root){
        if (root == null){
            return;
        }
        // swap left and right children
        Tree temp = root.right;
        root.right = root.left;
        root.left = temp;
        temp = null;
        getMirror(root.left);
        getMirror(root.right);

    }
    /**
     * todo explain the algorithm
     * @param root
     */
    public static void inOrderTraversalIteration(Tree root){
        Stack stack = new Stack();
        stack.push(root);
        boolean done = false;
        Tree current = root;
        while(!done){
            if(current!=null){
                stack.push(current);
                current = current.left;
            } else {
                if(stack.isEmpty()){
                    done = true;
                } else {
                    current = (Tree)stack.pop();
                    System.out.println(current.value);
                    current = current.right;
                }
            }
        }
    }

    /**
     *
     * @param root
     * @return
     */
    public static int size(Tree root){
        if(root == null)
            return 0;
        else {
            return 1 + size(root.left) + size(root.right);
        }
    }

    /**
     *
     * @param root
     * @return
     */
    public static int checkSum(Tree<Integer> root){
        if (root == null)
            return 0;
        int left = checkSum(root.left);
        int right = checkSum(root.right);
        if (left == -1 || right == -1)
            return -1;
        if (root.value == left+right){
            return root.value;
        } else {
            System.out.println("Property not satisfied");
            return -1;
        }
    }
    /**
     * @link http://www.geeksforgeeks.org/convert-an-arbitrary-binary-tree-to-a-tree-that-holds-children-sum-property/
     */
    public static int convertToSumTree(Tree<Integer> root){
        if (root == null){
            return 0;
        }
        int result = checkSum(root.left)+checkSum(root.right);
        if (result==0)
            return root.value;
        else if(root.value != result){
            root.value = result;
        }
        return root.value;
    }
    /**
     * This method checks if the two trees are identical to each other
     * They should have the same structure and contain the same elements
     * @param root1 Root of the first tree
     * @param root2 Root of the second tree
     * @return boolean if the trees are identical
     */
    public static boolean isIdentical(Tree root1, Tree root2){
        if (root1 == root2 && root1 == null){
            return true;
        }
        else if (root1!=null && root2 != null){
            return false;
        }
        if (root1.value == root2.value)
            return isIdentical(root1.left,root2.left) & isIdentical(root1.right,root2.right);
        else
            return false;
    }

    /**
     *
     * @param root
     * @return
     */
    public static int treeHeight(Tree root){
        if (root == null)
            return 0;
        else {
            return 1 + Math.max(treeHeight(root.left), treeHeight(root.right));
        }
    }

    /**
     *
     * @param root
     */
    public static void deleteTree(Tree root){
        if (root == null){
            return;
        } else{
            deleteTree(root.left);
            deleteTree(root.right);
            root = null;
        }
    }

    /**
     *
     * @param root
     */
    public static void printRootToLeafPaths(Tree root){
        List newList = new LinkedList();
        newList.add(root);
        printRootToLeafPaths(root, newList);
    }

    /**
     *
     * @param root
     * @param list
     */
    public static void printRootToLeafPaths(Tree root, List list){
        List newList = new LinkedList(list);
        if (root.left == null && root.right == null) {
            for (Object nodeObject : list){
                Tree node = (Tree)nodeObject;
                System.out.print(" "+node.value+" ");
            }
            System.out.println();
        }
        else if (root.left != null && root.right == null){
            newList.add(root);
            printRootToLeafPaths(root.left, newList);
        }
        else if(root.right !=null && root.left == null) {
            newList.add(root.left);
            printRootToLeafPaths(root.right, newList);
        } else {
            newList.add(root.left);
            printRootToLeafPaths(root.left, newList);
            newList.remove(root.left);
            newList.add(root.right);
            printRootToLeafPaths(root.right, newList);
        }
    }

    /**
     *
     * @param root
     * @param left
     * @param right
     */
    public static void printLCA(Tree<Integer> root, int left, int right){
        if (root == null){
            System.out.println("LCA not found");
        } else if(root.value > left && root.value> right){
            printLCA(root.left,left,right);
        } else if (root.value< left && root.value < right){
            printLCA(root.right,left,right);
        } else {
            // LCA is the root
            System.out.println("LCA found: " + root.value);
        }
    }

    /**
     *
     * @param root
     * @return
     */
    public static int findMinInBST(Tree<Integer> root){
        while (root.left !=null){
            root = root.left;
        }
        return root.value;
    }

    /**
     *
     * @param root
     * @return
     */
    public static int getLeafCount(Tree root){
        if (root == null){
            return 0;
        } else if (root.left == null && root.right == null){
            return 1;
        } else {
            return 1 + getLeafCount(root.left) + getLeafCount(root.right);
        }
    }
    public static void main(String [] args){
        Tree h = getNewTree();
        size(h);
//        printTree(h);
//        levintelOrderTraversal(h);
//        List leaves = getAllLeaves(h);
//        for (Object value : leaves) {
//            Tree leaf = (Tree)value;
//            System.out.print(leaf.value + " ");
//        }
//        System.out.println(findHeight(h));
//        System.out.println("Is BST?:"+ checkIfBST(h));
//        printLeftView(h);
//        printRightView(h);
//        preOrderTraversalRecursion(h);
//        inOrderTraversalRecursion(h);
//        postOrderTraversalRecursion(h);
//        preOrderTraversalIteration(h);
        // printTopView(h); todo
        // printBottomView(h); todo
//        inOrderTraversalIteration(h);
        printRootToLeafPaths(h);
    }

    /**
     *
     * @param <E>
     */
    static class  Tree<E>{
        E value;
        Tree<E> left;
        Tree<E> right;
        Tree(E value){
            this.value = value;
        }
    }
}
