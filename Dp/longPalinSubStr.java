//1. You are given a string str.
//2. You are required to print the length of longest of palindromic substrings in string str.


// Sample Input
// abccbc
// Sample Output
// 4


import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        boolean dp[][]=new boolean[str.length()][str.length()];
        int maxLength=0;
        for(int dig=0;dig<str.length();dig++)
        {
            for(int i=0,j=dig;j<str.length();j++,i++)
            {
                if(dig==0)
                {
                    dp[i][j]=true;
                }
                else if(dig==1)
                {
                    if(str.charAt(i)==str.charAt(j))
                    {
                        dp[i][j]=true;
                    }
                }
                else
                {
                    if(str.charAt(i)==str.charAt(j)&&dp[i+1][j-1]==true)
                    {
                        dp[i][j]=true;
                    }
                }
                if(dp[i][j]==true)
                {
                    maxLength=dig+1;
                }
            }
        }
        System.out.println(maxLength);
    }
}