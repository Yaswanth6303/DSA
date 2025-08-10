package faqMedium;

import fundamentalsSingleLL.LinkedList;
import fundamentalsSingleLL.Node;
import logicBuilding.ReverseLinkedList_5;

public class AddOneToNumberLL_1 {
    public Node addOneIterative(Node head) {
        ReverseLinkedList_5 rl = new ReverseLinkedList_5();

        Node reversedLL = rl.reverseListOptimalIterative(head);
        Node current = reversedLL;

        int carry = 1;

        while (current != null) {
            int sum = current.data + carry;
            carry = sum / 10;
            current.data = sum % 10;

            if (carry == 0) break;

            if (current.next == null && carry != 0) {
                current.next = new Node(carry);
                break;
            }

            current = current.next;
        }

        head = rl.reverseListOptimalIterative(reversedLL);

        return head;
    }

    public int backtrack(Node head) {
        if (head == null) {
            return 1;
        }

        int carry = backtrack(head.next);

        head.data += carry;

        if (head.data < 10) {
            return 0;
        }

        head.data = 0;
        return 1;
    }

    public Node addOneRecursive(Node head) {
        int carry = backtrack(head);

        if (carry == 1) {
            Node newNode = new Node(1);
            newNode.next = head;
            head = newNode;
        }
        return head;
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();

        Node linkedList = new Node(1, new Node(5, new Node(9)));
        System.out.print("Original LL: ");
        ll.printLinkedList(linkedList);

        AddOneToNumberLL_1 atn = new AddOneToNumberLL_1();
        System.out.print("LL After add one: ");
        Node head = atn.addOneIterative(linkedList);
        ll.printLinkedList(head);

        System.out.println();

        Node linkedList_1 = new Node(1, new Node(5, new Node(9)));
        System.out.print("Original LL: ");
        ll.printLinkedList(linkedList_1);

        AddOneToNumberLL_1 atn1 = new AddOneToNumberLL_1();
        System.out.print("LL After add one: ");
        Node head_1 = atn1.addOneRecursive(linkedList_1);
        ll.printLinkedList(head_1);
    }
}
