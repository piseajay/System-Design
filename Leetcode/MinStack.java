import java.util.Stack;

public class MinStack {

    public Stack<Integer> stac;
    public Stack<Integer> minStac;

    public MinStack() {
        stac = new Stack<>();
        minStac = new Stack<>();
    }

    public void push(int val) {
        stac.push(val);
        if (minStac.isEmpty() || val <= minStac.peek()) {
            minStac.push(val);
        }
    }

    public void pop() {
        int a = minStac.peek();
        if (stac.pop() == a) {
            minStac.pop();
        }
    }

    public int top() {
        return stac.peek();
    }

    public int getMin() {
        return minStac.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin()); // return -3
        minStack.pop();
        System.out.println(minStack.top());    // return 0
        System.out.println(minStack.getMin()); // return -2
    }
}
