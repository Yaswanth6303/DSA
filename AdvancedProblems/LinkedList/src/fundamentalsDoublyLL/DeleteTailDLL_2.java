package fundamentalsDoublyLL;

public class DeleteTailDLL_2 {
    public DNode deleteTail(DNode head) {
        if (head == null || head.next == null) return null;
        DNode current = head;

        while (current.next.next != null) {
            current = current.next;
        }

        current.next = null;

        return head;
    }
    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        DeleteTailDLL_2 dt = new DeleteTailDLL_2();
        int[] nums = {1, 2, 3};
        DNode head = dll.convertArrToDLL(nums);
        dll.printDLLForward(head);
        DNode tailAfterDeletion = dt.deleteTail(head);
        dll.printDLLForward(tailAfterDeletion);
        DNode tail = tailAfterDeletion;
        while (tail.next != null) tail = tail.next;
        dll.printDLLBackward(tail);
    }
}
