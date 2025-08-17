package fundamentalsDoublyLL;

public class DoublyLinkedList {

    // Convert array to doubly linked list
    DNode convertArrToDLL(int[] nums) {
        if (nums.length == 0) return null;

        DNode head = new DNode(nums[0]);
        DNode mover = head;

        for (int i = 1; i < nums.length; i++) {
            DNode temp = new DNode(nums[i]);
            mover.next = temp;
            temp.prev = mover;  // Set back reference
            mover = temp;
        }

        return head;
    }

    // Print doubly linked list forward
    void printDLLForward(DNode head) {
        DNode current = head;
        while (current != null) {
            System.out.print(current.data + " <-> ");
            current = current.next;
        }
        System.out.println("null");
    }

    // Print doubly linked list backward (for demonstration)
    void printDLLBackward(DNode tail) {
        DNode current = tail;
        while (current != null) {
            System.out.print(current.data + " <-> ");
            current = current.prev;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        int[] nums = {2, 4, 6, 8};

        DoublyLinkedList dll = new DoublyLinkedList();
        DNode head = dll.convertArrToDLL(nums);

        System.out.print("First Element in the DLL: ");
        System.out.println(head.data);

        System.out.print("Second Element in the DLL: ");
        System.out.println(head.next.data);

        System.out.println("Doubly Linked List Forward:");
        dll.printDLLForward(head);

        // Optional: print in reverse by going to the tail
        DNode tail = head;
        while (tail.next != null) tail = tail.next;

        System.out.println("Doubly Linked List Backward:");
        dll.printDLLBackward(tail);
    }
}

