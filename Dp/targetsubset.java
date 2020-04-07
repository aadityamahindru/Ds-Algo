import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int tar = sc.nextInt();
        System.out.println(targetSum(a, tar));

    }
    public static boolean targetSum(int coins[], int tar) {
        boolean dp[][] = new boolean[coins.length + 1][tar + 1];
        for (int i = 0; i < coins.length + 1; i++) {
            for (int j = 0; j < tar + 1; j++) {
                if (j == 0) {
                    dp[i][j] = true;
                } else if (i == 0) {
                    dp[i][j] = false;
                } else {
                    int coin = coins[i - 1];
                    boolean inc = false;
                    if (coin <= j) {
                        inc = dp[i - 1][j - coin];
                    }
                    dp[i][j] = inc || dp[i - 1][j];
                }
                if (dp[i][tar] == true)
                    return true;
            }
        }
            return false;
    }
    // public static boolean targetSum(int coins[],int idx,int sos,int tar,boolean dp[])
    // {
    //     if(sos==target)
    //     {
    //         return true;
    //     }
    //     if(dp[idx]!=true){
    //         return dp[idx];
    //     }
        
    // }
}