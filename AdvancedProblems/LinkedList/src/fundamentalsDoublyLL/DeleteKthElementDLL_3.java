package fundamentalsDoublyLL;

public class DeleteKthElementDLL_3 {

    public DNode deleteKthElement(DNode head, int k) {
        if (head == null || k <= 0) return head; // Invalid case

        // Deleting the first node
        if (k == 1) {
            DNode newHead = head.next;
            if (newHead != null) {
                newHead.prev = null;
            }
            return newHead;
        }

        DNode current = head;
        int count = 1;

        // Traverse to the k-th node
        while (current != null && count < k && current.next.next != null) {
            current = current.next;
            count++;
        }

        // If k is more than the number of nodes
        if (current == null) return head;

        // Update links to remove current node
        if (current.prev != null) {
            current.prev.next = current.next;
        }

        if (current.next != null) {
            current.next.prev = current.prev;
        }

        return head;
    }


    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        DeleteKthElementDLL_3 dke = new DeleteKthElementDLL_3();
        int[] nums = {1, 2, 3, 4, 5};
        int k = 3;
        DNode head = dll.convertArrToDLL(nums);
        dll.printDLLForward(head);
        DNode deletionAfterKthElement = dke.deleteKthElement(head, k);
        dll.printDLLForward(deletionAfterKthElement);
        DNode tail = deletionAfterKthElement;
        while (tail.next != null) tail = tail.next;
        dll.printDLLBackward(tail);
    }
}
