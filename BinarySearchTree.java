
class BinarySearchTreeNode {

    private int data;
    private BinarySearchTreeNode left;
    private BinarySearchTreeNode right;

    public BinarySearchTreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public int getData() {
        return data;
    }

    public void setData(int d) {
        data = d;
    }

    public BinarySearchTreeNode getLeft() {
        return left;
    }

    public BinarySearchTreeNode getRight() {
        return right;
    }

    public void setLeft(BinarySearchTreeNode p) {
        left = p;
    }

    public void setRight(BinarySearchTreeNode p) {
        right = p;
    }
}

public class BinarySearchTree {

    private BinarySearchTreeNode root;

    public BinarySearchTree() {
        this.root = null;
    }

    public void addNode(int data) {
        BinarySearchTreeNode p = root, prev = null;
        if (root == null) {
            root = new BinarySearchTreeNode(data);
            return;
        }
        while (p != null) {
            prev = p;
            if (data < p.getData()) {
                p = p.getLeft();
            } else {
                p = p.getRight();
            }
        }
        if (data < prev.getData()) {
            prev.setLeft(new BinarySearchTreeNode(data));
        } else {
            prev.setRight(new BinarySearchTreeNode(data));
        }
    }

    public void inorder() {
        inorder(root);
    }

    public void inorder(BinarySearchTreeNode v) {
        if (v.getLeft() != null) {
            inorder(v.getLeft());
        }
        System.out.print(v.getData() + " ");
        if (v.getRight() != null) {
            inorder(v.getRight());
        }
    }

    public void deleteNode(int data) {
        BinarySearchTreeNode p = root, p2 = null;
        while (p != null) {
            if (data < p.getData()) {
                p2 = p;
                p = p.getLeft();
            } else if (data > p.getData()) {
                p2 = p;
                p = p.getRight();
            } else {
                break;
            }
        }
        boolean left = p.getLeft() != null;
        boolean right = p.getRight() != null;
        if (!left && !right) {
            if (p2.getLeft() != null && p2.getLeft().equals(p)) {
                p2.setLeft(null);
            } else {
                p2.setRight(null);
            }
        } else if (left && !right) {
            if (p2.getLeft() != null && p2.getLeft().equals(p)) {
                p2.setLeft(p.getLeft());
            } else {
                p2.setRight(p.getLeft());
            }
        } else if (!left && right) {
            if (p2.getLeft() != null && p2.getLeft().equals(p)) {
                p2.setLeft(p.getRight());
            } else {
                p2.setRight(p.getRight());
            }
        } else {
            p2 = p.getLeft();
            while (p2.getRight() != null) {
                p2 = p2.getRight();
            }
            deleteNode(p2.getData());
            p.setData(p2.getData());
        }
    }
}
