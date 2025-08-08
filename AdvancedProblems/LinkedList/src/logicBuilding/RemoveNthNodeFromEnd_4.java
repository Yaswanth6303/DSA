package logicBuilding;

import fundamentalsSingleLL.LinkedList;
import fundamentalsSingleLL.Node;

public class RemoveNthNodeFromEnd_4 {
    public Node removeNthFromEndBrute(Node head, int n) {
        int count = 0;
        Node current = head;

        // Step 1: Count total number of nodes
        while (current != null) {
            current = current.next;
            count++;
        }

        // Step 2: If the node to remove is the head
        if (n == count) {
            return head.next;
        }

        // Step 3: Find the (count - n)th node (just before the one to remove)
        int result = count - n;
        current = head;
        int i = 1; // Because we already handled the head case above

        while (i < result) {
            current = current.next;
            i++;
        }

        // Step 4: Remove the nth node from the end
        if (current != null && current.next != null) {
            current.next = current.next.next;
        }

        return head;
    }
    public Node removeNthFromEndOptimal(Node head, int n) {
        Node fastPointer = head;
        Node slowPointer = head;

        for (int i = 0; i < n; i++) {
            fastPointer = fastPointer.next;
        }

        if (fastPointer == null) {
            return head.next;
        }

        while (fastPointer.next != null) {
            fastPointer = fastPointer.next;
            slowPointer = slowPointer.next;
        }

        slowPointer.next = slowPointer.next.next;

        return head;
    }

    public static void main(String[] args) {
        RemoveNthNodeFromEnd_4 rnn = new RemoveNthNodeFromEnd_4();
        LinkedList ll = new LinkedList();

        Node l1 = new Node(1, new Node(2, new Node(3, new Node(4, new Node(5)))));
        Node head = rnn.removeNthFromEndBrute(l1, 2);
        ll.printLinkedList(head);

        Node l2 = new Node(1, new Node(2, new Node(3, new Node(4, new Node(5)))));
        Node head1 = rnn.removeNthFromEndOptimal(l2, 2);
        ll.printLinkedList(head1);
    }
}
