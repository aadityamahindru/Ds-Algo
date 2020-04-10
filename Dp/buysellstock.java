import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        System.out.println(stocks(n, a));
    }
    //with variables only
    public static int stocks(int n,int a[])
    {
        int msf=a[0],max=0;
        for(int i=1;i<n;i++)
        {
            if(msf>a[i])        //if we find best buying day we update msf
            msf=a[i];
            if(a[i]-msf>max)  // to find best selling day wrt buying day
            max=a[i]-msf;
        }
        return max;
    }


}