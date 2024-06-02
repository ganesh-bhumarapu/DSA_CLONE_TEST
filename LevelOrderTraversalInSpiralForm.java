import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int item) {
        this.data = item;
        this.left = null;
        this.right = null;
    }
}

class LevelOrderTraversalInSpiralForm {
    static Node treeBuild(Scanner sc) {
        System.out.println("Enter the root value:");
        return treeBuildHelper(sc);
    }

    static Node treeBuildHelper(Scanner sc) {
        int data = sc.nextInt();
        if (data == -1) {
            return null;
        }
        Node root = new Node(data);
        System.out.println("Enter the left child of " + data + " (enter -1 for no child):");
        root.left = treeBuildHelper(sc);
        System.out.println("Enter the right child of " + data + " (enter -1 for no child):");
        root.right = treeBuildHelper(sc);
        return root;
    }

    static ArrayList<Integer> findSpiral(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root.data);
        boolean leftToRight = true;
        while (!q.isEmpty()) {
            int size = q.size();
            ArrayList<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node current = q.poll();
                level.add(current.data);
                if (current.left != null) {
                    q.add(current.left);
                }
                if (current.right != null) {
                    q.add(current.right);
                }
            }
            if (leftToRight) {
                Collections.reverse(level);
            }
            ans.addAll(level);
            leftToRight = !leftToRight;
        }
        return ans;

    }
}
