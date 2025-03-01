package Leetcode;

import java.util.Arrays;

public class DoublyLinkedListToArray {

    public static void main(String[] args) {

        System.out.println(Arrays.toString(toArray(new Node(1, null, new Node(2, null, new Node(3, null, null))))));
    }

    public static int[] toArray(Node head) {
        
        int size = 1;
        Node temp = head;
        while (temp != null) {
            size++;
            temp = temp.next;
        }

        int[] result = new int[size - 1];
        int counter = 0;
        temp = head;
        while (temp != null) {
            result[counter++] = temp.val;
            temp = temp.next;
        }
        return result;
    }

    static class Node {
        public int val;
        public Node prev;
        public Node next;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node prev, Node next) {
            this.val = val;
            this.prev = prev;
            this.next = next;
        }
    }
}
