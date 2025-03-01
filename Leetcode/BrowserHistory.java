package Leetcode;

public class BrowserHistory {

    public static void main(String[] args) {
        BrowserHistory browserHistory = new BrowserHistory("leetcode.com");
        browserHistory.visit("google.com");
        browserHistory.visit("facebook.com");
        browserHistory.visit("youtube.com");
        System.out.println(browserHistory.back(1));
        System.out.println(browserHistory.back(1));
        System.out.println(browserHistory.forward(1));
        browserHistory.visit("linkedin.com");
        System.out.println(browserHistory.forward(2));
        System.out.println(browserHistory.back(2));
        System.out.println(browserHistory.back(7));
    }

    private Node head;
    private Node current;

    public BrowserHistory(String homepage) {
        Node node = new Node(homepage);
        this.head = node;
        current = head;
    }

    public void visit(String url) {
        Node node = new Node(url);
        current.next = node;
        node.prev = current;
        current = node;
    }

    public String back(int steps) {
        while (steps > 0 && current.prev != null) {
            current = current.prev;
            steps--;
        }
        return current.url;
    }

    public String forward(int steps) {
        while (steps > 0 && current.next != null) {
            current = current.next;
            steps--;
        }
        return current.url;
    }

    static class Node {
        public String url;
        public Node prev;
        public Node next;

        public Node(String val) {
            this.url = val;
        }
    }
}