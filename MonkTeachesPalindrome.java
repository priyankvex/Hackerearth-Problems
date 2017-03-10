import java.util.Scanner;

/**
 * Created by priyank on 4/3/17.
 */
public class MonkTeachesPalindrome {

    public static void main(String[] args){

        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t != 0){

            String s = in.next();

            int i = 0, j = s.length()-1;
            boolean status = true;

            while (i < j){
                if (s.charAt(i) != s.charAt(j)){
                    status = false;
                    break;
                }
                i++;
                j--;
            }

            if (s.length() % 2 == 0 && status){
                System.out.println("YES EVEN");
            }
            else if (s.length() % 2 == 1 && status){
                System.out.println("YES ODD");
            }
            else{
                System.out.println("NO");
            }

            t--;
        }
    }
}

