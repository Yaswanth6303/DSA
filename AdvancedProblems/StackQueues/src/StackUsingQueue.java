import java.util.LinkedList;
import java.util.Queue;

class StackQueue {
    Queue<Integer> q;

    public StackQueue() {
        q = new LinkedList<>();
    }

    public void push(int x) {
        q.add(x);
        for (int i = 0; i < q.size() - 1; i++) {
            q.add(q.remove());
        }
    }

    public int pop() {
        if (q.isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        return q.remove();
    }

    public int top() {
        if (q.isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        return q.peek();
    }

    public boolean empty() {
        return q.isEmpty();
    }
}

public class StackUsingQueue {
    public static void main(String[] args) {

        StackQueue stack = new StackQueue();

        // Push elements
        stack.push(10);
        stack.push(20);
        stack.push(30);

        // Top element
        System.out.println("Top element: " + stack.top()); // 30

        // Pop elements
        System.out.println("Popped: " + stack.pop()); // 30
        System.out.println("Popped: " + stack.pop()); // 20

        // Check top again
        System.out.println("Top element: " + stack.top()); // 10

        // Check if stack is empty
        System.out.println("Is stack empty? " + stack.empty()); // false

        // Pop last element
        System.out.println("Popped: " + stack.pop()); // 10

        // Check empty
        System.out.println("Is stack empty? " + stack.empty()); // true
    }
}
