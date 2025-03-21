package Leetcode;

public class PartitionList {

    public static void main(String[] args) {
        System.out.println(partition(new ListNode(1, new ListNode(4, new ListNode(3, new ListNode(2, new ListNode(5, new ListNode(2)))))), 3));
    }

    public static ListNode partition(ListNode head, int x) {

        ListNode dummy1 = new ListNode(0);
        ListNode dummy2 = new ListNode(0);
        ListNode current1 = dummy1;
        ListNode current2 = dummy2;

        while (head != null) {
            if (head.val < x) {
                current1.next = head;
                current1 = current1.next;
            } else {
                current2.next = head;
                current2 = current2.next;
            }
            head = head.next;
        }

        current2.next = null;
        current1.next = dummy2.next;

        return dummy1.next;
    }
}
