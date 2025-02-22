package Leetcode;

public class ReverseLinkedList {

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

        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));

        reverseList(head);
    }

    public static ListNode reverseList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode prev = null;
        ListNode reversed;
        ListNode currentNode = head;
        int counter = 1;

        while (currentNode.next != null) {

            if (counter == 1) {
                prev = new ListNode(head.val, null);
                currentNode = currentNode.next;
                counter++;
                continue;
            }

            reversed = new ListNode(currentNode.val, prev);
            currentNode = currentNode.next;
            prev = reversed;
            counter++;
        }

        reversed = new ListNode(currentNode.val, prev);

        return reversed;
    }
}
