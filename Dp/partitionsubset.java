import java.io.*;
import java.util.*;

public class Main {

   public static void main(String[] args) throws Exception {
      Scanner sc=new Scanner(System.in);
      int n=sc.nextInt();
      int k=sc.nextInt();
      System.out.println(part(n,k));
   }
   public static long  part(int n,int k)
   {
       long dp[][]=new long[n+1][k+1];
       for(int i=0;i<=n;i++)
       {
           for(int j=0;j<=k;j++)
           {
               if(i<j||j==0||i==0)
               dp[i][j]=0;
               else if(i==j)
               dp[i][j]=1;
               else
               {
                   dp[i][j]=dp[i-1][j-1]+j*dp[i-1][j];
               }
               
           }
       }
       return dp[n][k];
       
   }
}