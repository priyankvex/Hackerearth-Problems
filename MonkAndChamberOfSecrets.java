import java.util.*;
import java.util.LinkedList;

/**
 * Created by priyank on 11/3/17.
 */
public class MonkAndChamberOfSecrets {

    private static class Spider {
        int power;
        int originalIndex;
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int x = in.nextInt();
        Queue<Spider> queue = new LinkedList<>();
        for (int i = 0; i < n; i++){
            Spider s = new Spider();
            s.power = in.nextInt();
            s.originalIndex = i+1;
            queue.add(s);
        }

        Spider[] temp = new Spider[x];

        for (int i = 0; i < x; i++){
            int j = 0, maxIndex = 0;
            while (!queue.isEmpty() && j < x){
                Spider tempSpider = queue.remove();
                temp[j] = tempSpider;
                if (tempSpider.power > temp[maxIndex].power){
                    maxIndex = j;
                }
                j++;
            }
            System.out.print(temp[maxIndex].originalIndex + " ");
            j--;
            for (int k = 0 ; k <= j; k++){
                if (temp[k].power > 0){
                    temp[k].power -= 1;
                }
                if (k != maxIndex){
                    queue.add(temp[k]);
                }
            }
        }
    }
}

