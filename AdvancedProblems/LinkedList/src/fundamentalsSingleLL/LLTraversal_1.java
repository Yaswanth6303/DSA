package fundamentalsSingleLL;

import java.util.ArrayList;
import java.util.List;

public class LLTraversal_1 {

    // Traverses a linked list and returns list of elements
    public List<Integer> llTraversal(Node head) {
        Node current = head;
        List<Integer> result = new ArrayList<>();

        while (current != null) {
            result.add(current.data);
            current = current.next;
        }
        result.add(null); // Optional: to match your print format
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {12, 23, 24, 28};

        // Step 1: Create LinkedList object to use convertArrToLL
        LinkedList ll = new LinkedList();

        // Step 2: Convert array to linked list
        Node head = ll.convertArrToLL(nums);

        // Step 3: Traverse linked list
        LLTraversal_1 lt = new LLTraversal_1();
        List<Integer> result = lt.llTraversal(head);

        // Step 4: Print the result
        System.out.println("Linked List: ");

        for(int i = 0; i < result.size(); i++) {
            if (i == result.size() - 1) {
                System.out.print(result.get(i));
                break;
            }

            System.out.print(result.get(i) + " -> ");
        }
        System.out.println();
    }
}
