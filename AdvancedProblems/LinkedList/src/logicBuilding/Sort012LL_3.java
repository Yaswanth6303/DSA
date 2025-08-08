package logicBuilding;

import fundamentalsSingleLL.LinkedList;
import fundamentalsSingleLL.Node;

public class Sort012LL_3 {
    public Node sortListBrute(Node head) {
        if (head == null || head.next == null) return head;

        Node current = head;
        int count_0 = 0;
        int count_1 = 0;
        int count_2 = 0;

        while (current != null) {
            if (current.data == 0) count_0++;
            if (current.data == 1) count_1++;
            if (current.data == 2) count_2++;

            current = current.next;
        }

        current = head;
        while (current != null) {
            if (count_0 > 0) {
                current.data = 0;
                count_0--;
            } else if (count_1 > 0) {
                current.data = 1;
                count_1--;
            } else if (count_2 > 0) {
                current.data = 2;
                count_2--;
            }

            current = current.next;
        }

        return head;
    }
    public Node sortListOptimal(Node head) {
        if (head == null || head.next == null) return head;

        Node zeroHead = new Node(-1);
        Node oneHead = new Node(-1);
        Node twoHead = new Node(-1);

        Node zero = zeroHead;
        Node one = oneHead;
        Node two = twoHead;
        Node current = head;

        while (current != null) {
            if (current.data == 0) {
                zero.next = current;
                zero = current;
            } else if (current.data == 1) {
                one.next = current;
                one = current;
            } else if (current.data == 2) {
                two.next = current;
                two = current;
            }

            current = current.next;

            zero.next = (oneHead.next != null) ? oneHead.next : twoHead.next;
            one.next = twoHead.next;
            two.next = null;
        }

        return zeroHead.next;
    }
    public static void main(String[] args) {
        Sort012LL_3 sa = new Sort012LL_3();
        LinkedList ll = new LinkedList();

        Node l1 = new Node(1, new Node(0, new Node(1, new Node(2, new Node(0, new Node(2, new Node(1)))))));
        Node head = sa.sortListBrute(l1);
        ll.printLinkedList(head);

        Node l2 = new Node(1, new Node(0, new Node(1, new Node(2, new Node(0, new Node(2, new Node(1)))))));
        Node head1 = sa.sortListBrute(l2);
        ll.printLinkedList(head1);
    }
}
