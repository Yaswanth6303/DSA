package faqHard;

import fundamentalsSingleLL.LinkedList;
import fundamentalsSingleLL.Node;

public class RotateLL_2 {
    public Node rotateRightBrute(Node head, int k) {
        if (head == null || head.next == null) {
            return head;
        }

        for (int i = 0; i < k; i++) {
            Node current = head;
            while (current.next.next != null) {
                current = current.next;
            }

            Node lastNode = current.next;
            current.next = null;
            lastNode.next = head;
            head = lastNode;
        }

        return head;
    }
    public Node rotateRightOptimal(Node head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }


        // Step 1: Find length
        int length = 1;
        Node current = head;
        while (current.next != null) {
            current = current.next;
            length++;
        }

        // Step 2: Connect last node to head (make it circular)
        current.next = head;

        // Step 3: Adjust k to avoid unnecessary rotations
        k = k % length;
        int stepsToNewHead = length - k;

        if (k % length == 0) {
            return head;
        }

        // Step 4: Move to new tail
        Node newTail = current; // start from the last node
        while (stepsToNewHead-- > 0) {
            newTail = newTail.next;
        }

        // Step 5: Break the circle
        head = newTail.next;
        newTail.next = null;

        return head;
    }

    public static void main(String[] args) {
        // Create linked list: 1 -> 2 -> 3 -> 4 -> 5
        LinkedList ll = new LinkedList();
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        RotateLL_2 rotateList = new RotateLL_2();

        System.out.println("Original list:");
        ll.printLinkedList(head);

        // Rotate by k using brute force
        Node rotatedBrute = rotateList.rotateRightBrute(cloneList(head), 13);
        System.out.println("\nAfter rotating by 2 (Brute Force):");
        ll.printLinkedList(rotatedBrute);

        // Rotate by k using optimal method
        Node rotatedOptimal = rotateList.rotateRightOptimal(cloneList(head), 13);
        System.out.println("\nAfter rotating by 2 (Optimal):");
        ll.printLinkedList(rotatedOptimal);
    }

    // Helper method to clone list so brute and optimal don't interfere
    private static Node cloneList(Node head) {
        if (head == null) return null;
        Node newHead = new Node(head.data);
        Node currentNew = newHead;
        Node currentOld = head.next;

        while (currentOld != null) {
            currentNew.next = new Node(currentOld.data);
            currentNew = currentNew.next;
            currentOld = currentOld.next;
        }
        return newHead;
    }
}
