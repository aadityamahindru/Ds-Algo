import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int val[]=new int[n];
        for(int i=0;i<n;i++)
        {
            val[i]=sc.nextInt();
        }
        int weight[]=new int[n];
        for(int i=0;i<n;i++)
        {
            weight[i]=sc.nextInt();
        }
        int cap=sc.nextInt();
        System.out.println(knapsack(val,weight,cap));

    }
    public static int knapsack(int val[],int weight[],int cap)
    {
        int n=val.length;
        int dp[][]=new int[n+1][cap+1];
        for(int i=0;i<n+1;i++)
        {
            for(int j=0;j<cap+1;j++)
            {
                if(i==0||j==0)
                dp[i][j]=0;
                else
                {
                    int wt=weight[i-1];
                    int vl=val[i-1];
                    if(j-wt>=0)
                    {
                        dp[i][j] =Math.max(vl+dp[i-1][j-wt],dp[i-1][j]);
                    }
                    else
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[n][cap];
    }
}