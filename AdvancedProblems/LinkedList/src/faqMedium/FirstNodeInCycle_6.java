package faqMedium;

import fundamentalsSingleLL.Node;

public class FirstNodeInCycle_6 {
    public Node firstNodeInCycleBrute(Node head) {
        Node current = head;

        java.util.HashMap<Node, Integer> nodeHashMap = new java.util.HashMap<>();

        while (current != null) {
            if (nodeHashMap.containsKey(current)) {
                return current;
            }

            nodeHashMap.put(current, 1);
            current = current.next;
        }

        return null;
    }

    public Node firstNodeInCycleOptimal(Node head) {
        Node slowP = head;
        Node fastP = head;

        while (fastP != null && fastP.next != null) {
            slowP = slowP.next;
            fastP = fastP.next.next;

            if (slowP == fastP) {
                slowP = head;

                while (slowP != fastP) {
                    slowP = slowP.next;
                    fastP = fastP.next;
                }

                return slowP;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        // Create linked list: 1 -> 2 -> 3 -> 4 -> 5 -> back to 3 (cycle)
        Node head = new Node(1, new Node(2, new Node(3, new Node(4, new Node(5)))));

        // Create cycle: point last node (5) to node (3)
        head.next.next.next.next.next = head.next.next;

        FirstNodeInCycle_6 finder = new FirstNodeInCycle_6();

        Node cycleStartBrute = finder.firstNodeInCycleBrute(head);
        Node cycleStartOptimal = finder.firstNodeInCycleOptimal(head);

        System.out.println("Brute Force Cycle Start: " +
                (cycleStartBrute != null ? cycleStartBrute.data : "No cycle"));

        System.out.println("Optimal Cycle Start: " +
                (cycleStartOptimal != null ? cycleStartOptimal.data : "No cycle"));
    }
}
