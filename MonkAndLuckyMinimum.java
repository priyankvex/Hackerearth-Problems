import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by priyank on 15/3/17.
 */
public class MonkAndLuckyMinimum {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t != 0){
            int n = in.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();
            }
            HashMap<Integer, Integer> counter = new HashMap<>();
            int min = a[0];
            for (int i = 0; i < n; i++){
                if (a[i] < min){
                    min = a[i];
                }
                Integer freq = counter.get(a[i]);
                if (freq == null){
                    counter.put(a[i], 1);
                }
                else{
                    counter.put(a[i], ++freq);
                }
            }
            int minCOunt = counter.get(min);
            if (minCOunt % 2 == 0){
                System.out.println("Unlucky");
            }
            else{
                System.out.println("Lucky");
            }
            t--;
        }
    }

}

