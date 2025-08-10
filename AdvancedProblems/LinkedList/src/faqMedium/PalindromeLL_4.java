package faqMedium;

import fundamentalsSingleLL.LinkedList;
import fundamentalsSingleLL.Node;

import java.util.Stack;

public class PalindromeLL_4 {
    public boolean isPalindromeBrute(Node head) {
        Stack<Integer> stack = new Stack<>();

        Node current = head;

        while (current != null) {
            stack.push(current.data);
            current = current.next;
        }

        current = head;
        while (current != null) {
            if (current.data != stack.pop()) {
                return false;
            }

            current = current.next;
        }

        return true;
    }
    public Node reverseLL(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node newHead = reverseLL(head.next);

        Node front = head.next;
        front.next = head;
        head.next = null;

        return newHead;
    }
    public boolean isPalindromeOptimal(Node head) {
        if (head == null || head.next == null) {
            return true;
        }

        Node slowPointer = head;
        Node fastPointer = head;

        while (fastPointer.next != null && fastPointer.next.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }

        Node newHead = reverseLL(slowPointer.next);
        Node first = head;
        Node second = newHead;

        while (second != null) {
            if (first.data != second.data) {
                reverseLL(newHead);
                return false;
            }
            first = first.next;
            second = second.next;
        }

        reverseLL(newHead);

        return true;
    }
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        PalindromeLL_4 palindrome = new PalindromeLL_4();

        Node linkedList = new Node(1, new Node(2, new Node(3, new Node(2, new Node(1)))));
        ll.printLinkedList(linkedList);
        boolean isPalindromeBruteForce = palindrome.isPalindromeBrute(linkedList);
        System.out.println("Palindrome(Brute): " + isPalindromeBruteForce);

        Node linkedList1 = new Node(1, new Node(2, new Node(3, new Node(2, new Node(1)))));
        ll.printLinkedList(linkedList1);
        boolean isPalindromeOptimalApproach = palindrome.isPalindromeOptimal(linkedList1);
        System.out.println("Palindrome(Optimal): " + isPalindromeOptimalApproach);
    }
}
