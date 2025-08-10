package logicBuilding;

import fundamentalsSingleLL.LinkedList;
import fundamentalsSingleLL.Node;

import java.util.Stack;

public class ReverseLinkedList_5 {
    public Node reverseListBrute(Node head) {
        if (head == null) return null;

        Stack<Node> stack = new Stack<>();
        Node current = head;

        while (current != null) {
            stack.push(current);
            current = current.next;
        }

        Node newHead = stack.pop();
        current = newHead;

        while (!stack.isEmpty()) {
            current.next = stack.pop();
            current = current.next;
        }

        current.next = null;

        return newHead;
    }

    public Node reverseListOptimalIterative(Node head) {
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

    public Node reverseListOptimalRecursive(Node head) {
        if (head == null && head.next == null) return head;

        Node newHead = reverseListOptimalRecursive(head.next);
        Node front = head.next;
        front.next = head;
        head.next = null;
        return newHead;
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ReverseLinkedList_5 rll = new ReverseLinkedList_5();

        Node l1 = new Node(1, new Node(3, new Node(2, new Node(5))));
        Node head = rll.reverseListBrute(l1);
        ll.printLinkedList(head);

        Node l2 = new Node(1, new Node(3, new Node(2, new Node(5))));
        Node head1 = rll.reverseListOptimalIterative(l2);
        ll.printLinkedList(head1);

        Node l3 = new Node(1, new Node(3, new Node(2, new Node(5))));
        Node head2 = rll.reverseListOptimalIterative(l3);
        ll.printLinkedList(head2);

        Node l4 = new Node(1, new Node(3, new Node(2, new Node(5))));
        Node head3 = rll.reverseListOptimalIterative(l4);
        ll.printLinkedList(head3);
    }
}
