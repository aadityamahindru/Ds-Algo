// Question
// 1. You are given a string.
// 2. You have to find the minimum number of cuts required to convert the given string into palindromic partitions.
// 3. Partitioning of the string is a palindromic partitioning if every substring of the partition is a palindrome.
// Input Format
// A string
// Output Format
// Check the sample output and question video.
// Constraints
// 1 <= length of string <= 10^4
// Sample Input
// abccbc
// Sample Output
// 2

public static int minPalindromicCut(String s) {
		//write your code here
		int n=s.length();
		int dp[][]=new int[n][n];
		for(int gap=1;gap<n;gap++){
		    for(int st=0,ed=gap;ed<n;st++,ed++){
		        char ch1=s.charAt(st);
		        char ch2=s.charAt(ed);
		        if(ch1==ch2&&dp[st+1][ed-1]==0){
		                dp[st][ed]=0;
		        }else{
		            int min=Integer.MAX_VALUE;
		            for(int cp=st+1;cp<=ed;cp++){
		                int lc=dp[st][cp-1];
		                int rc=dp[cp][ed];
		                int myc=lc+rc+1;
		                min=Math.min(min,myc);
		            }
		            dp[st][ed]=min;
		        }
		    }
		}
		return dp[0][n-1];
	}
