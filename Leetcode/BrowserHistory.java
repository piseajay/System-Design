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

    private final String[] history;
    private int currentIndex;
    private int lastVisitedIndex;

    public BrowserHistory(String homepage) {
        history = new String[100];
        history[0] = homepage;
        currentIndex = 0;
        lastVisitedIndex = 0;
    }

    public void visit(String url) {
        currentIndex++;
        history[currentIndex] = url;
        lastVisitedIndex = currentIndex;
    }

    public String back(int steps) {
        int backIndex = Math.max(0, currentIndex - steps);
        currentIndex = backIndex;
        return history[backIndex];
    }

    public String forward(int steps) {
        int forwardIndex = Math.min(lastVisitedIndex, currentIndex + steps);
        currentIndex = forwardIndex;
        return history[forwardIndex];
    }
}
