import java.util.*;

class Node {
    int data;
    Node left, right;
    Node(int item) {
        data = item;
        left = right = null;
    }
}
class MaximumWidthOfTree {
    int getMaxWidth(Node root) {
        if (root == null) return 0;

        int maxWidth = 0;
        Queue<Node> q = new LinkedList<>();

        q.add(root);

        while (!q.isEmpty()) {
            int count = q.size();
            maxWidth = Math.max(maxWidth, count);

            while (count-- > 0) {
                Node temp = q.remove();// take the temp as the first entry element
                if (temp.left != null) {// if it has left node add it to queue as a part of entering the elements of next following level nodes
                    q.add(temp.left);
                }
                if (temp.right != null) {// similarly for the right node also
                    q.add(temp.right);
                }
            }
        }
        return maxWidth;
    }

    // Method to build the binary tree
    static Node treeBuild(Scanner sc) {
        System.out.println("Enter the root element:");
        return treeBuilderHelper(sc);
    }

    // Helper method to recursively build the binary tree
    static Node treeBuilderHelper(Scanner sc) {
        int data = sc.nextInt();
        if (data == -1) {
            return null;
        }
        Node root = new Node(data);
        System.out.println("Enter the left child of " + data + ":");
        root.left = treeBuilderHelper(sc);
        System.out.println("Enter the right child of " + data + ":");
        root.right = treeBuilderHelper(sc);
        return root;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node root = treeBuild(sc);
        sc.close(); // Close the Scanner after use

        MaximumWidthOfTree mx = new MaximumWidthOfTree();
        System.out.println("Maximum width of the tree is: " + mx.getMaxWidth(root));
    }
}
