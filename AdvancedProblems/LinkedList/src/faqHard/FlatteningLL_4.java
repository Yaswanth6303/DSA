package faqHard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Node {
    int data;
    Node next; // Horizontal pointer
    Node child; // Vertical pointer

    Node(int data, Node next) {
        this.data = data;
        this.next = next;
        this.child = next;
    }

    Node(int data) {
        this.data = data;
        this.next = null;
        this.child = null;
    }

    Node() {
        this.data = 0;
        this.next = null;
        this.child = null;
    }
}

public class FlatteningLL_4 {

    // Convert a sorted list of integers to a simple linked list using 'child'
    // pointers
    public Node convertArrToLL(List<Integer> arrayList) {
        int n = arrayList.size();

        if (n == 0)
            return null;

        Node head = new Node(arrayList.get(0));
        Node mover = head;

        for (int i = 1; i < n; i++) {
            Node newNode = new Node(arrayList.get(i));
            mover.child = newNode; // child pointer for vertical list
            mover = newNode;
        }

        return head;
    }

    // Brute-force flattening
    public Node flattendLinkedListBrute(Node head) {
        List<Integer> arrayList = new ArrayList<>();

        while (head != null) {
            Node current = head;
            while (current != null) {
                arrayList.add(current.data);
                current = current.child;
            }
            head = head.next;
        }

        Collections.sort(arrayList);
        return convertArrToLL(arrayList);
    }

    // Merge two sorted child lists
    public Node merge2Lists(Node listA, Node listB) {
        Node dummyNode = new Node(-1);
        Node current = dummyNode;

        while (listA != null && listB != null) {
            if (listA.data < listB.data) {
                current.child = listA;
                listA = listA.child;
            } else {
                current.child = listB;
                listB = listB.child;
            }
            current = current.child;
            current.next = null; // Remove horizontal links
        }

        if (listA != null)
            current.child = listA;
        if (listB != null)
            current.child = listB;

        return dummyNode.child;
    }

    // Optimal flattening (recursive merge)
    public Node flattendLinkedListOptimal(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node mergedHead = flattendLinkedListOptimal(head.next);
        return merge2Lists(head, mergedHead);
    }

    // Utility to print using child pointers
    public void printChildList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.child;
        }
        System.out.println("null");
    }

    // Build example multi-level linked list
    public Node buildExampleList() {
        Node head = new Node(5);
        head.child = new Node(7);
        head.child.child = new Node(8);
        head.child.child.child = new Node(30);

        head.next = new Node(10);
        head.next.child = new Node(20);

        head.next.next = new Node(19);
        head.next.next.child = new Node(22);
        head.next.next.child.child = new Node(50);

        head.next.next.next = new Node(28);
        head.next.next.next.child = new Node(35);
        head.next.next.next.child.child = new Node(40);
        head.next.next.next.child.child.child = new Node(45);

        return head;
    }

    public static void main(String[] args) {
        FlatteningLL_4 obj = new FlatteningLL_4();

        // Build example list
        Node head = obj.buildExampleList();

        System.out.println("Brute force flatten:");
        Node brute = obj.flattendLinkedListBrute(head);
        obj.printChildList(brute);

        // Rebuild list because brute changes the structure
        head = obj.buildExampleList();

        System.out.println("Optimal flatten:");
        Node optimal = obj.flattendLinkedListOptimal(head);
        obj.printChildList(optimal);
    }
}
