import java.util.*;
class Node{
    int data;
    Node next;
    Node(int data){
        this.data=data;
        this.next=null;
    }
}
class Palindrome{
    static Node reversalLinkedList(Node head){
        if(head==null || head.next==null){
            return head;
        }
        Node newHead=reversalLinkedList(head.next);
        Node front=head.next;
        front.next=head;
        head.next=null;
        return newHead;
    }
    static boolean isPalindrome(Node head){
        if(head==null || head.next==null){
            return true;
        }
        Node slow=head;
        Node fast=head;
        while(fast.next!=null && fast.next.next !=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        Node newHead=reversalLinkedList(slow.next);
        Node first=head;
        Node second=newHead;
        while(second!=null){
            if(first.data!=second.data){
                return false;
            }
            first=first.next;
            second=second.next;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Node head = null;
        Node tail = null;

        // Take input for the linked list until the user enters -1
        System.out.println("Enter elements for the linked list (enter -1 to stop):");
        while (true) {
            int value = scanner.nextInt();
            if (value == -1) {
                break;
            }
            Node newNode = new Node(value);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        Palindrome solution = new Palindrome();
        boolean result = solution.isPalindrome(head);

        if (result) {
            System.out.println("The linked list is a palindrome.");
        } else {
            System.out.println("The linked list is not a palindrome.");
        }
    }
}