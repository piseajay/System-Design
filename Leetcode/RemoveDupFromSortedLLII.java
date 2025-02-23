package Leetcode;

import java.util.HashMap;
import java.util.Map;

public class RemoveDupFromSortedLLII {

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        System.out.println(deleteDuplicates(new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3)))))));
    }

    public static ListNode deleteDuplicates(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        Map<Integer, Integer> numCountMap = new HashMap<>();
        ListNode temp = head;

        while (temp != null) {
            numCountMap.put(temp.val, numCountMap.getOrDefault(temp.val, 0) + 1);
            temp = temp.next;
        }

        temp = head;
        ListNode prev = new ListNode(-1);
        ListNode result = prev;

        while (temp != null) {
            if (numCountMap.get(temp.val) == 1) {
                prev.next = new ListNode(temp.val, null);
                prev = prev.next;
            }
            temp = temp.next;
        }
        return result.next;
    }
}
