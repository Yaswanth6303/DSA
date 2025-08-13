package faqHard;

import fundamentalsSingleLL.LinkedList;
import fundamentalsSingleLL.Node;

import java.util.ArrayList;
import java.util.Collections;

public class MergeTwoSortedLists_3 {
    public Node mergeTwoListsBrute(Node head1, Node head2) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        Node current1 = head1;
        Node current2 = head2;

        while (current1 != null) {
            arrayList.add(current1.data);
            current1 = current1.next;
        }

        while (current2 != null) {
            arrayList.add(current2.data);
            current2 = current2.next;
        }

        Collections.sort(arrayList);

        Node dummyNode = new Node(-1);
        Node current = dummyNode;
        for (int i = 0; i < arrayList.size(); i++) {
            current.next = new Node(arrayList.get(i));
            current = current.next;
        }

        return dummyNode.next;
    }
    public Node mergeTwoListsOptimal(Node head1, Node head2) {
        Node dummyNode = new Node(-1);
        Node current = dummyNode;

        while (head1 != null && head2 != null) {
            if (head1.data <= head2.data) {
                current.next = head1;
                head1 = head1.next;
            } else {
                current.next = head2;
                head2 = head2.next;
            }
            current = current.next;
        }

        if (head1 != null) {
            current.next = head1;
        } else {
            current.next = head2;
        }

        return dummyNode.next;
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        // Create first sorted linked list: 1 -> 3 -> 5
        Node head1 = new Node(1);
        head1.next = new Node(3);
        head1.next.next = new Node(5);

        // Create second sorted linked list: 2 -> 4 -> 6
        Node head2 = new Node(2);
        head2.next = new Node(4);
        head2.next.next = new Node(6);

        MergeTwoSortedLists_3 merger = new MergeTwoSortedLists_3();

        System.out.println("List 1:");
        ll.printLinkedList(head1);
        System.out.println("List 2:");
        ll.printLinkedList(head2);

        // Brute force merge
        Node mergedBrute = merger.mergeTwoListsBrute(cloneList(head1), cloneList(head2));
        System.out.println("\nMerged List (Brute Force):");
        ll.printLinkedList(mergedBrute);

        // Optimal merge
        Node mergedOptimal = merger.mergeTwoListsOptimal(cloneList(head1), cloneList(head2));
        System.out.println("\nMerged List (Optimal):");
        ll.printLinkedList(mergedOptimal);
    }

    // Helper method to clone linked list so original remains unchanged
    private static Node cloneList(Node head) {
        if (head == null) return null;
        Node newHead = new Node(head.data);
        Node currentNew = newHead;
        Node currentOld = head.next;

        while (currentOld != null) {
            currentNew.next = new Node(currentOld.data);
            currentNew = currentNew.next;
            currentOld = currentOld.next;
        }
        return newHead;
    }

}
