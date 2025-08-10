package faqMedium;

import fundamentalsSingleLL.Node;

import java.util.HashMap;

public class DetectLoopInLL_5 {
    public boolean hasCycleBrute(Node head) {
        Node current = head;

        HashMap<Node, Integer> mpp = new HashMap<>();

        while (current != null) {
            if (mpp.containsKey(current)) {
                return true;
            }

            mpp.put(current, 1);
            current = current.next;
        }

        return false;
    }
    public boolean hasCycleOptimal(Node head) {
        Node slowPointer = head;
        Node fastPointer = head;

        while (fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;

            if (slowPointer == fastPointer) {
                return true;
            }
        }

        return false;
    }
    public static void main(String[] args) {
        // Create a linked list: 1 -> 2 -> 3 -> 4 -> 5
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        // Create a cycle: node 5 points back to node 3
        head.next.next.next.next.next = head.next.next; // 5 -> 3

        DetectLoopInLL_5 detector = new DetectLoopInLL_5();

        // Test brute force method
        boolean cycleBrute = detector.hasCycleBrute(head);
        System.out.println("Cycle Detected (Brute Force): " + cycleBrute);

        // Test optimal method (Floyd's Tortoise and Hare)
        boolean cycleOptimal = detector.hasCycleOptimal(head);
        System.out.println("Cycle Detected (Optimal): " + cycleOptimal);
    }

}
