package fundamentalsDoublyLL;

public class InsertBeforeGivenNode_8 {
    public void insertBeforeGivenNode_1(DNode node, int X) {
        if (node == null) return;

        DNode newNode = new DNode(X);

        newNode.next = node;
        newNode.prev = node.prev;

        if (node.prev != null) {
            node.prev.next = newNode;
        }

        node.prev = newNode;
    }

    public DNode insertBeforeGivenNode_2(DNode head, int node, int X) {
        DNode newNode = new DNode(X);

        // Case: insert before head
        if (head != null && head.data == node) {
            newNode.next = head;
            head.prev = newNode;
            return newNode;
        }

        DNode current = head;

        // Traverse until current.next holds the value `node`
        while (current != null && current.next != null && current.next.data != node) {
            current = current.next;
        }

        // If node with given value is not found, do nothing
        if (current == null || current.next == null) {
            return head;
        }

        DNode nextNode = current.next;
        current.next = newNode;
        newNode.prev = current;

        newNode.next = nextNode;
        nextNode.prev = newNode;

        return head;
    }
    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        InsertBeforeGivenNode_8 ibn = new InsertBeforeGivenNode_8();

        int[] nums = {1, 2, 6};
        int X = 7;
        int nodeValue = 1;

        // ----- Method 1: insertBeforeGivenNode_1 (with direct node reference) -----
        DNode head1 = dll.convertArrToDLL(nums);
        System.out.println("Original DLL (Method 1):");
        dll.printDLLForward(head1);

        DNode nodeToInsertBefore = head1; // head node has value 1
        ibn.insertBeforeGivenNode_1(nodeToInsertBefore, X);

        // Since nodeToInsertBefore was head, new head is the new node (7)
        head1 = nodeToInsertBefore.prev;

        System.out.println("After Insertion (Method 1 - insertBeforeGivenNode_1):");
        dll.printDLLForward(head1);

        // ----- Method 2: insertBeforeGivenNode_2 (with node value) -----
        DNode head2 = dll.convertArrToDLL(nums);
        System.out.println("Original DLL (Method 2):");
        dll.printDLLForward(head2);

        head2 = ibn.insertBeforeGivenNode_2(head2, nodeValue, X);

        System.out.println("After Insertion (Method 2 - insertBeforeGivenNode_2):");
        dll.printDLLForward(head2);
    }

}
