// Question
// 1. You are given two integers N and M which represents the length and breadth of a paper respectively. 
// 2. You have to divide the given paper into pieces such that every piece is a square.
// 3. You have to find the minimum number of such pieces.
// Input Format
// Two integers N and M
// Output Format
// Check the sample output and question video.
// Constraints
// 1 <= N,M <= 10^3
// Sample Input
// 30 
// 35
// Sample Output
// 5


import java.io.*;
import java.util.*;

public class Main {

	public static int solution(int n, int m){
		//write your code here
		int dp[][]=new int[n+1][m+1];
		for(int row=1;row<=n;row++){
		    dp[row][1]=row;
		}
		for(int col=1;col<=m;col++){
		    dp[1][col]=col;
		}
        for(int row=2;row<=n;row++){
            for(int col=2;col<=m;col++){
                if(row==col){
                    dp[row][col]=1;
                }else{
                    int val=Integer.MAX_VALUE;
                    //row cut
                    for(int cp=1;cp<=row/2;cp++){
                        int left=dp[cp][col];
                        int right=dp[row-cp][col];
                        val=Math.min(val,left+right);
                    }
                    //col cut
                    for(int cp=1;cp<=col/2;cp++){
                        int left=dp[row][cp];
                        int right=dp[row][col-cp];
                        val=Math.min(val,left+right);
                    }
                    dp[row][col]=val;
                }
            }
        }
		return dp[n][m];
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int m = scn.nextInt();
		System.out.println(solution(n,m));
	}
}