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
 * Space Complexity: O(n)
 */

public class PostorderTraversal_03 {
    public void postorderTraversal(Node root, List<Integer> result) {
        if (root == null) return;

        postorderTraversal(root.left, result);
        postorderTraversal(root.right, result);
        result.add(root.data);
    }

    public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<>();
        postorderTraversal(root, result);
        return result;
    }

    public List<Integer> postorderIterative(Node root) {
        Stack<Node> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            root = stack.pop();
            result.addFirst(root.data);
            if (root.left != null) stack.push(root.left);
            if (root.right != null) stack.push(root.right);
        }

        return result;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        PostorderTraversal_03 sol = new PostorderTraversal_03();
        
        System.out.print("Postorder Traversal (Recursive): ");
        List<Integer> resultRecursive = sol.postorder(root);
        for (int val : resultRecursive) {
            System.out.print(val + " ");
        }
        System.out.println();

        System.out.print("Postorder Traversal (Iterative): ");
        List<Integer> resultIterative = sol.postorderIterative(root);
        for (int val : resultIterative) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}
