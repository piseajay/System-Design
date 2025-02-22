package Leetcode;

public class RemoveNthNodeFromEnd {

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(1, new ListNode(1));

        removeNthFromEnd(head, 2);
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {

        if (head.next == null) {
            return null;
        }

        ListNode temp = head;
        int size = 1;
        while (temp.next != null) {
            temp = temp.next;
            size++;
        }

        if (size == n) {
            return head.next;
        }

        int goTillIndex = size - n;
        temp = head;
        int start = 1;
        while (start < goTillIndex) {
            temp = temp.next;
            start++;
        }
        temp.next = temp.next.next;
        return head;
    }
}
