import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by priyank on 15/3/17.
 */
public class LIttleMonkAndBalancedParantheses {

    public static void main (String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++){
            a[i] = in.nextInt();
        }
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < n; i++){
            if (a[i] > 0){
                s.push(i);
            }
            else if (a[i] < 0){
                if (!s.isEmpty() && a[s.peek()] == (-1)*a[i]){
                    s.pop();
                }
                else{
                    s.push(i);
                }
            }
        }

        //System.out.println(Arrays.toString(s.toArray()));

        if (s.isEmpty()){
            System.out.println(n);
            return;
        }
        int max = 0;
        int last = s.peek();
        int prev = s.pop();
        while (!s.isEmpty()){
            int cur = s.pop();
            int temp = (prev - cur-1);
            max = Math.max(max, temp);
            prev = cur;
        }

        max = Math.max(max, prev);
        max = Math.max(max, n-last-1);

        //System.out.println(Arrays.toString(s.toArray()));

        System.out.println(max);
    }
}

