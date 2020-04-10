import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println(friends(n));
    }
    public static int friends(int n)
    {
        int dp[]=new int[n+1];
        dp[1]=1;
        dp[2]=2;
        for(int i=3;i<=n;i++)
        {
          dp[i]=dp[i-1]+(i-1)*dp[i-2];
        }
        return dp[n];
    }

}