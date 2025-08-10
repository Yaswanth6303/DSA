package faqMedium;

import fundamentalsSingleLL.Node;

import java.util.HashSet;

public class FindIntersectionPoint_4 {
    public Node getIntersectionNodeBrute(Node headA, Node headB) {
        HashSet<Node> nodeHashSet = new HashSet<>();

        while (headA != null) {
            nodeHashSet.add(headA);
            headA = headA.next;
        }

        while (headB != null) {
            if (nodeHashSet.contains(headB)) {
                return headB;
            }

            headB = headB.next;
        }

        return null;
    }

    private Node collisionPoint(Node smallerListHead, Node longerListHead, int length) {
        Node currentA = smallerListHead;
        Node currentB = longerListHead;

        for (int i = 0; i < length; i++) {
            currentB = currentB.next;
        }

        while (currentA != currentB) {
            currentA = currentA.next;
            currentB = currentB.next;
        }

        return currentA;
    }

    public Node getIntersectionNodeBetter(Node headA, Node headB) {
        Node currentA = headA;
        Node currentB = headB;

        int n1 = 0;
        int n2 = 0;

        while (currentA != null) {
            currentA = currentA.next;
            n1++;
        }

        while (currentB != null) {
            currentB = currentB.next;
            n2++;
        }

        if (n1 < n2) {
            return collisionPoint(headA, headB, n2 - n1);
        }

        return collisionPoint(headB, headA, n1 - n2);
    }

    public Node getIntersectionNodeOptimal(Node headA, Node headB) {
        if (headA == null && headB == null) return null;

        Node pointer1 = headA;
        Node pointer2 = headB;

        while (pointer1 != pointer2) {
            pointer1 = pointer1.next;
            pointer2 = pointer2.next;

            if (pointer1 == pointer2) return pointer1;

            if (pointer1 == null) pointer1 = headB;
            if (pointer2 == null) pointer2 = headA;
        }

        return pointer1;
    }

    public static void main(String[] args) {
        // Create first linked list: 1 -> 2 -> 3 -> 4 -> 5
        Node headA = new Node(1);
        headA.next = new Node(2);
        headA.next.next = new Node(3);

        // Create second linked list: 9 -> 10 -> 4 -> 5
        Node headB = new Node(9);
        headB.next = new Node(10);

        // Common part: 4 -> 5
        Node common = new Node(4);
        common.next = new Node(5);

        // Link the common part to both lists
        headA.next.next.next = common;
        headB.next.next = common;

        FindIntersectionPoint_4 finder = new FindIntersectionPoint_4();

        // Test brute force method
        Node intersectionBrute = finder.getIntersectionNodeBrute(headA, headB);
        if (intersectionBrute != null) {
            System.out.println("Brute Force Intersection at Node: " + intersectionBrute.data);
        } else {
            System.out.println("No Intersection (Brute Force)");
        }

        // Test better method
        Node intersectionBetter = finder.getIntersectionNodeBetter(headA, headB);
        if (intersectionBetter != null) {
            System.out.println("Better Method Intersection at Node: " + intersectionBetter.data);
        } else {
            System.out.println("No Intersection (Better Method)");
        }

        // Test optimal method
        Node intersectionOptimal = finder.getIntersectionNodeOptimal(headA, headB);
        if (intersectionOptimal != null) {
            System.out.println("Optimal Method Intersection at Node: " + intersectionOptimal.data);
        } else {
            System.out.println("No Intersection (Optimal Method)");
        }
    }
}
