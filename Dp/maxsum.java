import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int a[]=new int[n];
        for(int i=0;i<n;i++)
        {
            a[i]=sc.nextInt();
        }
        System.out.println(maxSum(a));

    }
    public static int maxSum(int a[])
    {
        int n=a.length;
        int dp[][]=new int[2][n];
        dp[0][0]=0;
        dp[1][0]=a[0];
        for(int i=1;i<n;i++)
        {//exc
            dp[0][i]=Math.max(dp[0][i-1],dp[1][i-1]);
            //inc
            dp[1][i]=dp[0][i-1]+a[i];
        }
        return Math.max(dp[0][n-1],dp[1][n-1]);
    }
}