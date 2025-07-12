package fundamentalsSingleLL;

public class InsertionBeforeValueLL_10 {

    public Node insertBeforeValue(Node head, int x, int value) {
        Node newNode = new Node(x);

        // Case 1: Empty list
        if (head == null) return newNode;

        // Case 2: Insert before head
        if (head.data == value) {
            newNode.next = head;
            return newNode;
        }

        // Case 3: Traverse and insert before target
        Node current = head;
        while (current.next != null && current.next.data != value) {
            current = current.next;
        }

        if (current.next == null) {
            System.out.println("Value " + value + " not found in the list.");
            return head;
        }

        newNode.next = current.next;
        current.next = newNode;

        return head;
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        InsertionBeforeValueLL_10 inserter = new InsertionBeforeValueLL_10();

        int[] nums = {10, 20, 30, 40};
        Node head = ll.convertArrToLL(nums);

        System.out.println("Original Linked List:");
        ll.printLinkedList(head);

        head = inserter.insertBeforeValue(head, 15, 20); // Insert 15 before 20
        head = inserter.insertBeforeValue(head, 5, 10);  // Insert 5 before head (10)
        head = inserter.insertBeforeValue(head, 100, 50); // Value not in list

        System.out.println("After Insertions:");
        ll.printLinkedList(head);
    }
}
