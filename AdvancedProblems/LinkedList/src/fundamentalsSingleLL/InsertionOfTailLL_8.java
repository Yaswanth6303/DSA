package fundamentalsSingleLL;

public class InsertionOfTailLL_8 {
    public Node insertAtTail(Node head, int x) {
        Node newNode = new Node(x);

        if (head == null) {
            return newNode;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;
        return head;
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        InsertionOfTailLL_8 tailInserter = new InsertionOfTailLL_8();

        int[] nums = {10, 20, 30};
        Node head = ll.convertArrToLL(nums);

        System.out.println("Original Linked List:");
        ll.printLinkedList(head);

        head = tailInserter.insertAtTail(head, 40); // insert 40 at tail
        head = tailInserter.insertAtTail(head, 50); // insert 50 at tail

        System.out.println("After inserting at tail:");
        ll.printLinkedList(head);
    }
}
