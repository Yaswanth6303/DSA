package fundamentalsDoublyLL;

public class DeleteHeadDLL_1 {

    public DNode deleteHead(DNode head) {
        if (head == null || head.next == null) return null;

        DNode newHead = head.next;
        newHead.prev = null;

        return newHead;
    }

    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        DeleteHeadDLL_1 dh = new DeleteHeadDLL_1();
        int[] nums = {1, 2, 3};
        DNode head = dll.convertArrToDLL(nums);
        dll.printDLLForward(head);
        DNode headAfterDeletion = dh.deleteHead(head);
        dll.printDLLForward(headAfterDeletion);
        DNode tail = headAfterDeletion;
        while (tail.next != null) tail = tail.next;
        dll.printDLLBackward(tail);
    }
}
