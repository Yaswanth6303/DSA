package fundamentalsDoublyLL;

public class InsertBeforeKthNode_7 {
    public DNode insertBeforeKthPosition(DNode head, int X, int K) {
        DNode newNode = new DNode(X);

        // Case 1: Insert at the beginning (before head)
        if (K <= 1 || head == null) {
            newNode.next = head;
            if (head != null) {
                head.prev = newNode;
            }
            return newNode;
        }

        DNode current = head;
        int count = 1;

        // Traverse to (K-1)-th node
        while (current != null && count < K - 1) {
            current = current.next;
            count++;
        }

        // If K is beyond the length of the list, insert at end
        if (current == null || current.next == null) {
            // Insert at tail
            if (current != null) {
                current.next = newNode;
                newNode.prev = current;
            }
            return head;
        }

        DNode nextNode = current.next;

        // Insert newNode between current and nextNode
        current.next = newNode;
        newNode.prev = current;

        newNode.next = nextNode;
        nextNode.prev = newNode;

        return head;
    }

    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        InsertBeforeKthNode_7 ibk = new InsertBeforeKthNode_7();
        int[] nums = {1, 3, 5};
        int X = 7;
        int K = 2;

        DNode head = dll.convertArrToDLL(nums);
        System.out.println("Original DLL:");
        dll.printDLLForward(head);

        DNode nodeBeforeKthNode = ibk.insertBeforeKthPosition(head, X, K);
        dll.printDLLForward(nodeBeforeKthNode);

        DNode tail = nodeBeforeKthNode;
        while (tail.next != null) tail = tail.next;
        dll.printDLLBackward(tail);
    }
}
