package faqHard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import fundamentalsSingleLL.Node;
import fundamentalsSingleLL.LinkedList;

/**
 * SortLL_5
 */
public class SortLL_5 {
    public Node convertArrayToLL(List<Integer> arrayList) {
        int n = arrayList.size();

        Node head = new Node(arrayList.get(0));
        Node current = head;

        for (int i = 1; i < n; i++) {
            Node newNode = new Node(arrayList.get(i));
            current.next = newNode;
            current = newNode;
        }

        return head;
    }

    public Node sortLLBrute(Node head) {
        List<Integer> arrayList = new ArrayList<>();

        Node current = head;
        while (current != null) {
            arrayList.add(current.data);
            current = current.next;
        }

        Collections.sort(arrayList);

        return convertArrayToLL(arrayList);
    }

    public Node merge2Lists(Node listA, Node listB) {
        Node dummyNode = new Node(-1);
        Node current = dummyNode;

        while (listA != null && listB != null) {
            if (listA.data < listB.data) {
                current.next = listA;
                listA = listA.next;
            } else {
                current.next = listB;
                listB = listB.next;
            }

            current = current.next;
        }

        if (listA != null) {
            current.next = listA;
        } else {
            current.next = listB;
        }

        return dummyNode.next;
    }

    public Node findMiddle(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node slowPointer = head;
        Node fastPointer = head.next; // To return first middle place the fast pointer at fast.next

        while (fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }

        return slowPointer;
    }

    public Node sortLLOptimal(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node middle = findMiddle(head);

        Node left = head;
        Node right = middle.next;
        middle.next = null;

        left = sortLLOptimal(left);
        right = sortLLOptimal(right);

        return merge2Lists(left, right);
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        SortLL_5 sl = new SortLL_5();

        Node l1 = new Node(3, new Node(4, new Node(2, new Node(1, new Node(5)))));
        System.out.println("Original LL: ");
        ll.printLinkedList(l1);

        System.out.println("Sorted LL Brute: ");
        Node headBrute = sl.sortLLBrute(l1);
        ll.printLinkedList(headBrute);

        System.out.println("Sorted LL Optimal: ");
        Node headOptimal = sl.sortLLOptimal(l1);
        ll.printLinkedList(headOptimal);
    }
}
