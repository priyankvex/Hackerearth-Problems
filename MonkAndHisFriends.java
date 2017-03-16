import java.util.Scanner;

/**
 * Created by priyank on 16/3/17.
 */
public class MonkAndHisFriends {

    private static class Node{
        long data;
        Node left;
        Node right;
        Node(long data){
            this.data = data;
        }
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t != 0){
            int n = in.nextInt();
            int m = in.nextInt();
            long[] a = new long[n+m];
            Node root = null;
            for (int  i = 0; i < n+m; i++){
                a[i] = in.nextLong();
            }
            for (int i = 0 ; i < n; i++){
                root = insert(root, a[i]);
            }
            for (int i = n; i < n+m; i++){
                boolean status = search(root, a[i]);
                if (status){
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
                root = insert(root, a[i]);
            }
            t--;
        }
    }

    private static Node insert(Node root, long value){
        if (root == null){
            root = new Node(value);
            return root;
        }
        if (root.data >= value){
            root.left = insert(root.left, value);
        }
        else{
            root.right = insert(root.right, value);
        }
        return root;
    }

    private static boolean search(Node root, long value){
        if (root == null){
            return false;
        }
        if (root.data == value){
            return true;
        }
        else if (root.data > value){
            return search(root.left, value);
        }
        else {
            return search(root.right, value);
        }
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

