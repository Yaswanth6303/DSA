package fundamentalsDoublyLL;

public class InsertBeforeTailDLL_6 {
    public DNode insertBeforeTail(DNode head, int X) {
        DNode newNode = new DNode(X);

        // Case 1: Empty list or only one node
        if (head == null || head.next == null) {
            newNode.next = head;
            if (head != null) {
                head.prev = newNode;
            }
            return newNode;
        }

        DNode current = head;

        // Traverse until the second last node
        while (current.next.next != null) {
            current = current.next;
        }

        DNode tail = current.next;

        // Insert newNode between current and tail
        current.next = newNode;
        newNode.prev = current;

        newNode.next = tail;
        tail.prev = newNode;

        return head;
    }

    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        InsertBeforeTailDLL_6 ibt = new InsertBeforeTailDLL_6();
        int[] nums = {1, 2, 4};
        int X = 3;

        DNode head = dll.convertArrToDLL(nums);
        System.out.println("Original DLL:");
        dll.printDLLForward(head);

        DNode nodeBeforeTail = ibt.insertBeforeTail(head, X);
        dll.printDLLForward(nodeBeforeTail);

        DNode tail = nodeBeforeTail;
        while (tail.next != null) tail = tail.next;
        dll.printDLLBackward(tail);
    }
}
