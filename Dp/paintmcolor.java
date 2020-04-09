import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int a[][] = new int[n][k];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        System.out.println(paintHouse(a));

    }
    public static int paintHouse(int a[][]) {
        int n = a.length;
        int k = a[0].length;
        int dp[][] = new int[n][k];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                if (i == 0) {
                    dp[i][j] = a[i][j];
                } else {
                    dp[i][j] = a[i][j] + min(dp, i - 1, j);
                }
            }
        }
        int mini = min(dp, n - 1, -1);
        return mini;
    }
    public static int min(int a[][], int row, int col) {
        int n = a[0].length;
        int mini = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (i != col) {
                if (a[row][i] < mini) {
                    mini = a[row][i];
                }
            }
        }
        return mini;
    }
}