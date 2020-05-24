// 1. You are given a number n, representing the number of bridges on a river.
// 2. You are given n pair of numbers, representing the north bank and south bank co-ordinates of each bridge.
// 3. You are required to print the count of maximum number of non-overlapping bridges.

// Sample Input
// 10
// 10 20
// 2 7
// 8 15
// 17 3
// 21 40
// 50 4
// 41 57
// 60 80
// 80 90
// 1 30
// Sample Output
// 7


import java.io.*;
import java.util.*;

public class Main {
    static class pair implements Comparable<pair>{
            int nb;
            int sb;
            public int compareTo(pair other){
                if(this.nb!=other.nb){
                    return this.nb-other.nb;
                }else{
                    return this.sb-other.sb;
                }
            }
        }

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        pair[] bridges=new pair[n];
        for(int i=0;i<n;i++){
            pair bridge=new pair();
            bridge.nb=sc.nextInt();
            bridge.sb=sc.nextInt();
            bridges[i]=bridge;
        }
        Arrays.sort(bridges);
        int max=0;
        int dp[]=new int[n];
        for(int i=0;i<n;i++)
        {
            int maxL=0;
            for(int j=0;j<i;j++)
            {   
                if(bridges[i].sb>bridges[j].sb&&maxL<dp[j])
                {
                    maxL=dp[j];
                }
            }
            dp[i]=maxL+1;
            if(max<dp[i])
            {
                max=dp[i];
            }
        }
        System.out.println(max);
    }

}