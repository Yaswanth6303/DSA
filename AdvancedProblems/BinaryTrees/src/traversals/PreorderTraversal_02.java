package traversals;

import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

/** Recursive
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

/** Iterative
 * Time Complexity: O(n)
 * Space Complexity: O(h)
 */
public class PreorderTraversal_02 {
    public void preorderTraversal(Node root, List<Integer> result) {
        if (root == null) return;

        result.add(root.data);
        preorderTraversal(root.left, result);
        preorderTraversal(root.right, result);
    }

    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        preorderTraversal(root, result);
        return result;
    }

    public List<Integer> preorderIterative(Node root) {
        Stack<Node> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                result.add(root.data);
                root = root.left;
            }

            root = stack.pop();
            root = root.right;
        }

        return result;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        PreorderTraversal_02 sol = new PreorderTraversal_02();
        List<Integer> result = sol.preorder(root);

        System.out.print("Preorder Traversal (Recursive): ");
        for (int val : result) {
            System.out.print(val + " ");
        }
        System.out.println();

        PreorderTraversal_02 sol2 = new PreorderTraversal_02();
        List<Integer> result2 = sol2.preorderIterative(root);

        System.out.print("Preorder Traversal (Iterative): ");
        for (int val : result2) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}
