package implementation.arrays;

import java.util.Arrays;
import java.util.List;

class Stack {
    private final int[] stackArray;
    private final int capacity;
    private int top;

    // Constructor with custom size
    public Stack(int capacity) {
        this.capacity = capacity;
        stackArray = new int[capacity];
        top = -1;
    }

    // Default constructor
    public Stack() {
        this(1000);
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void push(int x) {
        if (top + 1 < capacity) {
            stackArray[++top] = x;
        } else {
            System.out.println("Stack overflow");
        }
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        return stackArray[top--];
    }

    public int top() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        return stackArray[top];
    }

    public int size() {
        return top + 1;
    }
}

public class StackImplementation {

    public static void main(String[] args) {

        Stack stack = new Stack();

        List<String> commands = Arrays.asList(
                "Stack", "push", "push", "top", "pop", "isEmpty"
        );

        List<List<Integer>> inputs = Arrays.asList(
                Arrays.asList(),
                Arrays.asList(5),
                Arrays.asList(10),
                Arrays.asList(),
                Arrays.asList(),
                Arrays.asList()
        );

        for (int i = 0; i < commands.size(); i++) {
            switch (commands.get(i)) {

                case "Stack":
                    System.out.print("null ");
                    break;

                case "push":
                    stack.push(inputs.get(i).get(0));
                    System.out.print("null ");
                    break;

                case "pop":
                    System.out.print(stack.pop() + " ");
                    break;

                case "top":
                    System.out.print(stack.top() + " ");
                    break;

                case "isEmpty":
                    System.out.print(stack.isEmpty() + " ");
                    break;
            }
        }
    }
}
