import java.util.*;
class RightView{
    static class Node{
        int data;
        Node left,right;
        Node(int data){
            this.data=data;
            this.left=left;
            this.right=right;
        }
    }
    static Node treeBuild(Scanner sc){// function used to build a tree
        System.out.println("Enter elements(use -1 for null):");
        return treeBuildHelper(sc);
    }
    static Node treeBuildHelper(Scanner sc){
        int data=sc.nextInt();
        if(data==-1){
            return null;
        }
        Node root=new Node(data);
        System.out.println("Enter left child of"+data+":");
        root.left=treeBuildHelper(sc);
        System.out.println("Enter right child of"+data+":");
        root.right=treeBuildHelper(sc);
        return root;
    }
    static ArrayList<Integer> rightView(Node node){
        ArrayList<Integer>ans=new ArrayList<>();
        rightView(node,ans,0);
        return ans;
    }
    static void rightView(Node curr,ArrayList<Integer> ans,int currDepth){
        if(curr==null)
            return;
        if(currDepth==ans.size()){// if current level is equal to list size then it means that it is the first element of the current level
            ans.add(curr.data);// by doing soo we add elements which occur for the first time in that level which eventually gives us desired output
        }
        rightView(curr.right,ans,currDepth+1);// discover first right and then left
        rightView(curr.left,ans,currDepth+1);

    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Node root=treeBuild(sc);
        RightView rv=new RightView();
        ArrayList<Integer> ans=rv.rightView(root);
        System.out.println("right view of binary tree:");
        for(Integer num:ans){
            System.out.print(num+" ");
        }
        System.out.println();
        sc.close();
    }
}