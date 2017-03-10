import java.util.Scanner;

/**
 * Created by priyank on 10/3/17.
 */
public class MonkAndInversions {

    public static void main (String[] args){
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t != 0){

            int n = in.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++){
                for (int j = 0; j < n; j++){
                    a[i][j] = in.nextInt();
                }
            }

            int inversions = 0;

            for (int i = 0; i < n; i++){
                for (int l = 0; l < n; l++){
                    for (int j = 0; j <= i; j++){
                        for (int k = 0; k <= l; k++){
                            if (a[i][l] < a[j][k]){
                                inversions++;
                            }
                        }
                    }
                }
            }

            System.out.println(inversions);

            t--;
        }
    }
}

