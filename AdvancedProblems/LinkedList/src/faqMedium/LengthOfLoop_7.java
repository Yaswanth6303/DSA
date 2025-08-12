package faqMedium;

import fundamentalsSingleLL.Node;
import java.util.HashMap;

public class LengthOfLoop_7 {
    public int findLengthOfLoopBrute(Node head) {
        Node current = head;
        int timer = 1;
        HashMap<Node, Integer> nodeHashMap = new HashMap<>();

        while (current != null) {
            if (nodeHashMap.containsKey(current)) {
                return timer - nodeHashMap.get(current);
            }
            nodeHashMap.put(current, timer);
            timer++;
            current = current.next;
        }
        return 0;
    }

    public int findLength(Node slowP, Node fastP) {
        int count = 1;
        fastP = fastP.next;
        while (fastP != slowP) {
            fastP = fastP.next;
            count++;
        }
        return count;
    }

    public int findLengthOfLoopOptimal(Node head) {
        Node slowP = head;
        Node fastP = head;

        while (fastP != null && fastP.next != null) {
            slowP = slowP.next;
            fastP = fastP.next.next;

            if (slowP == fastP) {
                return findLength(slowP, fastP);
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        // Create linked list: 1 -> 2 -> 3 -> 4 -> 5 -> 3 (loop back to node 3)
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        // Creating loop: pointing node 5's next to node 3
        head.next.next.next.next.next = head.next.next;

        LengthOfLoop_7 loopFinder = new LengthOfLoop_7();

        System.out.println("Length of loop (Brute): " + loopFinder.findLengthOfLoopBrute(head));
        System.out.println("Length of loop (Optimal): " + loopFinder.findLengthOfLoopOptimal(head));

        // Create list without loop: 1 -> 2 -> 3 -> null
        Node head2 = new Node(1);
        head2.next = new Node(2);
        head2.next.next = new Node(3);

        System.out.println("Length of loop (Brute, no loop): " + loopFinder.findLengthOfLoopBrute(head2));
        System.out.println("Length of loop (Optimal, no loop): " + loopFinder.findLengthOfLoopOptimal(head2));
    }
}
