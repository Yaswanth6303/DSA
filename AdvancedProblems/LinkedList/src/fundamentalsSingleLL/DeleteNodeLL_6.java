package fundamentalsSingleLL;

public class DeleteNodeLL_6 {

    // Deletes the first node with value x and returns the updated head
    public Node deleteNodeWithValueX(Node head, int x) {
        if (head == null) return null;

        if (head.data == x) {
            return head.next;
        }

        Node current = head;
        while (current.next != null && current.next.data != x) {
            current = current.next;
        }

        if (current.next != null && current.next.data == x) {
            current.next = current.next.next;
        }

        return head;
    }


    // Print method for testing
    public void printLinkedList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // Create linked list: 12 -> 23 -> 24 -> 28 -> null
        Node head = new Node(12);
        head.next = new Node(23);
        head.next.next = new Node(24);
        head.next.next.next = new Node(28);

        DeleteNodeLL_6 dn = new DeleteNodeLL_6();

        System.out.println("Original Linked List:");
        dn.printLinkedList(head);

        int x = 24; // Value to delete

        // Delete node with value x
        head = dn.deleteNodeWithValueX(head, x);

        System.out.println("After Deleting Node with value " + x + ":");
        dn.printLinkedList(head);
    }
}
