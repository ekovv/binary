package com.ekov;

import java.util.Objects;

public class Tree {

//    private int value;
//    private Tree left;
//    private Tree right;
    private Node root;

    private static class Node {
        private int value;
        private Node left;
        private Node right;

    }

    public Tree() {
        this.root = null;
    }

    public void insertInto(int value) {
        Node temp = this.root;
        Node newRoot = new Node();
        newRoot.value = value;
        if (this.root == null) {
            this.root = newRoot;
            return;
        }
        while (true) {
            if (value == temp.value) break;
            if (value < temp.value ) {
                if (temp.left == null) {
                    temp.left = newRoot;
                    break;
                }
                temp = temp.left;
            }
            if (value > temp.value) {
                if (temp.right == null) {
                    temp.right = newRoot;
                    break;
                }
                temp = temp.right;
            }
        }
    }


    public void insertAll(int... values) {
        for (int value: values) {
            insertInto(value);
        }

    }


    public Node findValue(int target) {
        Node head = this.root;
        while (head.value != target) {
            head = target > head.value ? head.right : head.left;
        }
        return head;
    }


    public Node deleteElement(Node head, int target) {
        if (head == null) return null;
        if (target < head.value) {
            head.left = deleteElement(head.left, target);
        } else if (target > head.value) {
            head.right = deleteElement(head.right, target);
        } else if (head.left != null && head.right != null) {
            head.value = min(head.right);
            head.right = deleteElement(head.right, head.value);
        } else {
            if (head.left != null) {
                head = head.left;
            } else if (head.right != null) {
                head = head.right;
            } else {
                head = null;
            }
        }
        return head;
    }


    public int min(Node head) {
        while (head.left != null) {
            head = head.left;
        }
        return head.value;
    }


    public int getCount(int value) {
        int count = 0;
        Node head = findValue(value);
        if (head != root) count++;
        if (head.right != null) count++;
        if (head.left != null) count++;
        return count;
    }
    @Override
    public String toString() {
        return "Tree{" +
                "value=" + value +
                ", left=" + left +
                ", right=" + right +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tree tree = (Tree) o;
        return value == tree.value && Objects.equals(left, tree.left) && Objects.equals(right, tree.right);
    }


    public int getValue() {
        return value;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public Tree getRoot() {
        return root;
    }
}
