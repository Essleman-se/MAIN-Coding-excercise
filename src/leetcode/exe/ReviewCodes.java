package leetcode.exe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReviewCodes {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList();
        List<Integer> l1 = new ArrayList(Arrays.asList(1));
        List<Integer> l2 = new ArrayList(Arrays.asList(1,1));

        list.add(l1);
        list.add(l2);

        int size = list.size();

        while(size < numRows){
            List<Integer> l = list.get(size-1);
            List<Integer> newList = new ArrayList();
            int j = 0;
            for(int i=0; i < (size+1); i++){
                if(i != 0 && i != size){
                    int n = l.get(j) + l.get(j+1);
                    newList.add(n);
                    j++;
                }else{
                    newList.add(1);
                }
            }

            list.add(newList);
            size = list.size();
        }


        return list;
    }

    public static boolean validPalaindromeII(String s){

        int i = 0;
        int j = s.length()-1;

        while (i < j){
            if(s.charAt(i) != s.charAt(j)){
                return isPalindromeII(s, i+1, j) || isPalindromeII(s, i, j-1);
            }

            i++;
            j--;
        }

        return true;
    }

    private static boolean isPalindromeII(String s, int i, int j) {

        while (i < j){
            if (s.charAt(i++) != s.charAt(j--)){
                return false;
            }

        }

        return true;
    }

    public static class Node{
        int val;
        Node next;

        public Node(int val){
            this.val = val;
        }

        public Node(int val, Node next){
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString(){
            return "Node{" + "val" + val + ", next =" + next + "}";
        }

    }

    public static void display(Node head){
        Node current  = head;

        while (current != null){
            System.out.print(current.val + "--->");
            current = current.next;
        }
        System.out.println("null");

    }

    public static Node reverseSinglyLinkedList(Node head){

        Node current = head;
        Node previous = null;
        Node next = null;

        while (current != null){
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        return previous;
    }

    public static boolean isPalindrome(Node fNode) {
        Node current = fNode;
        display(fNode);
        Node rHead = reverse(fNode);
        System.out.println("After Revers");
        display(rHead);

        while(current != null){
            int val1 = current.val;
            int rVal = rHead.val;
            System.out.println(val1);
            System.out.println(rVal);
            if(val1 != rVal){
                return false;
            }

            current = current.next;
            rHead = rHead.next;
        }

        return true;
    }

    public static Node reverse(Node head){
        Node current = head;
        Node temp = null;
        Node prev = null;

        while(current != null){
            temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }

        return prev;
    }

    public static boolean isPalindromeNum(int x){
        int num = x;
        int result = 0;
        while(num != 0){
            result = 10 * result + num%10;
            num = num/10;
        }

        if(result != x) return false;

        return true;
    }
    public static void main(String[] args){

        //System.out.println(generate(5));
        //System.out.println(validPalaindromeII("abccbda"));


        //Node head = new ReviewCodes().new Node(10);
        Node head = new Node(1);
        Node second = new Node(1);
        Node third = new Node(2);
        Node fourth = new Node(1);

        //Join or link the node
        head.next = second;
        second.next = third;
        third.next = fourth;

        //reverseSinglyLinkedList(head);
        System.out.println(isPalindromeNum(10));


        //Befor revers
//        System.out.println("Before revers");
//        display(head);
//        Node reversedHead = reverseSinglyLinkedList(head);
//        System.out.println("After revers");
//        display(reversedHead);

    }
}
