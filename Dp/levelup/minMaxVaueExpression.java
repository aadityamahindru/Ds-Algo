// Question
// 1. You are given a string that represents an expression containing numbers and two operators + and *.
// 2. You have to find the minimum and maximum value which can be obtained by evaluating this expression by different parenthesization.
// Input Format
// A string
// Output Format
// Check the sample output and question video.
// Constraints
// 1 <= length of string <= 100
// Range of numbers -> [0,9]
// Sample Input
// 1+2*3+4*5
// Sample Output
// Minimum Value -> 27
// Maximum Value -> 105



import java.io.*;
import java.util.*;

public class Main {
    static class Pair {
        int min;
        int max;
        Pair(int min, int max) {
            this.min = min;
            this.max = max;
        }
    }
    public static Pair solution(String str1, String str2, int st, int ed, Pair dp[][]) {
        //write your code here
        if (st == ed) {
            char ch = str1.charAt(st);
            int num = ch - '0';
            return new Pair(num, num);
        }
        if (dp[st][ed] != null) {
            return dp[st][ed];
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int cp = st; cp < ed; cp++) {
            Pair lc = solution(str1, str2, st, cp, dp);
            Pair rc = solution(str1, str2, cp + 1, ed, dp);
            Pair ans = solve(lc, rc, str2.charAt(cp));
            min = Math.min(min, ans.min);
            max = Math.max(max, ans.max);
        }
        dp[st][ed] = new Pair(min, max);
        return new Pair(min, max);
    }
    public static Pair solve(Pair l, Pair r, char ch) {
        Pair ans = new Pair(0, 0);
        if (ch == '+') {
            ans.min = l.min + r.min;
            ans.max = l.max + r.max;
            return ans;
        } else {
            ans.min = l.min * r.min;
            ans.max = l.max * r.max;
            return ans;
        }
    }
    public static Pair solution(String str1, String str2) {
        int n = str1.length();
        Pair dp[][] = new Pair[n][n];
        for (int gap = 0; gap < n; gap++) {
            for (int st = 0, ed = gap; ed < n; ed++, st++) {
                if (st == ed) {
                    char ch = str1.charAt(st);
                    int num = ch - '0';
                    dp[st][ed]= new Pair(num, num);
                    continue;
                }
                int min = Integer.MAX_VALUE;
                int max = Integer.MIN_VALUE;
                for (int cp = st; cp < ed; cp++) {
                    Pair lc = dp[st][cp];
                    Pair rc = dp[cp+1][ed];
                    Pair ans = solve(lc, rc, str2.charAt(cp));
                    min = Math.min(min, ans.min);
                    max = Math.max(max, ans.max);
                }
                dp[st][ed] = new Pair(min, max);
            }
        }
        return dp[0][n-1];
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s = scn.next();
        String str1 = "";
        String str2 = "";
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '+' || ch == '*') {
                str2 += ch;
            } else {
                str1 += ch;
            }
        }
        Pair ans = solution(str1, str2);
        System.out.println("Minimum Value -> " + ans.min);
        System.out.println("Maximum Value -> " + ans.max);
    }

}