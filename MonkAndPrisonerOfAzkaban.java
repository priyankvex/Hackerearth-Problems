import java.util.Scanner;
import java.util.Stack;

/**
 * Created by priyank on 14/3/17.
 */
public class MonkAndPrisonerOfAzkaban {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Long[] a = new Long[n];
        for (int i = 0; i < n; i++){
            a[i] = in.nextLong();
        }

        Stack<Integer> stack = new Stack<>();

        int[] ng = new int[n];

        for (int i = 0; i < n; i++){
            if (i == 0){
                stack.push(i);
            }
            else{
                int temp = stack.pop();
                while (a[temp] < a[i]){
                    ng[temp] = i+1;
                    if (stack.isEmpty()){
                        break;
                    }
                    temp = stack.pop();
                }
                if (a[temp] > a[i]){
                    stack.push(temp);
                }
                stack.push(i);
            }
        }

        while (!stack.isEmpty()){
            ng[stack.pop()] = -1;
        }

        /*System.out.println(Arrays.toString(ng));*/

        // Do the same for reversed array

        for (int i = n-1; i >= 0; i--){
            if (i == n-1){
                stack.push(i);
            }
            else{
                int temp = stack.pop();
                while (a[temp] < a[i]){
                    ng[temp] += i+1;
                    if (stack.isEmpty()){
                        break;
                    }
                    temp = stack.pop();
                }
                if (a[temp] > a[i]){
                    stack.push(temp);
                }
                stack.push(i);
            }
        }

        while (!stack.isEmpty()){
            int temp = stack.pop();
            ng[temp] += -1;
        }

        for (int i = 0; i < n; i++){
            System.out.print(ng[i] + " ");
        }

        /*System.out.println(Arrays.toString(ng));*/
    }
}

