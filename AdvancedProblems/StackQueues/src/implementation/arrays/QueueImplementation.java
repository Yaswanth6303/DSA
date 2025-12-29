package implementation.arrays;

class Queue {
    private final int[] queueArray;
    private final int capacity;
    private int front;
    private int rear;
    private int currentSize;

    public Queue(int capacity) {
        this.capacity = capacity;
        queueArray = new int[capacity];
        front = 0;
        rear = -1;
        currentSize = 0;
    }

    public Queue() {
        this(1000);
    }

    public boolean isEmpty() {
        return currentSize == 0;
    }

    public boolean isFull() {
        return currentSize == capacity;
    }

    public void enqueue(int x) {
        if (isFull()) {
            System.out.println("Queue is full");
            return;
        }
        rear = (rear + 1) % capacity;
        queueArray[rear] = x;
        currentSize++;
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        int data = queueArray[front];
        front = (front + 1) % capacity;
        currentSize--;
        return data;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        return queueArray[front];
    }

    public int size() {
        return currentSize;
    }
}

public class QueueImplementation {
    static void main(String[] args) {

        Queue queue = new Queue(5);

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println(queue.peek()); // 10
        System.out.println(queue.dequeue());  // 10
        System.out.println(queue.dequeue());  // 20
        System.out.println(queue.isEmpty()); // false
        System.out.println(queue.dequeue());  // 30
        System.out.println(queue.isEmpty()); // true
    }
}
