// Question
// 1. You are given an array(arr) of positive integers of length N which represents the dimensions of N-1 matrices such that the ith matrix is of dimension arr[i-1] x arr[i].
// 2. You have to find the minimum number of multiplications needed to multiply the given chain of matrices.
// Input Format
// A number N
// arr1
// arr2.. N integers
// Output Format
// Check the sample output and question video.
// Constraints
// 2 <= N <= 1000
// 1 <= arr[i] <= 500
// Sample Input
// 3
// 1
// 2
// 3
// Sample Output
// 6


import java.io.*;
import java.util.*;

public class Main {

	public static int mcm(int[] arr,int st,int ed,int dp[][]){
		//write your code here
		if(ed-st==1){
		    return 0;
		}
		if(dp[st][ed]!=0){
		    return dp[st][ed];
		}
		int min=Integer.MAX_VALUE;
		for(int cp=st+1;cp<ed;cp++){
		    int lc=mcm(arr,st,cp,dp);
		    int rc=mcm(arr,cp,ed,dp);
		    int myc=arr[st]*arr[ed]*arr[cp];
		    int tc=lc+rc+myc;
		    min=Math.min(min,tc);
		}
		dp[st][ed]=min;
		return min;
}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for(int i = 0 ; i < n; i++){
			arr[i] = scn.nextInt();
		}
		System.out.println(mcm(arr,0,n-1,new int[n][n]));
	}


    //tabulation
    public static void mcm(int arr[]) {
        int dp[][] = new int[arr.length][arr.length];
        for (int gap = 1; gap < arr.length; gap++) {
            for (int st=0, ed = gap; ed <arr.length; st++,ed++) {
                if (ed - st == 1) {
                    dp[st][ed] = 0;
                    continue;
                }
                int min = Integer.MAX_VALUE;
                for (int cp = st + 1; cp < ed; cp++) {
                    int lc = dp[st][cp];
                    int rc = dp[cp][ed];
                    int myc = arr[st] * arr[ed] * arr[cp];
                    int tc = lc + rc + myc;
                    min = Math.min(min, tc);
                }
                dp[st][ed] = min;
            }
        }
        System.out.println(dp[0][arr.length-1]);
    }
}