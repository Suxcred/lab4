package org.example;

class BSTNode {
    int key;
    String value;
    BSTNode left;
    BSTNode right;

    public BSTNode(int key, String value) {
        this.key = key;
        this.value = value;
    }
}

public class BST {
    private BSTNode root;

    public void insert(int key, String value) {
        root = insert2(root, key, value);
    }

    private BSTNode insert2(BSTNode root, int key, String value) {
        if (root == null) {
            return new BSTNode(key, value);
        }
        if (key < root.key) {
            root.left = insert2(root.left, key, value);
        } else if (key > root.key) {
            root.right = insert2(root.right, key, value);
        } else {
            root.value = value;
        }

        return root;
    }
    public int countNodes() {
        return countNodes2(root);
    }
    private int countNodes2(BSTNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + countNodes2(root.left) + countNodes2(root.right);
    }
    public void delete(int key) {
        root = delete2(root, key);
    }

    private BSTNode delete2(BSTNode root, int key) {
        if (root == null) {
            return null;
        }

        if (key < root.key) {
            root.left = delete2(root.left, key);
        } else if (key > root.key) {
            root.right = delete2(root.right, key);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            root.key = delete3(root.right);
            root.right = delete2(root.right, root.key);
        }

        return root;
    }

    private int delete3(BSTNode node) {
        int delete3 = node.key;
        while (node.left != null) {
            delete3 = node.left.key;
            node = node.left;
        }
        return delete3;
    }
    public String search(int key) {
        return search2(root, key);
    }
    private String search2(BSTNode root, int key) {
        if (root == null) {
            return null;
        }
        if (key == root.key) {
            return root.value;
        } else if (key < root.key) {
            return search2(root.left, key);
        } else {
            return search2(root.right, key);
        }
    }

}