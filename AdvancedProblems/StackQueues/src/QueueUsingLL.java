/**
 * Time Complexity: O(1)
 * Space Complexity: O(N)
 */
class QueueLL {
    private Node head;
    private Node tail;
    private int size;

    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public QueueLL() {
        head = null;
        tail = null;
        size = 0;
    }

    public void enqueue(int x) {
        Node newNode = new Node(x);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        int data = head.data;
        head = head.next;
        if (head == null) { // If queue becomes empty after dequeue
            tail = null;
        }
        size--;
        return data;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
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

public class QueueUsingLL {
    static void main(String[] args) {

        QueueLL queue = new QueueLL();

        // Enqueue elements
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        // Peek front element
        System.out.println("Front element: " + queue.peek()); // 10

        // Dequeue elements
        System.out.println("Dequeued: " + queue.dequeue()); // 10
        System.out.println("Dequeued: " + queue.dequeue()); // 20

        // Queue size
        System.out.println("Current size: " + queue.size()); // 1

        // Check if queue is empty
        System.out.println("Is queue empty? " + queue.isEmpty()); // false

        // Dequeue last element
        System.out.println("Dequeued: " + queue.dequeue()); // 30

        // Queue empty now
        System.out.println("Is queue empty? " + queue.isEmpty()); // true

        // Try dequeue from empty queue
        System.out.println("Dequeued: " + queue.dequeue()); // -1
    }
}
