package com.ekov;

import java.util.Objects;

public class Tree {
    private Node root;

    public Tree() {
        this.root = null;
    }

    public void insertInto(int value) {
        Node temp = this.root;
        Node newRoot = new Node(value);
        if (this.root == null) {
            this.root = newRoot;
            return;
        }
        while (true) {
            if (value == temp.getValue()) break;
            if (value < temp.getValue()) {
                if (temp.getLeft() == null) {
                    temp.setLeft(newRoot);
                    break;
                }
                temp = temp.getLeft();
            }
            if (value > temp.getValue()) {
                if (temp.getRight() == null) {
                    temp.setRight(newRoot);
                    break;
                }
                temp = temp.getRight();
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
        while (head.getValue() != target) {
            head = target > head.getValue() ? head.getRight() : head.getLeft();
        }
        return head;
    }

    public void deleteElement(int target) {
        root = deleteElement(root, target);
    }

    public Node deleteElement(Node head, int target) {
        if (head == null) return null;
        if (target < head.getValue()) {
            head.setLeft(deleteElement(head.getLeft(), target));
        } else if (target > head.getValue()) {
            head.setRight(deleteElement(head.getRight(), target));
        } else if (head.getLeft() != null && head.getRight() != null) {
            head.setValue(min(head.getRight()));
            head.setRight(deleteElement(head.getRight(), head.getValue()));
        } else {
            if (head.getLeft() != null) {
                head = head.getLeft();
            } else if (head.getRight() != null) {
                head = head.getRight();
            } else {
                head = null;
            }
        }
        return head;
    }

    public int min(Node head) {
        while (head.getLeft() != null) {
            head = head.getLeft();
        }
        return head.getValue();
    }

    public int getCount(int value) {
        int count = 0;
        Node head = findValue(value);
        if (head != root) count++;
        if (head.getRight() != null) count++;
        if (head.getLeft() != null) count++;
        return count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tree tree = (Tree) o;
        return Objects.equals(root, tree.root);
    }
    
    public Node getRoot() {
        return root;
    }

    static class Node {
        private int value;
        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return value == node.value && Objects.equals(left, node.left) && Objects.equals(right, node.right);
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }
}
