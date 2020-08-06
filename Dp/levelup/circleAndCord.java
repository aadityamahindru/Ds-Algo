// Question
// 1. You are given a number N.
// 2. There are 2*N points on a circle. You have to draw N non-intersecting chords on a circle.
// 3. You have to find the number of ways in which these chords can be drawn.
// Input Format
// A number N
// Output Format
// Check the sample output and question video.
// Constraints
// 1 <= N <= 1000
// 1 <= arr[i] <= 100
// Sample Input
// 3
// Sample Output
// 5


import java.io.*;
import java.util.*;

public class Main {

    public static long NumberOfChords(int st,int ed,long dp[]){
        //write your code here
        if(st+1==ed){
            return 1;
        }
        if(st>=ed){
            return 1;
        }
        if(dp[ed-st]!=0){
            return dp[ed-st];
        }
        long ways=0;
        for(int cp=st+1;cp<=ed;cp+=2){
            long lc=NumberOfChords(st+1,cp-1,dp);
            long rc=NumberOfChords(cp+1,ed,dp);
            long myways=lc*rc;
            ways+=myways;
        }
        return dp[ed-st]=ways;
    }
    public static long NumberOfChords(int n){
        long dp[]=new long[2*n+1];
        dp[0]=1;
        dp[2]=1;
        for(int idx=4;idx<dp.length;idx++){
            int i=0,j=idx-2;
            while(i<=idx-2){
                dp[idx]+=dp[i]*dp[j];
                i+=2;
                j-=2;
            }
        }
        return dp[2*n];
    }
  public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        System.out.println(NumberOfChords(n));
	}
}