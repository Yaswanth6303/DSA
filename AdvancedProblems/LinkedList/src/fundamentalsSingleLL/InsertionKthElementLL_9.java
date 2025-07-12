package fundamentalsSingleLL;

public class InsertionKthElementLL_9 {

    public Node insertAtKthPosition(Node head, int x, int k) {
        Node newNode = new Node(x);

        // Case 1: Insert at the beginning
        if (k == 1) {
            newNode.next = head;
            return newNode;
        }

        Node current = head;
        int count = 1;

        // Traverse to (k-1)th node
        while (current != null && count < k - 1) {
            current = current.next;
            count++;
        }

        // If current is null, k is greater than length+1 → invalid
        if (current == null) {
            System.out.println("Invalid position: " + k);
            return head;
        }

        newNode.next = current.next;
        current.next = newNode;

        return head;
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        InsertionKthElementLL_9 inserter = new InsertionKthElementLL_9();

        int[] nums = {5, 10, 15, 25};
        Node head = ll.convertArrToLL(nums);

        System.out.println("Original Linked List:");
        ll.printLinkedList(head);

        head = inserter.insertAtKthPosition(head, 100, 1); // Insert at head
        head = inserter.insertAtKthPosition(head, 200, 3); // Insert at position 3
        head = inserter.insertAtKthPosition(head, 300, 8); // Insert at position 8 (end)

        System.out.println("After Insertions:");
        ll.printLinkedList(head);
    }
}
