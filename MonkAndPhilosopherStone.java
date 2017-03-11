import java.util.*;
import java.util.LinkedList;

/**
 * Created by priyank on 11/3/17.
 */
public class MonkAndPhilosopherStone {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Queue<Integer> a = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            a.add(in.nextInt());
        }
        int q = in.nextInt();
        int value = in.nextInt(), sum = 0;
        boolean valueFound = false;
        Stack<Integer> stack = new Stack<>();

        while (q != 0){
            String s = in.next();
            if (s.equals("Harry") && !valueFound){
                int temp = a.remove();
                sum += temp;
                stack.push(temp);
            }
            else if (s.equals("Remove") && !valueFound){
                int temp = stack.pop();
                sum -= temp;
            }
            if (sum == value){
                valueFound = true;
            }
            q--;
        }

        if (valueFound){
            System.out.println(stack.size());
        }
        else{
            System.out.println("-1");
        }
    }
}

