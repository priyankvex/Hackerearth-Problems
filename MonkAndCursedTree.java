import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by priyank on 15/3/17.
 */
public class MonkAndCursedTree {

    private static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
        }
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Node root = null;
        for (int i = 0 ; i < n; i++){
            root = insertBst(root, in.nextInt());
        }
        int x = in.nextInt();
        int y = in.nextInt();

        //inorder(root);

        findMax(root, x, y);

    }

    private static void findMax(Node root, int x, int y){

        while (root.data < x && root.data < y || root.data > x && root.data > y){
            if (root.data < x){
                root = root.right;
            }
            else{
                root = root.left;
            }
        }

        Stack<Node> stack = new Stack<>();
        findValuePath(root, x, stack);
        findValuePath(root, y, stack);

        //System.out.print("\n");

        int max = stack.pop().data;

        while (!stack.isEmpty()){
            Node temp = stack.pop();
            if (temp.data > max){
                max = temp.data;
            }
        }

        System.out.println(max);
    }

    private static void findValuePath(Node root, int value, Stack<Node> stack){
        if (root == null){
            return;
        }
        stack.push(root);
        if (root.data == value){
            return;
        }
        else if (root.data > value){
            findValuePath(root.left, value, stack);
        }
        else{
            findValuePath(root.right, value, stack);
        }
    }

    private static Node insertBst(Node root, int data){
        if (root == null){
            return new Node(data);
        }
        if (root.data >= data){
            root.left = insertBst(root.left, data);
        }
        else{
            root.right = insertBst(root.right, data);
        }
        return root;
    }

    private static void inorder(Node root){
        if (root == null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }


}

