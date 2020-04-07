	import java.io.*;
	import java.util.*;

	public class Main {

	    public static void main(String[] args) throws Exception {
	        Scanner sc = new Scanner(System.in);
	        int n = sc.nextInt();
	        int val[] = new int[n];
	        for (int i = 0; i < n; i++) {
	            val[i] = sc.nextInt();
	        }
	        int weight[] = new int[n];
	        for (int i = 0; i < n; i++) {
	            weight[i] = sc.nextInt();
	        }
	        int cap = sc.nextInt();
	        System.out.println(knapsack(val, weight, cap));


	    }
	    public static int knapsack(int val[],int weight[],int cap)
	    {
	        int n=val.length;
	        int dp[]=new int[cap+1];
	        dp[0]=0;
	        for(int i=0;i<n;i++)
	        {
	            int wt=weight[i];
	            int vl=val[i];
	            for(int j=wt;j<cap+1;j++)
	            {
	                dp[j]=Math.max(vl+dp[j-wt],dp[j]);
	            }
	        }
	        return dp[cap];
	    }
	}