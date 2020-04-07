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
        for(int i=1;i<amt+1;i++)
        {
            for(int j=0;j<coins.length;j++)
            {
                int coin =coins[j];
                if(i-coin>=0)
                {
                    dp[i] +=dp[i-coin];
                }
            }
        }
        return dp[amt];
    }

}