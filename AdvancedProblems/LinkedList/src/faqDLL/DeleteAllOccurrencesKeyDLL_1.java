package faqDLL;

import fundamentalsDoublyLL.DNode;

public class DeleteAllOccurrencesKeyDLL_1 {
    public DNode deleteAllOccurrences(DNode head, int target) {
        DNode current = head;

        while (current != null) {
            if (current.data != target) {
                current = current.next;
            } else {
                if (current == head) {
                    head = current.next;
                }

                DNode nextNode = current.next;
                DNode prevNode = current.prev;

                if (prevNode != null) {
                    prevNode.next = nextNode;
                }

                if (nextNode != null) {
                    nextNode.prev = prevNode;
                }

                current = nextNode;
            }
        }

        return head;
    }

    // Utility method to print the list
    public static void printList(DNode head) {
        DNode temp = head;
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // Create sample doubly linked list: 10 <-> 20 <-> 30 <-> 20 <-> 40
        DNode head = new DNode(10);
        DNode second = new DNode(20);
        DNode third = new DNode(30);
        DNode fourth = new DNode(20);
        DNode fifth = new DNode(40);

        head.next = second;
        second.prev = head;

        second.next = third;
        third.prev = second;

        third.next = fourth;
        fourth.prev = third;

        fourth.next = fifth;
        fifth.prev = fourth;

        System.out.println("Original List:");
        printList(head);

        // Delete all occurrences of 20
        DeleteAllOccurrencesKeyDLL_1 obj = new DeleteAllOccurrencesKeyDLL_1();
        head = obj.deleteAllOccurrences(head, 20);

        System.out.println("\nList after deleting all occurrences of 20:");
        printList(head);
    }
}
