// 1. You are given a boolean expression with symbols T,F, and operators &,|,^ , where
//    T represents True
//    F represents False
//    & represents boolean AND
//    | represents boolean OR
//    ^ represents boolean XOR.
// 2. You have to find the number of ways in which the expression can be parenthesized so that the value of expression evaluates to true.
// Input Format
// Two strings s1 and s2
// Output Format
// Check the sample output and question video.
// Constraints
// 2 <= length of s1 <= 100
// 1 <= length of s2 <= 99
// Sample Input
// TFT
// ^&
// Sample Output
// 2


import java.io.*;
import java.util.*;

public class Main {
    static class Pair {
        int tc;
        int fc;
        Pair(int tc, int fc) {
            this.tc = tc;
            this.fc = fc;
        }
    }
    public static Pair solution(String str1, String str2, int st, int ed, Pair dp[][]) {
        if (st == ed) {
            char ch = str1.charAt(st);
            if (ch == 'T') {
                return new Pair(1, 0);
            } else {
                return new Pair(0, 1);
            }
        }
        if (dp[st][ed] != null) {
            return dp[st][ed];
        }
        int t = 0, f = 0;
        for (int cp = st; cp < ed; cp++) {
            Pair lc = solution(str1, str2, st, cp, dp);
            Pair rc = solution(str1, str2, cp + 1, ed, dp);
            Pair ans = solve(lc, rc, str2.charAt(cp));
            t += ans.tc;
            f += ans.fc;
        }
        dp[st][ed] = new Pair(t, f);
        return new Pair(t, f);
    }
    public static Pair solve(Pair l, Pair r, char ch) {
        Pair ans = new Pair(0, 0);
        if (ch == '&') {
            ans.tc = l.tc * r.tc;
            ans.fc = l.fc * r.tc + l.tc * r.fc + l.fc * r.fc;
            return ans;
        } else if (ch == '|') {
            ans.tc = l.tc * r.tc + l.tc * r.fc + l.fc * r.tc;
            ans.fc = l.fc * r.fc;
            return ans;
        } else {
            ans.tc = l.tc * r.fc + l.fc * r.tc;
            ans.fc = l.tc * r.tc + l.fc * r.fc;
            return ans;
        }
    }

    // tabulation
    public static void solution(String str1, String str2) {
        int n = str1.length();
        Pair dp[][] = new Pair[n][n];
        for (int gap = 0; gap < n; gap++) {
            for (int st = 0, ed = gap; ed < n; ed++, st++) {
                if (st == ed) {
                    char ch = str1.charAt(st);
                    if (ch == 'T') {
                        dp[st][ed]= new Pair(1, 0);
                        continue;
                    } else {
                        dp[st][ed]= new Pair(0, 1);
                        continue;
                    }
                }
                int t = 0, f = 0;
                for (int cp = st; cp < ed; cp++) {
                    Pair lc = dp[st][cp];
                    Pair rc = dp[cp+1][ed];
                    Pair ans = solve(lc, rc, str2.charAt(cp));
                    t += ans.tc;
                    f += ans.fc;
                }
                dp[st][ed] = new Pair(t, f);
            }
        }
        System.out.println(dp[0][n-1].tc);
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s1 = scn.next();
        String s2 = scn.next();
        // Pair ans = solution(s1, s2, 0, s1.length() - 1, new Pair[s1.length()][s1.length()]);
        // System.out.println(ans.tc);
        solution(s1,s2);
    }

}