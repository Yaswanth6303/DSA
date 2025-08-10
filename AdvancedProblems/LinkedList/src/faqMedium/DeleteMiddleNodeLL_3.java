package faqMedium;

import fundamentalsSingleLL.LinkedList;
import fundamentalsSingleLL.Node;

public class DeleteMiddleNodeLL_3 {
    public Node deleteMiddleNodeBrute(Node head) {
        if (head == null || head.next == null) {
            return null;
        }

        Node current = head;
        int count = 0;
        while (current != null) {
            current = current.next;
            count++;
        }

        int beforeMiddlePosition = (count / 2) - 1;
        Node beforeMiddleNode = head;

        for (int i = 0; i < beforeMiddlePosition; i++) {
            beforeMiddleNode = beforeMiddleNode.next;
        }

        beforeMiddleNode.next = beforeMiddleNode.next.next;

        return head;
    }
    public Node deleteMiddleNodeOptimal(Node head) {
        if (head == null || head.next == null) {
            return null;
        }

        Node slowPointer = head;
        Node fastPointer = head.next.next;

        while (fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }

        slowPointer.next = slowPointer.next.next;

        return head;
    }
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        DeleteMiddleNodeLL_3 dmn = new DeleteMiddleNodeLL_3();

        Node linkedList = new Node(1, new Node(2, new Node(3, new Node(4, new Node(5)))));
        Node deletedMiddleNode = dmn.deleteMiddleNodeBrute(linkedList); // Returned complete Node
        ll.printLinkedList(deletedMiddleNode);

        Node linkedList1 = new Node(1, new Node(2, new Node(3, new Node(4, new Node(5)))));
        Node deletedMiddleNode_1 = dmn.deleteMiddleNodeOptimal(linkedList1); // Returned complete Node
        ll.printLinkedList(deletedMiddleNode_1);
    }
}
