package bhuvan.dsa.java.dataStructures;

import java.util.*;
import java.util.ArrayList;

import bhuvan.dsa.java.dataStructures.CustomLinkedList;
import com.sun.org.apache.xpath.internal.operations.Bool;

/**
 * Created by bhuvan on 27/12/14.
 */
public class TreeDS {
    public static AugmentedTree getNewAugmentedTree (){
        AugmentedTree root = new AugmentedTree(5);
        root.countLeft = 0;
        insertIntoAugmentedTree(root, 3);
        insertIntoAugmentedTree(root, 8);
        insertIntoAugmentedTree(root, 1);
        insertIntoAugmentedTree(root, 4);
        insertIntoAugmentedTree(root, 6);
        insertIntoAugmentedTree(root, 9);
        return root;
    }
    public static void insertIntoAugmentedTree(AugmentedTree<Integer> root, int value) {
        if (value < root.value && root.left != null){
            insertIntoAugmentedTree(root.left, value);
        } else if (value <root.value && root.left == null) {
            AugmentedTree newNode = new AugmentedTree(value);
            root.left = newNode;
        } else  if (value > root.value && root.right != null){
            insertIntoAugmentedTree(root.right, value);
        } else if (value > root.value && root.right == null) {
            AugmentedTree newNode = new AugmentedTree(value);
            root.right = newNode;
        }

    }
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
     * PseudoCode for MaxWidth
     * start with list containing just the trees root. call it CurrNodes.
     * maxWidth = 1;
     * start with empty list. call it NextNodes.
     * while(CurrNodes is not empty) {
     *      get all children of nodes in CurrNodes and add them to NextNodes
     *      if number of children is > maxWidth, # of children is the new maxWidth
     *          CurrNodes = NextNodes
     *          NextNodes = empty.
     * }
     * http://www.geeksforgeeks.org/maximum-width-of-a-binary-tree/
     * @param root
     */
    public static int maxWidthBinaryTree(Tree root){
        // do a level order traversal and at each level update the count
        // of that level save the count into max if its greater than previous max
        Queue<Tree> queue = new LinkedList();
        queue.add(root);
        Queue<Tree> nextQueue = new LinkedList();
        int maxWidth = 1 ;
        while(!queue.isEmpty() && nextQueue.isEmpty()){
            Tree temp = queue.remove();
            if (temp.left != null)
                nextQueue.add(temp.left);
            if (temp.right != null)
                nextQueue.add(temp.right);
            if (queue.isEmpty()){
                if (maxWidth < nextQueue.size())
                    maxWidth = nextQueue.size();
                queue = nextQueue;
            }
        }
        return maxWidth;
    }

    /**
     *
     * @param root
     */
    public static void modifiedLevelOrderTraversal(Tree root){
        Queue<Tree> queue = new LinkedList();
        queue.add(root);
        int level = 0;
        Queue<Tree> nextQueue = new LinkedList();
        while (!queue.isEmpty() && !nextQueue.isEmpty()){
            Tree temp = queue.remove();
            System.out.println("Level: "+level+" Node: "+temp.value);
            if (temp.left != null)
                nextQueue.add(temp.left);
            if (temp.right != null)
                nextQueue.add(temp.right);
            if (queue.isEmpty()){
                queue = nextQueue;
                level++;
            }
        }
    }
    /**
     * http://www.geeksforgeeks.org/g-fact-18/
     * @param n
     * Catalan number
     */
    public static int totalNoOfBSTWithNNodes(int n){
        return 0;
    }

    /**
     * http://www.geeksforgeeks.org/foldable-binary-trees/
     * One approach is to create mirror of a tree and check
     * if its same as the given tree.
     * Another approach could be to traverse it recursively.
     * @param root
     * @return
     */
    public static boolean isFoldableBST(Tree root){
        if (root.left == null && root.right == null) {
            return true;
        }else if (root.left != null && root.right == null){
            return false;
        } else if (root.right != null && root.left == null){
            return false;
        } else {
            return isFoldableBST(root.left, root.right);
        }
    }

    /**
     * Working method for isFoldableBST(root);
     * after the children are passed
     * @param left
     * @param right
     * @return
     */
    public static boolean isFoldableBST(Tree left, Tree right){
        if (left.left == null && left.right == null &&
                right.left == null && right.right == null){
            return true;
        }
        if (left.left == null && right.right == null){
            return isFoldableBST(left.right,right.left);
        } else if (left.right == null && right.left == null) {
            return isFoldableBST(left.left, right.right);
        } else if (left.left != null && left.right != null &&
                right.left != null && right.right != null){
            return isFoldableBST(left.right,right.left)
                    & isFoldableBST(left.left, right.right);
        } else  {
            return false;
        }
    }
    /**
     * Why Trees?
     * http://www.geeksforgeeks.org/applications-of-tree-data-structure/
     */


    /**
     * http://www.geeksforgeeks.org/inorder-successor-in-binary-search-tree/
     *
     * inOrder successor is the next element in the inOrder sequence of the tree.
     * Since its greater than the node it has to be present on the right subtree.
     * we need to go to the right sub tree and return the leftmost child of the right node
     *
     * @param node
     * @return
     */
    public static Tree inOrderSuccessor(Tree node){
        if (node.right == null)
            return null;
        else {
            node = node.right;
            while(node.left != null){
                node = node.left;
            }
            return node;
        }
    }

    /**
     * http://www.geeksforgeeks.org/find-k-th-smallest-element-in-bst-order-statistics-in-bst/
     * This can be done by doing an inorder traversal and finding the kth element in it
     * A more elegant solution would be to use Augmented tree
     * todo create and use augmented tree class for this method
     * @param root
     * @return
     */
    public static AugmentedTree getKthNodeInABSTSorted(AugmentedTree root){
        if (root == null) {
            return null;
        }
        // todo
        return null;
    }
    /**
     * Do a inOrder on the arrayList input
     * @param arrayList
     */
    public static void printSortedTree(List<Integer> arrayList){

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
     * Dummy Method for checkIfBST(Tree, int, int)
     * @param root
     * @return
     */
    public static boolean checkIfBST(Tree<Integer> root){
        return checkIfBST(root, Integer.MIN_VALUE,Integer.MAX_VALUE);
    }

    /**
     * Checks if a given Tree is a Binary search tree
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
     * Print Ancestors of a given node in Binary Tree
     * Given a Binary Tree and a key, write a function that prints all the ancestors of the key in the given binary tree.
     * @param root
     */
    public static boolean printAncestorsNode(Tree<Integer> root, int target){
        if (root == null){
            return false;
        }
        if (root.value == target) {
            return true;
        }
        if (printAncestorsNode(root.left,target) || printAncestorsNode(root.right,target)) {
            System.out.println(root.value);
            return true;
        }
        return false;
    }
    public static void printTreeVerticalOrder(Tree node){
        CustomLinkedList.DoublyLL<List> newList = new CustomLinkedList.DoublyLL<List>();
        newList.data = new LinkedList();
        printTreeVerticalOrder(node,newList);
        CustomLinkedList.DoublyLL temp = newList;
        while (temp.previous != null){
            temp = temp.previous;
        }
        while (temp.next != null){
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
    /**
     * Print Tree Vertical Order
     * @param node
     * @param inputList
     */
    public static void printTreeVerticalOrder(Tree node, CustomLinkedList.DoublyLL<List> inputList){
          if(node.left !=null){
              if (inputList.previous!=null){
                  inputList.data.add(node.left);
              } else {
                  inputList.previous = new CustomLinkedList.DoublyLL<List>();
                  inputList.previous.next = inputList;
                  inputList.previous.data = new LinkedList();
                  inputList.previous.data.add(node.left);
                  
              }
              printTreeVerticalOrder(node.left,inputList.previous);
          }
          if(node.right!=null){
              if (inputList.next != null){
                  inputList.data.add(node.right);
              } else {
                  inputList.next = new CustomLinkedList.DoublyLL<List>();
                  inputList.next.data = new LinkedList();
                  inputList.next.previous = inputList;
                  inputList.next.data.add(node.right);
              }
              printTreeVerticalOrder(node.right,inputList.next);
          }
    }

    /**
     * 
     * @param node
     * @param k
     */
    public static void printNodesDistanceKromLeafNode (Tree node, int k){
        // Create an array with all the indices
        Queue<Tree> queue = new LinkedList<Tree>();
        queue.add(node);
        int index =0;
        List<Tree> arrayList = new ArrayList<Tree>();
        List<Boolean> auxarray = new ArrayList<Boolean>();
        while (!queue.isEmpty()){
            Tree temp = queue.remove();
            arrayList.add(index, temp);
            auxarray.add(index, false);
            index++;
            if (temp.left == null && temp.right == null){
                // leaf node found print the parent at distance k
                // from the array that we have created
                int t = k;
                int tempIndex = index;
                while (t >=0) {
                    t--;
                    tempIndex = tempIndex/2;
                }
                if (auxarray.get(tempIndex) == false) {
                    System.out.println(arrayList.get(tempIndex));
                    auxarray.set(index, true);
                }
            }
            if (temp.left != null){
                queue.add(temp.left);                
            }
            if (temp.right != null){
                queue.add(temp.right);
            }
        }
        
    }

    /**
     * Given 2 nodes and a tree root, find the shortest path in the tree
     * from key1 to key2
     * @param root
     * @param key1
     * @param key2
     */
    public static void findDistanceBetweenTwoKeys(Tree root, int key1, int key2){
        List l1,l2;
        l1 = new LinkedList();
        l2 = new LinkedList();
        l1 = rootToLeafPath(root, key1,l1);
        l2 = rootToLeafPath(root, key2,l2);
        int size;
        int length=0;
        if (l1.size()>l2.size()){
            while (l1.size()>l2.size()) {
                l1.remove(l1.size() - 1);
                length++;
            }
        } else if (l1.size() < l2.size()) {
            while (l1.size() <l2.size()) {
                l2.remove(l2.size() - 1);
                length++;
            }
        }
        size = l2.size();
        while (l1.get(size)!=l2.get(size)){
            length++;            
        }
        System.out.println(length);
    }

    /**
     * Given a tree root and a value k find the root to leaf path for
     * that key and insert the path into the given linked list
     * @param root
     * @param key
     * @param linkedList
     * @return
     */
    public static List rootToLeafPath(Tree<Integer> root, int key, List linkedList){
        List<Tree> ll = new LinkedList<Tree>(linkedList);
        if (root==null){
            return null;            
        }
        if (root.left == null && root.right == null) {
            if (root.value == key)
                return ll;
            else 
                return null;
        }
        if (root.left != null){
            ll.add(root.left);
            rootToLeafPath(root.left,key,ll);
        }
        if (root.right != null){
            ll.add(root.right);
            rootToLeafPath(root.right,key,ll);
        }
        return null;
    }
    /**
     *
     * @param root
     */
    public static void printLeftView(Tree<Integer> root){
        // do a level order traversal and print the first node in each level
    }

    /**
     * Print nodes in a binary tree with no siblings
     * @param root
     */
    public static void printNodesWithNoSiblings(Tree root){
        if (root == null) {
            return;
        }
        else if (root.left != null && root.right == null){
            System.out.println(root.left.value);
            printNodesWithNoSiblings(root.left);
        } else if (root.right != null && root.left == null) {
            System.out.println(root.right.value);
            printNodesWithNoSiblings(root.right);
        } else {
            printNodesWithNoSiblings(root.left);
            printNodesWithNoSiblings(root.right);
        }
    }
    /**
     *
     * @param root
     */
    public static void printRightView(Tree<Integer> root){
        // Do a level order traversal and print the last node in each level
    }

    /**
     * TODO
     * @param root top of of the tree
     */
    public static void printTopView(Tree<Integer> root){
        // similar question that was asked in amazon to me
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
        preOrderTraversalRecursion(root, newList);
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
        postOrderTraversalRecursion(root, newList);
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
    public static Tree printLCABinaryTree (Tree<Integer> root, int n1, int n2){
        if (root == null) {
            return null;
        }
        if (root.value == n1 || root.value == n2) {
            return root;
        }
        if (printLCABinaryTree(root.left, n1,n2) != null && 
        printLCABinaryTree(root.right, n1,n2)!= null) {
            // LCA found
        }
        //todo
        return null;
        
    }
    /**
     *
     * @param root
     * @param left
     * @param right
     */
    public static void printLCABST(Tree<Integer> root, int left, int right){
        if (root == null){
            System.out.println("LCA not found");
        } else if(root.value > left && root.value> right){
            printLCABST(root.left, left, right);
        } else if (root.value< left && root.value < right){
            printLCABST(root.right, left, right);
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

    /**
     * http://www.geeksforgeeks.org/lowest-common-ancestor-binary-tree-set-1/
     * Given a binary tree (not a binary search tree) and two values say n1 and n2,
     * write a program to find the least common ancestor.
     * Following is definition of LCA from Wikipedia:
     * Let T be a rooted tree. The lowest common ancestor between two nodes n1 and n2 is
     * defined as the lowest node in T that has both n1 and n2 as descendants
     * (where we allow a node to be a descendant of itself).
     * @param root
     * @param n1
     * @param n2
     * @return
     */
    public static Tree<Integer> lowestCommonAncestor(Tree<Integer> root, int n1, int n2) {
        if (root == null)
            return null;
        if (root.value == n1 || root.value == n2) {
            return root;
        }
        else {
            Tree left = lowestCommonAncestor(root.left,  n1,  n2);
            Tree right = lowestCommonAncestor(root.right,  n1,  n2);
            if (left != null && right != null) {
                return root;
            } else {
                return (left != null ? lowestCommonAncestor(root.left,n1,n2):
                        lowestCommonAncestor(root.right,n1,n2));
            }
        }
    }

    /**
     * http://www.geeksforgeeks.org/in-place-convert-a-given-binary-tree-to-doubly-linked-list/
     * Given a Binary Tree (Bt), convert it to a Doubly Linked List(DLL).
     * The left and right pointers in nodes are to be used as previous and next pointers respectively
     * in converted DLL. The order of nodes in DLL must be same as Inorder of the given Binary Tree.
     * The first node of Inorder traversal (left most node in BT) must be head node of the DLL.
     * @param root
     */
    public static void convertTreeToDoublyLL(Tree root){
        if (root.left!=null){
            convertTreeToDoublyLL(root.left);
            // find the inorder predecessor and insert root to its end
            Tree temp = root.left;
            while (temp.right != null){
                temp = temp.right;
            }
            root.left=temp;
            temp.right=root;
        }
        if (root.right != null) {
            convertTreeToDoublyLL(root.right);
            // find the inorder successor and insert root to its beginning
            Tree temp = root.right;
            while (temp.left != null){
                temp = temp.left;
            }
            root.right = temp;
            temp.left = root;
        }

    }

    /**
     * http://www.geeksforgeeks.org/find-a-pair-with-given-sum-in-bst/
     * Find a pair with given sum in a Balanced BST
     * Given a Balanced Binary Search Tree and a target sum, 
     * write a function that returns true if there is a pair with 
     * sum equals to target sum, otherwise return false. 
     * Expected time complexity is O(n) and only O(Logn) 
     * extra space can be used. Any modification to Binary Search Tree is not allowed. 
     * Note that height of a Balanced BST is always O(Logn). 
     * @param root
     * @param toFind
     */
    public static void findPairWithGivenSum(Tree<Integer> root, int toFind){
        // Do an inorder traversal & reverse inorder traversal, check for the sum
        // if sum is greater than the required sum, extract next element from inorder
        // keeping reverse inorder as it is else do reverse inorder
        Stack<Tree> s1 = new Stack<Tree>();
        Stack<Tree> s2 = new Stack<Tree>();
        Tree<Integer> inorderNext = root, reverseInorderNext = root;
        int inorderElement, reverseInorderElement;
        boolean isDoneInorder = false, isDoneReverseInorder = false;
        s1.push(root.left);
        s2.push(root.right);
        while (true){
            // Do an inorder traversal
            while (isDoneInorder == false) {
                Tree<Integer> temp = s1.pop();
                while (temp!=null){
                    s1.push(temp.left);
                    temp = temp.left;
                    
                }
                
            }
            // Do a reverse inorder traversal
            
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
    static class AugmentedTree<E>{
        E value;
        // Number of nodes on the left of this node
        int countLeft;
        AugmentedTree<E> left;
        AugmentedTree<E> right;
        AugmentedTree(E value){
            this.value = value;
        }
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
