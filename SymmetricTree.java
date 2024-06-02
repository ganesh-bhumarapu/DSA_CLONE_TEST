import java.util.*;

class SymmetricTree {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static Node treeBuild(Scanner sc) {
        System.out.println("Enter root element (use -1 for null):");
        return treeBuildHelper(sc);
    }

    static Node treeBuildHelper(Scanner sc) {
        int data = sc.nextInt();
        if (data == -1) {
            return null;
        }
        Node root = new Node(data);
        System.out.println("Enter left child of " + data + ":");
        root.left = treeBuildHelper(sc);
        System.out.println("Enter right child of " + data + ":");
        root.right = treeBuildHelper(sc);
        return root;
    }

    public static boolean isSymmetric(Node root) {
        return root == null || isSymmetricHelper(root.left, root.right);// if root is null then it means that there is no tree if root present then check for its left and right
    }

    static boolean isSymmetricHelper(Node left, Node right) {
        if (left == null || right == null) {
            return left == right;
        }
        if (left.data != right.data) {
            return false;
        }
        return isSymmetricHelper(left.left, right.right) && isSymmetricHelper(left.right, right.left);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node root = treeBuild(sc);
        SymmetricTree st = new SymmetricTree();
        System.out.println("Is the tree symmetric? " + st.isSymmetric(root));
        sc.close();
    }
}
