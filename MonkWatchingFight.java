import java.util.Scanner;

/**
 * Created by priyank on 15/3/17.
 */
public class MonkWatchingFight {

    private static class Node{
        int value;
        Node left;
        Node right;
        Node(int n){
            this.value = n;
        }
    }

    public static void main(String[] args){

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        Node root = null;
        for (int i = 0; i < n; i++){
            a[i] = in.nextInt();
            root = insertNode(root, a[i]);
        }
        //inorder(root);

        System.out.println(getTreeHeight(root));
    }

    private static Node insertNode(Node root, int value){
        if (root == null){
            root = new Node(value);
            return root;
        }
        if (root.value >= value){
            root.left = insertNode(root.left, value);
        }
        else{
            root.right = insertNode(root.right, value);
        }
        return root;
    }

    private static void inorder(Node root){

        if (root == null){
            return;
        }
        inorder(root.left);
        System.out.print(root.value + " ");
        inorder(root.right);
    }

    private static int getTreeHeight(Node root){

        if (root == null){
            return 0;
        }
        int lh = getTreeHeight(root.left);
        int rh = getTreeHeight(root.right);

        return Math.max(lh, rh) + 1;
    }

}

