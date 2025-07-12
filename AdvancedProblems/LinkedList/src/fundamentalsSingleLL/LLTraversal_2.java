package fundamentalsSingleLL;

import java.util.List;

public class LLTraversal_2 {
    public static void main(String[] args) {
        // Step 1: Directly create linked list: 12 -> 23 -> 24 -> 28 -> null
        Node head = new Node(12);
        head.next = new Node(23);
        head.next.next = new Node(24);
        head.next.next.next = new Node(28);

        // (Or)
//        Node n1 = new Node(14);
//        Node n2 = new Node(28);
//        Node n3 = new Node(42);
//        Node n4 = new Node(56);
//
//        n1.next = n2;
//        n2.next = n3;
//        n3.next = n4;

        // Step 2: Traverse linked list
        LLTraversal_1 lt = new LLTraversal_1();
        List<Integer> result = lt.llTraversal(head);

        // Step 3: Print in arrow format
        System.out.println("Linked List: ");
        for (int i = 0; i < result.size(); i++) {
            if (i == result.size() - 1) {
                System.out.print(result.get(i));
            } else {
                System.out.print(result.get(i) + " -> ");
            }
        }
        System.out.println();
    }
}
