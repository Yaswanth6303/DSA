package fundamentalsDoublyLL;

public class DNode {
    int data;
    DNode next;
    DNode prev;

    public DNode(int data, DNode next, DNode prev) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }

    public DNode(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    public DNode() {
        this.data = 0;
        this.next = null;
        this.prev = null;
    }
}
