package Leetcode;

public class MyLinkedList {

    class Node {

        private int data;
        private Node next;

        public Node(int value) {
            this.data = value;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public MyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /**
     * Get the data of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        if (index >= size) {
            return -1;
        }
        Node node = head;
        while (index > 0) {
            node = node.next;
            index--;
        }
        return node.data;
    }

    /**
     * Add a node of data val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        Node node = new Node(val);
        node.next = head;
        head = node;
        if (null == tail) {
            tail = head;
        }
        size++;
    }

    /**
     * Append a node of data val to the last element of the linked list.
     */
    public void addAtTail(int val) {

        if (head == null) {
            addAtHead(val);
            return;
        }

        tail.next = new Node(val);
        tail = tail.next;
        size++;
    }

    /**
     * Add a node of data val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {

        if (index > size) {
            return;
        }
        if (index == 0) {
            addAtHead(val);
            return;
        }
        if (index == size) {
            addAtTail(val);
            return;
        }
        Node node = head;
        Node newNode = new Node(val);
        while (null != node && index > 1) {
            node = node.next;
            index--;
        }
        newNode.next = node.next;
        node.next = newNode;
        size++;
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {

        if (index >= size) {
            return;
        }
        if (index == 0) {
            deleteAtHead();
            return;
        }
        Node node = head;
        while (null != node && index > 1) {
            node = node.next;
            index--;
        }

        node.next = node.next.next;
        if (node.next == null) {
            tail = node;
        }
        size--;
    }

    public void deleteAtHead() {
        head = head.next;
        size--;
    }
}