package faqHard;

import fundamentalsSingleLL.Node;

public class ReverseLLInGroup_1 {

    public Node reverseKGroup(Node head, int k) {
        Node current = head;
        Node prev = null;

        while (current != null) {
            Node kthNode = getKthNode(current, k); // <-- fixed here, use current not head

            if (kthNode == null) {
                if (prev != null) {
                    prev.next = current;
                }
                break;
            }

            Node nextNode = kthNode.next;
            kthNode.next = null;
            reverseLL(current);

            if (current == head) {
                head = kthNode;
            } else {
                prev.next = kthNode;
            }

            prev = current;
            current = nextNode;
        }

        return head;
    }

    public Node getKthNode(Node current, int k) {
        int count = 0;
        while (current != null && count < k - 1) {
            count++;
            current = current.next;
        }
        return current;
    }

    public Node reverseLL(Node head) {
        Node current = head;
        Node prev = null;
        while (current != null) {
            Node front = current.next;
            current.next = prev;
            prev = current;
            current = front;
        }
        return prev;
    }

    public static void main(String[] args) {
        // Create linked list 1 → 2 → 3 → ... → 9
        Node head = new Node(1);
        Node current = head;
        for (int i = 2; i <= 10; i++) {
            current.next = new Node(i);
            current = current.next;
        }

        // Reverse in groups of k
        int k = 3;
        ReverseLLInGroup_1 obj = new ReverseLLInGroup_1();
        head = obj.reverseKGroup(head, k);

        // Print the result
        current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.print("null");
    }
}
