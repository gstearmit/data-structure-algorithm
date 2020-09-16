package ir.sk.algorithm.linklist;

import ir.sk.datastructure.fundamental.linklist.SinglyLink;
import ir.sk.helper.MultiplePointerPattern;
import ir.sk.helper.SpaceComplexity;
import ir.sk.helper.TimeComplexity;

import java.util.HashSet;

/**
 * Created by sad.kayvanfar on 9/1/2020.
 */
public class LinkListAlgorithms {

    /**
     * iterate with two pointers: current which iterates through the linked list,
     * and runner which checks all subsequent nodes for duplicates.
     * <p>
     * Using Runner Technique
     *
     * @param head
     */
    @TimeComplexity("O(n^2)")
    @SpaceComplexity("O(1)")
    @MultiplePointerPattern
    public static void deleteDuplicatesByRunner(SinglyLink head) {
        SinglyLink current = head;
        while (current != null) {
            SinglyLink runner = head;
            while (runner.next != null) {
                if (current.data.equals(runner.next.data)) {
                    runner.next = runner.next.next;
                } else
                    runner = runner.next;
            }
            current = current.next;
        }
    }

    /**
     * iterate through the linked list, adding each element to a hash table. When
     * we discover a duplicate element, we remove the element and continue iterating.
     *
     * @param head
     */
    @TimeComplexity("O(n)")
    @SpaceComplexity("O(n)")
    public static void deleteDuplicatesByHashing(SinglyLink<Integer> head) {
        HashSet<Integer> hashTable = new HashSet<>();
        SinglyLink<Integer> previous = null;

        while (head != null) {
            if (hashTable.contains(head.data))
                previous.next = head.next;
            else {
                hashTable.add(head.data);
                previous = head;
            }
            head = head.next;
        }
    }

    /**
     * wrap the counter value with simple class
     */
    static class Index {
        public int value = 0;
    }

    /**
     * @param head
     * @param k
     * @return
     */
    public static SinglyLink<Integer> kthToLastRecursive(SinglyLink<Integer> head, int k) {
        Index idx = new Index();
        return kthToLastRecursive(head, k, idx);
    }

    /**
     * This algorithm recurses through the linked list. When it hits the end, the method passes back a counter set
     * to 0. Each parent call adds 1 to this counter. When the counter equals k, we know we have reached the kth
     * to last element of the linked list.
     *
     * @param head
     * @param k
     * @param idx
     * @return
     */
    @TimeComplexity("O(n)")
    @SpaceComplexity("O(n)")
    private static SinglyLink<Integer> kthToLastRecursive(SinglyLink<Integer> head, int k, Index idx) {
        if (head == null)
            return null;

        SinglyLink<Integer> node = kthToLastRecursive(head.next, k, idx);
        idx.value = idx.value + 1;
        if (idx.value == k)
            return head;

        return node;
    }

    /**
     * use two pointers,
     * pl and p2. We place them k nodes apart in the linked list by putting p2 at the beginning and moving pl
     * k nodes into the list. Then, when we move them at the same pace, pl will hit the end of the linked list after
     * LENGTH - k steps. At that point, p2 will be LENGTH - k nodes into the list, or k nodes from the end.
     *
     * @param head
     * @param k
     * @return
     */
    @TimeComplexity("O(n)")
    @SpaceComplexity("O(1)")
    @MultiplePointerPattern
    private static SinglyLink<Integer> nthToLastByRunner(SinglyLink<Integer> head, int k) {
        SinglyLink<Integer> pl = head;
        SinglyLink<Integer> p2 = head;

        /* Move pl k nodes into the list.*/
        for (int i = 0; i < k; i++) {
            if (pl == null)
                return null; // Out of bounds
            pl = pl.next;
        }

        /* Move them at the same pace. When pl hits the end, p2 will be at the right 12 * element. */
        while (pl != null) {
            pl = pl.next;
            p2 = p2.next;
        }
        return p2;
    }

    /**
     * delete a node in the middle (i.e., any node but
     * the first and last node, not necessarily the exact middle) of a singly linked list, given only access to
     * that node.
     * <p>
     * You only have access to that node.
     * The solution is simply to copy the data from the next node over to the current node, and then to delete the
     * next node.
     *
     * @param n
     * @return
     */
    private static boolean deleteNode(SinglyLink<Integer> n) {
        if (n == null || n.next == null)
            return false; // Failure

        SinglyLink<Integer> next = n.next;
        n.data = next.data;
        n.next = next.next;
        return true;
    }

    /**
     * You have two numbers represented by a linked list, where each node contains a single
     * digit. The digits are stored in reverse order, such that the 1 's digit is at the head of the list. this
     * function adds the two numbers and returns the sum as a linked list.
     */
    @TimeComplexity("O(m+n)")
    @SpaceComplexity("O(m+n)")
    public static SinglyLink<Integer> sumRevertedLists(SinglyLink<Integer> list1, SinglyLink<Integer> list2, int carry) {
        if (list1 == null && list2 == null && carry == 0)
            return null;

        SinglyLink<Integer> result = new SinglyLink<>();

        int value = carry;
        if (list1 != null)
            value += list1.data;

        if (list2 != null)
            value += list1.data;

        result.data = value % 10; /* Second digit of number */

        if (list1 != null || list2 != null) {
            SinglyLink<Integer> more = sumRevertedLists(list1 == null ? null : list1.next,
                    list2 == null ? null : list2.next,
                    value >= 10 ? 1 : 0);
            result.next = more;
        }
        return result;
    }

    /**
     * first solution is to reverse the linked list and compare the reversed list to the original list. If they're the
     * same, the lists are identical.
     *
     * when we compare the linked list to the reversed list, we only actually need to compare the first
     * half of the list. If the first half of the normal list matches the first half of the reversed list, then the second half
     * of the normal list must match the second half of the reversed list.
     *
     * @param head
     * @return
     */
    public static boolean isPalindrome(SinglyLink head) {
        SinglyLink reversed = reverseAndClone(head);
        return isEqual(head, reversed);
    }

    /**
     * @param node
     * @return
     */
    public static SinglyLink reverseAndClone(SinglyLink node) {
        SinglyLink head = null;
        while (node != null) {
            SinglyLink n = new SinglyLink(node.data); // Clone
            n.next = head;
            head = n;
            node = node.next;
        }
        return head;
    }

    private static boolean isEqual(SinglyLink one, SinglyLink two) {
        while (one != null && two != null) {
            if (one.data != two.data)
                return false;

            one = one.next;
            two = two.next;
        }
        return one == null && two == null;
    }
}
