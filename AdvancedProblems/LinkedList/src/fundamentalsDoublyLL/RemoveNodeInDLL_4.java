package fundamentalsDoublyLL;

public class RemoveNodeInDLL_4 {
    public void deleteGivenNode_1(DNode node) {
        if (node == null) return;

        // Update previous node's next, if not deleting the head
        if (node.prev != null) {
            node.prev.next = node.next;
        }

        // Update next node's prev, if not deleting the tail
        if (node.next != null) {
            node.next.prev = node.prev;
        }

        // Optional: clear pointers of the deleted node
        node.prev = null;
        node.next = null;
    }

    public void deleteGivenNode_2(DNode head, int node) {
        if (head == null) return;

        DNode current = head;

        // Find the node with the given value
        while (current != null && current.data != node) {
            current = current.next;
        }

        // If no such node exists, return head unchanged
        if (current == null) return;

        // Case 1: Deleting the head node
        if (current == head) {
            DNode newHead = head.next;
            if (newHead != null) {
                newHead.prev = null;
            }
            current.next = null; // clear link
            return;
        }

        // Case 2: Middle or tail node
        if (current.prev != null) {
            current.prev.next = current.next;
        }

        if (current.next != null) {
            current.next.prev = current.prev;
        }

        // Clear links for safety
        current.prev = null;
        current.next = null;
    }

    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        RemoveNodeInDLL_4 dn = new RemoveNodeInDLL_4();
        int[] nums = {1, 2, 3, 4, 5};

        DNode head = dll.convertArrToDLL(nums);
        System.out.println("Original DLL:");
        dll.printDLLForward(head);

        DNode nodeToDelete = head.next.next; // Delete node with value 3
        dn.deleteGivenNode_1(nodeToDelete);

        System.out.println("After Deletion:");
        dll.printDLLForward(head);

        RemoveNodeInDLL_4 dn1 = new RemoveNodeInDLL_4();
        DNode head1 = dll.convertArrToDLL(nums.clone());
        System.out.println("Original DLL:");
        dll.printDLLForward(head1);

        int nodeToDelete1 = 4;
        dn1.deleteGivenNode_2(head1, nodeToDelete1);

        System.out.println("After Deletion:");
        dll.printDLLForward(head1);
    }
}
