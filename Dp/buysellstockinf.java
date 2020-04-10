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
        System.out.println(profit(a));
    }
    public static int profit(int a[])
    {
        int n=a.length;
        int sp=0,bp=0,profit=0;
        for(int i=0;i<n-1;i++)
        {
            if(a[i]<=a[i+1])
            {
                sp=i+1;
            }
            else
            {
                profit +=(a[sp]-a[bp]);
                sp=i+1;
                bp=i+1;
            }
        }
        //including latest profit
        profit +=(a[sp]-a[bp]);
        return profit;
    }

}