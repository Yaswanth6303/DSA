package fundamentalsSingleLL;

public class DeletionOfTailLL_4 {

    // Deletes the tail node and returns the updated head
    public Node deleteTail(Node head) {
        if (head == null || head.next == null) {
            // Empty list or only one node, return null
            return null;
        }

        Node current = head;
        // Traverse until the second last node
        while (current.next.next != null) {
            current = current.next;
        }

        // Remove the last node
        current.next = null;

        return head;
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
        // Creating Linked List: 1 -> 8 -> 9 -> 3 -> null
        Node head = new Node(1);
        head.next = new Node(8);
        head.next.next = new Node(9);
        head.next.next.next = new Node(3);

        DeletionOfTailLL_4 dt = new DeletionOfTailLL_4();

        System.out.println("Before Deleting Tail:");
        dt.printLinkedList(head);

        // Delete tail and get updated head
        head = dt.deleteTail(head);

        System.out.println("After Deleting Tail:");
        dt.printLinkedList(head);
    }
}
