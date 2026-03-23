package traversals;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/** Recursive
 * Time Complexity: O(n)
 * Space Complexity: O(h)
 */

/** Iterative
 * Time Complexity: O(n)
 * Space Complexity: O(h)
 */
// Left Root Right
public class InorderTraversal_01 {
    public void inorderTraversal(Node root, List<Integer> array) {
        if (root == null) return;

        inorderTraversal(root.left, array);
        array.add(root.data);
        inorderTraversal(root.right, array);
    }

    public List<Integer> inorderRecursive(Node root) {
        List<Integer> array = new ArrayList<>();
        inorderTraversal(root, array);
        return array;
    }

    public List<Integer> inorderIterative(Node root) {
        Stack<Node> stack = new Stack<>();
        List<Integer> array = new ArrayList<>();

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            array.add(root.data);
            root = root.right;
        }

        return array;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        InorderTraversal_01 sol = new InorderTraversal_01();
        List<Integer> result = sol.inorderRecursive(root);

        InorderTraversal_01 sol2 = new InorderTraversal_01();
        List<Integer> result2 = sol2.inorderIterative(root);

        System.out.println("Inorder Traversal (Recursive): ");
        for (int val : result) {
            System.out.print(val + " ");
        }
        System.out.println();

        System.out.println("Inorder Traversal (Iterative): ");
        for (int val : result2) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}
