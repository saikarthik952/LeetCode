package leetcode.seven;

import java.util.LinkedList;
import java.util.Queue;

public class PopulateRightPointer {
    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public static void main(String[] args) {
    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        connect(root);
    }
    public static void connect(Node root) {
        if (root == null) return;
        Node dummy = new Node(0);
        Node p = dummy;
        Node x = dummy;
        Node head = root;
        while (head != null) { //if the head of the traverse layer is not null, then traverse that layer...
            Node node = head;
            while (node != null) {
                if (node.left != null) {
                    p.next = node.left;
                    p = p.next;
                }
                if (node.right != null) {
                    p.next = node.right;
                    p = p.next;
                }
                node = node.next;
            }
            //after traversed to the end of current layer, move to the next layer
            head = dummy.next;
            dummy.next = null;
            p = dummy;
        }
    }

}
