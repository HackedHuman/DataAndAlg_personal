public class BST {
    private BSTNode root;

    public void insert(int key, String value) {
        root = insertRec(root, key, value);
    }

    private BSTNode insertRec(BSTNode root, int key, String value) {
        if (root == null) {
            return new BSTNode(key, value);
        }

        if (key < root.key) {
            root.left = insertRec(root.left, key, value);
        } else if (key > root.key) {
            root.right = insertRec(root.right, key, value);
        } else {
            root.value = value; // Key already exists, update the value
        }

        return root;
    }

    public void delete(int key) {
        root = deleteRec(root, key);
    }

    private BSTNode deleteRec(BSTNode root, int key) {
        if (root == null) {
            return null;
        }

        if (key < root.key) {
            root.left = deleteRec(root.left, key);
        } else if (key > root.key) {
            root.right = deleteRec(root.right, key);
        } else {
            // Node with only one child or no child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // Node with two children, get the inorder successor (smallest in the right subtree)
            root.key = minValue(root.right);

            // Delete the inorder successor
            root.right = deleteRec(root.right, root.key);
        }

        return root;
    }

    private int minValue(BSTNode root) {
        int minValue = root.key;
        while (root.left != null) {
            minValue = root.left.key;
            root = root.left;
        }
        return minValue;
    }

    public String search(int key) {
        BSTNode result = searchRec(root, key);
        return (result != null) ? result.value : null;
    }

    private BSTNode searchRec(BSTNode root, int key) {
        if (root == null || root.key == key) {
            return root;
        }

        if (key < root.key) {
            return searchRec(root.left, key);
        }

        return searchRec(root.right, key);
    }

    public void traverse() {
        System.out.println("BST Inorder Traversal:");
        inorderTraversal(root);
        System.out.println();
    }

    public void traverse(BSTVisitor visitor) {
        inorderTraversal(root, visitor);
    }

    private void inorderTraversal(BSTNode root) {
        if (root != null) {
            inorderTraversal(root.left);
            System.out.print("(" + root.key + ", " + root.value + ") ");
            inorderTraversal(root.right);
        }
    }

    private void inorderTraversal(BSTNode root, BSTVisitor visitor) {
        if (root != null) {
            inorderTraversal(root.left, visitor);
            visitor.visit(root);
            inorderTraversal(root.right, visitor);
        }
    }
}