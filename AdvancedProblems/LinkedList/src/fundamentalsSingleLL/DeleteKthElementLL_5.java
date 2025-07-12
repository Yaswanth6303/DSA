package fundamentalsSingleLL;

public class DeleteKthElementLL_5 {

    // Deletes the k-th node and returns the updated head
    public Node deleteKthElement(Node head, int k) {
        if (head == null) return null;

        // Case: Delete the head
        if (k == 1) {
            return head.next;
        }

        Node current = head;
        int count = 1;

        // Traverse to (k-1)-th node
        while (current != null && count < k - 1) {
            current = current.next;
            count++;
        }

        // If current is null or current.next is null, k is out of bounds
        if (current == null || current.next == null) {
            System.out.println("Invalid k: " + k);
            return head;
        }

        // Delete k-th node
        current.next = current.next.next;

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
        // Create Linked List: 12 -> 23 -> 24 -> 28 -> null
        Node head = new Node(12);
        head.next = new Node(23);
        head.next.next = new Node(24);
        head.next.next.next = new Node(28);

        DeleteKthElementLL_5 dk = new DeleteKthElementLL_5();

        System.out.println("Original Linked List:");
        dk.printLinkedList(head);

        int k = 3; // Change k to delete different positions

        // Delete k-th node
        head = dk.deleteKthElement(head, k);

        System.out.println("After Deleting " + k + "-th Node:");
        dk.printLinkedList(head);
    }
}
