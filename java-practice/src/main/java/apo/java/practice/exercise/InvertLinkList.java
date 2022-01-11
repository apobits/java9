package apo.java.practice.exercise;

public class InvertLinkList {

    public static void main(String[] args) {
        var node = new Node(1, new Node(2, new Node(3, new Node(4, null))));
        invertInPlace(node);
    }

    // 1->2->3->4 4->3->2->1
    public static void invertInPlace(Node node) {
        Node prev = null;
        var next = node.next;
        while (next != null) {
            var temp = next;
            node.next = prev;
            prev = node;
            next = temp.next;
            temp.next = node;
            node = temp;
        }
    }
}

class Node {
    int data;
    Node next;

    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }

    @Override
    public String toString() {
        return data + "";
    }
}