import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int a[]=new int[n];
        for(int i=0;i<n;i++)
        {
            a[i]=sc.nextInt();
        }
        int dp[][]=new int[2][n+1];
        dp[0][1]=0-a[0];
        dp[1][1]=0;
        for(int i=2;i<=n;i++)
        {
            dp[0][i]=Math.max(dp[0][i-1],dp[1][i-2]-a[i-1]);
            dp[1][i]=Math.max(dp[1][i-1],dp[0][i-1]+a[i-1]);
        }
        System.out.println(dp[1][n]);
    }

}