package logicBuilding;

import fundamentalsSingleLL.Node;
import fundamentalsSingleLL.LinkedList;

import java.util.ArrayList;
import java.util.List;

public class OddEvenLL_2 {
    public Node oddEvenListBrute(Node head) {
        if (head == null || head.next == null) return head;

        List<Integer> arrayList = new ArrayList<>();
        Node current = head;

        while (current != null && current.next != null) {
            arrayList.add(current.data);
            current = current.next.next;
        }

        if (current != null) {
            arrayList.add(current.data);
        }

        current = head.next;

        while (current != null && current.next != null) {
            arrayList.add(current.data);
            current = current.next.next;
        }

        if (current != null) {
            arrayList.add(current.data);
        }

        current = head;
        int i = 0;

        while(current != null) {
            current.data = arrayList.get(i);
            current = current.next;
            i++;
        }

        return head;
    }

    public Node oddEvenListOptimal(Node head) {
        if (head == null && head.next == null) {
            return head;
        }

        Node odd = head;
        Node even = head.next;
        Node firstEven = head.next;

        while (even != null && even.next != null) {
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }

        odd.next = firstEven;

        return head;
    }

    public static void main(String[] args) {
        OddEvenLL_2 oe = new OddEvenLL_2();
        LinkedList ll = new LinkedList();

        Node l1 = new Node(1, new Node(3, new Node(4, new Node(2, new Node(5, new Node(6))))));
        Node head = oe.oddEvenListBrute(l1);
        ll.printLinkedList(head);

        Node l2 = new Node(1, new Node(3, new Node(4, new Node(2, new Node(5, new Node(6))))));
        Node head1 = oe.oddEvenListOptimal(l2);
        ll.printLinkedList(head1);
    }
}
