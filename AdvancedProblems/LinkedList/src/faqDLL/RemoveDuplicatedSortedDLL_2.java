package faqDLL;

import fundamentalsDoublyLL.DNode;

public class RemoveDuplicatedSortedDLL_2 {

    public DNode removeDuplicates(DNode head) {
        DNode current = head;

        while (current != null && current.next != null) {
            DNode nextNode = current.next;

            while (nextNode != null && current.data == nextNode.data) {
                DNode duplicateNode = nextNode;
                nextNode = nextNode.next;
                duplicateNode = null;
            }

            current.next = nextNode;

            if (nextNode != null) {
                nextNode.prev = current;
            }

            current = current.next;
        }

        return head;
    }

    // Utility method to print DLL
    public static void printList(DNode head) {
        DNode temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Creating nodes
        DNode head = new DNode(1);
        head.next = new DNode(2);
        head.next.prev = head;
        head.next.next = new DNode(2);
        head.next.next.prev = head.next;
        head.next.next.next = new DNode(3);
        head.next.next.next.prev = head.next.next;
        head.next.next.next.next = new DNode(3);
        head.next.next.next.next.prev = head.next.next.next;
        head.next.next.next.next.next = new DNode(4);
        head.next.next.next.next.next.prev = head.next.next.next.next;

        System.out.println("Original DLL:");
        printList(head);

        RemoveDuplicatedSortedDLL_2 obj = new RemoveDuplicatedSortedDLL_2();
        head = obj.removeDuplicates(head);

        System.out.println("DLL after removing duplicates:");
        printList(head);
    }
}
