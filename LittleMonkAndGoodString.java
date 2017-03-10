import java.util.HashSet;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by priyank on 10/3/17.
 */
public class LittleMonkAndGoodString {

    public static void main (String[] args){

        Scanner in = new Scanner(System.in);
        String s = in.next();

        Stack<Integer> stack = new Stack<>();

        HashSet<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');

        for (int i = 0; i < s.length(); i++){
            if (!set.contains(s.charAt(i))){
                stack.push(i);
            }
        }

        int last = s.length();
        int length = 0;

        if (stack.isEmpty()){
            length = s.length();
        }
        while (!stack.isEmpty()){
            int index = stack.pop();
            int temp = last - index -1;
            length = Math.max(length, temp);
            last = index;
        }

        length = Math.max(length, last);

        System.out.print(length);
    }
}

