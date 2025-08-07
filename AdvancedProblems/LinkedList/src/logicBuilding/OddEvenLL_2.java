package logicBuilding;

import fundamentalsSingleLL.Node;
import fundamentalsSingleLL.LinkedList;

import java.util.ArrayList;
import java.util.List;

public class OddEvenLL_2 {
    public Node oddEvenList(Node head) {
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

    public static void main(String[] args) {
        OddEvenLL_2 oe = new OddEvenLL_2();
        LinkedList ll = new LinkedList();

        Node l1 = new Node(1, new Node(3, new Node(4, new Node(2, new Node(5, new Node(6))))));
        Node head = oe.oddEvenList(l1);

        ll.printLinkedList(head);
    }
}
