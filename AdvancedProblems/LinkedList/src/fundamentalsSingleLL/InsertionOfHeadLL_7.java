package fundamentalsSingleLL;

public class InsertionOfHeadLL_7 {

    // Inserts a new node with value x at the head and returns the new head
    public Node insertAtHead(Node head, int x) {
        Node newNode = new Node(x);  // Create the new node
        newNode.next = head;         // Point it to the current head
        return newNode;              // Return new head
    }

    // Utility method to print the linked list
    public void printLinkedList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // Original list: 23 -> 34 -> 45 -> null
        Node head = new Node(23);
        head.next = new Node(34);
        head.next.next = new Node(45);

        InsertionOfHeadLL_7 ih = new InsertionOfHeadLL_7();

        System.out.println("Original Linked List:");
        ih.printLinkedList(head);

        int x = 12; // Value to insert at head

        // Insert at head
        head = ih.insertAtHead(head, x);

        System.out.println("After Inserting " + x + " at Head:");
        ih.printLinkedList(head);
    }
}
