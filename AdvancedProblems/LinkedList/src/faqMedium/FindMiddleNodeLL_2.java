package faqMedium;

import fundamentalsSingleLL.LinkedList;
import fundamentalsSingleLL.Node;

public class FindMiddleNodeLL_2 {
    public Node middleOfLLBrute(Node head) {
        Node current = head;
        int count = 0;
        while (current.next != null) {
            current = current.next;
            count++;
        }

        int midPosition = (count / 2) + 1;
        Node middleNode = head;

        for (int i = 1; i < midPosition; i++) {
            middleNode = middleNode.next;
        }

        return middleNode;
    }
    public Node middleOfLLOptimal(Node head) {
        Node slowPointer = head;
        Node fastPointer = head;

        while (fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }

        return slowPointer;
    }
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        FindMiddleNodeLL_2 fmn = new FindMiddleNodeLL_2();

        Node linkedList = new Node(1, new Node(2, new Node(3, new Node(4, new Node(5)))));
        Node middleNode = fmn.middleOfLLBrute(linkedList); // Returned complete Node
        System.out.println(middleNode.data);

        Node linkedList1 = new Node(1, new Node(2, new Node(3, new Node(4, new Node(5)))));
        Node middleNode1 = fmn.middleOfLLOptimal(linkedList1); // Returned complete Node
        System.out.println(middleNode1.data);
    }
}
