package faqHard;

import java.util.HashMap;

class Node {
    int data;
    Node next;
    Node random;

    Node() {
        this.data = 0;
        this.next = null;
        this.random = null;
    }

    Node(int data) {
        this.data = data;
        this.next = null;
        this.random = null;
    }

    Node(int data, Node next, Node random) {
        this.data = data;
        this.next = next;
        this.random = random;
    }
}

public class CloneLL_6 {

    // Brute-force using HashMap
    public Node copyRandomListBrute(Node head) {
        if (head == null)
            return null;

        HashMap<Node, Node> mpp = new HashMap<>();
        Node current = head;

        // Create mapping of original -> new copy
        while (current != null) {
            Node newNode = new Node(current.data);
            mpp.put(current, newNode);
            current = current.next;
        }

        // Assign next & random pointers
        current = head;
        while (current != null) {
            Node copyNode = mpp.get(current);
            copyNode.next = mpp.get(current.next);
            copyNode.random = mpp.get(current.random);
            current = current.next;
        }

        return mpp.get(head);
    }

    // Step 1: Insert copy nodes in between original nodes
    public void insertNodesInBetween(Node head) {
        Node current = head;
        while (current != null) {
            Node nextElement = current.next;
            Node copyNode = new Node(current.data);

            current.next = copyNode;
            copyNode.next = nextElement;
            current = nextElement;
        }
    }

    // Step 2: Connect random pointers of copy nodes
    public void connectRandomPointers(Node head) {
        Node current = head;
        while (current != null) {
            Node copyNode = current.next;
            if (current.random != null) {
                copyNode.random = current.random.next;
            }
            current = current.next.next; // skip copy node
        }
    }

    // Step 3: Separate the copy list from the original list
    public Node getDeepCopyList(Node head) {
        Node current = head;
        Node dummyNode = new Node(-1);
        Node copyIter = dummyNode;

        while (current != null) {
            Node copyNode = current.next;
            copyIter.next = copyNode;
            copyIter = copyNode;

            current.next = copyNode.next; // restore original
            current = current.next;
        }

        return dummyNode.next;
    }

    // Optimal O(1) space solution
    public Node copyRandomListOptimal(Node head) {
        if (head == null)
            return null;

        insertNodesInBetween(head);
        connectRandomPointers(head);
        return getDeepCopyList(head);
    }

    // Utility to print list with random pointers
    public void printList(Node head) {
        Node current = head;
        while (current != null) {
            int randomVal = (current.random != null) ? current.random.data : -1;
            System.out.print("(" + current.data + ", rand:" + randomVal + ") -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        CloneLL_6 obj = new CloneLL_6();

        // Create example linked list:
        // 1 -> 2 -> 3 -> 4
        // Random: 1->3, 2->1, 3->4, 4->2
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);

        head.random = head.next.next; // 1 -> 3
        head.next.random = head; // 2 -> 1
        head.next.next.random = head.next.next.next; // 3 -> 4
        head.next.next.next.random = head.next; // 4 -> 2

        System.out.println("Original list:");
        obj.printList(head);

        System.out.println("\nBrute force copy:");
        Node bruteCopy = obj.copyRandomListBrute(head);
        obj.printList(bruteCopy);

        System.out.println("\nOptimal copy:");
        Node optimalCopy = obj.copyRandomListOptimal(head);
        obj.printList(optimalCopy);
    }
}
