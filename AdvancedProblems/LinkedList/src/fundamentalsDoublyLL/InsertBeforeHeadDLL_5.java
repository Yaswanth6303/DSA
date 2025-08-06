package fundamentalsDoublyLL;

public class InsertBeforeHeadDLL_5 {
    public DNode insertBeforeHead(DNode head, int X) {
        DNode newNode = new DNode(X);
        // head.prev = newNode;
        // (OR)
        newNode.next = head;
        head.prev = newNode;

        return newNode;
    }

    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        InsertBeforeHeadDLL_5 in = new InsertBeforeHeadDLL_5();
        int[] nums = {1, 2, 3, 4, 5};
        int node = 7;

        DNode head = dll.convertArrToDLL(nums);
        System.out.println("Original DLL:");
        dll.printDLLForward(head);

        DNode nodeAfterInsertion = in.insertBeforeHead(head, node);
        dll.printDLLForward(nodeAfterInsertion);

        DNode tail = nodeAfterInsertion;
        while (tail.next != null) tail = tail.next;
        dll.printDLLBackward(tail);
    }
}
