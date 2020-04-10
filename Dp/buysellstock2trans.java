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
        System.out.println(buySell(a));
    }
    public static int buySell(int a[])
    {
        int n=a.length;
        int minsf[]=new int[n];
        int maxsf[]=new int[n];
        int sum[]=new int[n];
        int maxval=Integer.MIN_VALUE;
        minsf[0]=0;
        maxsf[n-1]=0;
        int minp=a[0],maxp=a[n-1];
        for(int i=1;i<n;i++)
        {
            if(a[i]<minp)
            minp=a[i];
            if(a[i]-minp>minsf[i-1])
            minsf[i]=a[i]-minp;
            else
            minsf[i]=minsf[i-1];
            if(a[n-i-1]>maxp)
            maxp=a[n-i-1];
            if(maxp-a[n-i-1]>maxsf[n-i])
            maxsf[n-i-1]=maxp-a[n-i-1];
            else
            maxsf[n-i-1]=maxsf[n-i];
        }
        for(int i=0;i<n;i++)
        {
            sum[i]=minsf[i]+maxsf[i];
            if(sum[i]>maxval)
            maxval=sum[i];
        }
        return maxval;
    }
}