package logicBuilding;

import fundamentalsSingleLL.Node;
import fundamentalsSingleLL.LinkedList;

public class AddTwoNumbersInLL_1 {
    public Node addTwoNumbers(Node l1, Node l2) {
        Node dummyNode = new Node(-1);
        Node current = dummyNode;

        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;

            if (l1 != null) {
                sum += l1.data;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.data;
                l2 = l2.next;
            }

            carry = sum / 10;
            Node newNode = new Node(sum % 10);

            current.next = newNode;
            current = current.next;
        }

        return dummyNode.next;
    }
    public static void main(String[] args) {
        AddTwoNumbersInLL_1 atn = new AddTwoNumbersInLL_1();
        LinkedList ll = new LinkedList();
        Node l1 = new Node(2, new Node(4, new Node(6)));
        Node l2 = new Node(3, new Node(8, new Node(7)));

        Node head = atn.addTwoNumbers(l1, l2);
        ll.printLinkedList(head);
    }
}
