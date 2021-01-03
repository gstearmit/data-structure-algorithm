package ir.sk.algorithm.treeandgraph;

import ir.sk.helper.SpaceComplexity;
import ir.sk.helper.TimeComplexity;

import java.util.List;

/**
 * Created by sad.kayvanfar on 9/15/2020.
 */
public class TreeGraphAlgorithms {

    /**
     * @param array
     * @return
     */
    public static TreeNode createMinimalBSTByOrderedArray(int array[]) {
        return createMinimalBSTByOrderedArray(array, 0, array.length - 1);
    }

    /**
     * Tree: Given a sorted (increasing order) array with unique integer elements, write an
     * algorithm to create a binary search tree with minimal height.
     * <p>
     * The algorithm is as follows:
     * 1. Insert into the tree the middle element of the array.
     * 2. Insert (into the left subtree) the left subarray elements.
     * 3. Insert (into the right subtree) the right subarray elements.
     * 4. Recurse.
     *
     * @param arr
     * @param start
     * @param end
     * @return
     */
    private static TreeNode createMinimalBSTByOrderedArray(int arr[], int start, int end) {
        if (end < start) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode n = new TreeNode(arr[mid]);
        n.left = createMinimalBSTByOrderedArray(arr, start, mid - 1);
        n.right = createMinimalBSTByOrderedArray(arr, mid + 1, end);
        return n;
    }

    /**
     * We've used an Integer instead of int so that we can know when last_printed has been set to a value.
     * If you don't like the use of static variables, then you can tweak this code to use a wrapper class for the
     * integer, as shown below.
     * class Wraplnt {
     * public int value;
     * }
     */
    private static Integer lastPrinted = null;

    /*
     * Implement a function to check if a binary tree is a valid binary search tree.
     * */

    /**
     * Implement a function to check if a binary tree is a valid binary search tree.
     * In-Order Traversal
     *
     * @param n
     * @return
     */
    @TimeComplexity("O(n)")
    @SpaceComplexity("O(n)")
    public static boolean checkValidBSTByInorder(TreeNode n) {
        if (n == null) return true;

        // II Check I recurse left
        if (!checkValidBSTByInorder(n.left)) return false;

        // II Check current
        if (lastPrinted != null && n.value <= lastPrinted) {
            return false;
        }
        lastPrinted = n.value;

        // Check I recurse right
        if (!checkValidBSTByInorder(n.right)) return false;

        return true;
    }

    /**
     * @param n
     * @param low  bound
     * @param high bound
     * @return
     */
    @TimeComplexity("O(n)")
    @SpaceComplexity("O(n)")
    public static boolean checkValidBSTByBoundaries(TreeNode n, int low, int high) {
        if (n == null) return true;

        int value = n.value;
        if (value >= low && value <= high
                && checkValidBSTByBoundaries(n.left, low, value)
                && checkValidBSTByBoundaries(n.right, value, high))
            return true;
        else
            return false;
    }

    /**
     * Given a binary tree and a number ‘S’,
     * find if the tree has a path from root-to-leaf such that the sum of all the node values of that path equals ‘S’.
     * <p>
     * VLR
     *
     * @param node
     * @param value
     * @param sum
     * @return
     */
    @TimeComplexity("O(n)")
    @SpaceComplexity("O(n)")
    public static boolean hasPathByDFS(TreeNode node, int value, int sum) {
        if (node == null)
            return false;
        if (node.left == null && node.right == null)
            if (node.value + sum == value)
                return true;
            else
                return false;
        else {
            int val = node.value + sum;
            return hasPathByDFS(node.left, value, val) || hasPathByDFS(node.right, value, val);
        }
    }

    /**
     * Given a binary tree and a number ‘S’,
     * find if the tree has a path from root-to-leaf such that the sum of all the node values of that path equals ‘S’.
     *
     * @param node
     * @param value
     * @param sum
     * @return
     */
    @TimeComplexity("O(n)")
    @SpaceComplexity("O(n)")
    public static void allPathByDFS(TreeNode node, int value, int sum, List<Integer> currentPath, List<List<Integer>> allPaths) {
        if (node == null)
            return;
        if (node.left == null && node.right == null)
            if (node.value + sum == value) {
                currentPath.add(node.value);
                allPaths.add(currentPath);
            } else
                return;
        else {
            int val = node.value + sum;
            allPathByDFS(node.left, value, val, currentPath, allPaths);
            allPathByDFS(node.right, value, val, currentPath, allPaths);
        }
    }

}
