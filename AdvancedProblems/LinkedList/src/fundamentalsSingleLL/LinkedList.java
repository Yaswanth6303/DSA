package fundamentalsSingleLL;

public class LinkedList {
    // Convert array to linked list
    Node convertArrToLL(int[] nums) {
        if (nums.length == 0) return null;

        Node head = new Node(nums[0]);
        Node mover = head;

        for (int i = 1; i < nums.length; i++) {
            Node temp = new Node(nums[i]);
            mover.next = temp;
            mover = temp;
        }

        return head;
    }

    // Print linked list
    void printLinkedList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        int[] nums = {2, 4, 6, 8};

        LinkedList ll = new LinkedList();
        Node head = ll.convertArrToLL(nums);
        System.out.print("First Element in the LL: ");
        System.out.println(head.data);

        System.out.print("Second Element in the LL: ");
        System.out.println(head.next.data);

        System.out.println("Linked List:");
        ll.printLinkedList(head);
    }
}
