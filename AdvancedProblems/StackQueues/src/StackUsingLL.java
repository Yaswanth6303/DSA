/**
 * Time Complexity: O(1)
 * Space Complexity: O(n)
 */
class StackLL {
    private Node head;
    private int size;

    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public StackLL() {
        head = null;
        size = 0;
    }

    public void push(int x) {
        Node newNode = new Node(x);
        newNode.next = head;
        head = newNode;
        size++;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        int data = head.data;
        head = head.next;
        size--;
        return data;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        return head.data;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        return size;
    }
}

public class StackUsingLL {
    static void main(String[] args) {

        StackLL stack = new StackLL();

        // Push elements
        stack.push(10);
        stack.push(20);
        stack.push(30);

        // Peek top element
        System.out.println("Top element: " + stack.peek()); // 30

        // Pop elements
        System.out.println("Popped: " + stack.pop()); // 30
        System.out.println("Popped: " + stack.pop()); // 20

        // Stack size
        System.out.println("Current size: " + stack.size()); // 1

        // Check if empty
        System.out.println("Is stack empty? " + stack.isEmpty()); // false

        // Pop last element
        System.out.println("Popped: " + stack.pop()); // 10

        // Stack empty now
        System.out.println("Is stack empty? " + stack.isEmpty()); // true

        // Try popping from empty stack
        System.out.println("Popped: " + stack.pop()); // -1
    }
}
