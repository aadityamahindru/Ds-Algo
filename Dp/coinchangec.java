import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int coins[] = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }
        int amt = sc.nextInt();
        System.out.println(coinChange(coins, amt));

    }
    public static int coinChange(int coins[], int amt) {
        int dp[] = new int[amt + 1];
        dp[0]=1;
        for(int i=0;i<coins.length;i++)
        {
            int coin=coins[i];
            for(int j=0;j<amt+1;j++)
            {
                if(j-coin>=0)
                {
                    dp[j] +=dp[j-coin];
                }
            }
        }
        return dp[amt];
    }
}