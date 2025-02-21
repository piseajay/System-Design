package Leetcode;

import java.util.HashSet;

public class LinkedListCycle {

    class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static boolean hasCycle(ListNode head) {

        if (head == null || head.next == null) {
            return false;
        }

        HashSet<ListNode> visitedNodes = new HashSet<>();
        ListNode temp = head;

        while (temp.next != null) {
            if (visitedNodes.contains(temp)) {
                return true;
            }
            visitedNodes.add(temp);
            temp = temp.next;
        }
        return false;
    }
}
