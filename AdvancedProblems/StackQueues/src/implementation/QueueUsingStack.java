package implementation;

import java.util.Stack;

/**
 * Time Complexity: O(N)
 * Space Complexity: O(2N)
 */
class QueueStackBrute {
    Stack<Integer> s1;
    Stack<Integer> s2;

    public QueueStackBrute() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public void push(int x) {
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        s1.push(x);
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
    }

    public int pop() {
        if (s1.isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        return s1.pop();
    }

    public int peek() {
        if (s1.isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        return s1.peek();
    }

    public boolean empty() {
        return s1.isEmpty();
    }
}

/**
 * Time Complexity: O(1)
 * Space Complexity: O(N)
 */
class QueueStackOptimal {
    Stack<Integer> s1;
    Stack<Integer> s2;

    public QueueStackOptimal() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public void push(int x) {
        s1.push(x);
    }

    public int pop() {
        if (s1.isEmpty() && s2.isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        return s2.pop();
    }

    public int peek() {
        if (s1.isEmpty() && s2.isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }

        return s2.peek();
    }
}

public class QueueUsingStack {
    static void main(String[] args) {

        // ------------------ Brute Force Queue ------------------
        System.out.println("=== Queue using Stack (Brute Force) ===");

        QueueStackBrute bruteQueue = new QueueStackBrute();

        bruteQueue.push(10);
        bruteQueue.push(20);
        bruteQueue.push(30);

        System.out.println("Peek: " + bruteQueue.peek()); // 10
        System.out.println("Pop: " + bruteQueue.pop());   // 10
        System.out.println("Pop: " + bruteQueue.pop());   // 20
        System.out.println("Empty? " + bruteQueue.empty()); // false
        System.out.println("Pop: " + bruteQueue.pop());   // 30
        System.out.println("Empty? " + bruteQueue.empty()); // true

        // ------------------ Optimal Queue ------------------
        System.out.println("\n=== Queue using Stack (Optimal) ===");

        QueueStackOptimal optimalQueue = new QueueStackOptimal();

        optimalQueue.push(100);
        optimalQueue.push(200);
        optimalQueue.push(300);

        System.out.println("Peek: " + optimalQueue.peek()); // 100
        System.out.println("Pop: " + optimalQueue.pop());   // 100
        System.out.println("Pop: " + optimalQueue.pop());   // 200
        System.out.println("Pop: " + optimalQueue.pop());   // 300
        System.out.println("Pop (empty): " + optimalQueue.pop()); // -1
    }
}

