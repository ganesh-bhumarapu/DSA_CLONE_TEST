import java.util.*;
class Node{
    int data;
    Node left,right;
    Node(int item){
        this.data=item;
        this.left=null;
        this.right=null;
    }
}
class CheckForBST {
    static boolean isBST(Node root){
        if(root == null){
            return true;
        }
        Queue<Node> q=new LinkedList<>();
        Queue<Integer> minQueue=new LinkedList<>();
        Queue<Integer> maxQueue=new LinkedList<>();
        q.add(root);
        minQueue.add(Integer.MIN_VALUE);
        maxQueue.add(Integer.MAX_VALUE);
        while(!q.isEmpty()){
            Node current=q.poll();
            int min=minQueue.poll();
            int max=maxQueue.poll();
            if(current.data <= min || current.data >= max){
                return false;
            }
            if(current.left != null){
                q.add(current.left);
                minQueue.add(min);
                maxQueue.add(current.data);
            }
            if(current.right != null){
                q.add(current.right);
                minQueue.add(current.data);
                maxQueue.add(max);
            }
        }
        return true;
    }
    static Node treeBuild(Scanner sc) {
        System.out.println("enter the root element");
        return treeBuilderHelper(sc);
    }

    static Node treeBuilderHelper(Scanner sc) {
        int data = sc.nextInt();
        if (data == -1) {
            return null;
        }
        Node root = new Node(data);
        System.out.println("enter the left chiild of " + data + " :");
        root.left = treeBuilderHelper(sc);
        System.out.println("enter the right child of " + data + " :");
        root.right = treeBuilderHelper(sc);
        return root;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node root = treeBuild(sc);
        if (isBST(root)) {
            System.out.println("The tree is a BST");
        } else {
            System.out.println("The tree is not a BST");
        }
    }
}