package io.konv.leetcode;

/**
 * 24. Swap Nodes in Pairs
 */
public class SwapNodesInPairs {

    /**
     * Given a linked list, swap every two adjacent nodes and return its head.
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode first = head.next;
        ListNode second = head;
        ListNode third = swapPairs(head.next.next);

        first.next = second;
        second.next = third;
        return first;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
