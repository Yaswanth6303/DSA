package fundamentalsSingleLL;

public class DeletionOfHeadLL_3 {

    // Deletes the head node and returns the new head
    public Node deleteHead(Node head) {
        if (head == null) return null; // Edge case: empty list
        // Garbage collector will remove the old head from the heap memory
        return head.next;
    }

    // Prints the linked list in arrow format
    public void printLinkedList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // Creating Linked List: 12 -> 23 -> 24 -> 28 -> null
        Node head = new Node(12);
        head.next = new Node(23);
        head.next.next = new Node(24);
        head.next.next.next = new Node(28);

        DeletionOfHeadLL_3 dh = new DeletionOfHeadLL_3();

        System.out.println("Before Deleting Head:");
        dh.printLinkedList(head);

        // Delete head and get updated head
        head = dh.deleteHead(head);

        System.out.println("After Deleting Head:");
        dh.printLinkedList(head);
    }
}
