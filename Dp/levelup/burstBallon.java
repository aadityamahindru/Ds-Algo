// Question
// 1. You are given an array(arr) of length N which represents N number of balloons.
// 2. Each balloon is painted with a number on it.
// 3. You have to collect maximum coins by bursting all the balloons.
// 4. If you burst a balloon with index i, you will get (arr[i-1] * arr[i] * arr[i+1]) number of coins.
// 5. If arr[i-1] and arr[i+1] don't exist, then you may assume their value as 1.
// Input Format
// A number N
// a1
// a2.. N integers
// Output Format
// Check the sample output and question video.
// Constraints
// 1 <= N <= 1000
// 1 <= arr[i] <= 100
// Sample Input
// 3
// 1
// 2
// 3
// Sample Output
// 12


import java.io.*;
import java.util.*;

public class Main {

    public static int solution(int[] arr, int st, int ed, int dp[][]) {
        if (st == ed) {
            int lVal = st - 1 >= 0 ? arr[st - 1] : 1;
            int rVal = ed + 1 < arr.length ? arr[ed + 1] : 1;
            int myVal = lVal * rVal * arr[st];
            return myVal;
        }
        if (dp[st][ed] != 0) {
            return dp[st][ed];
        }
        int lVal = st - 1 >= 0 ? arr[st - 1] : 1;
        int rVal = ed + 1 < arr.length ? arr[ed + 1] : 1;
        int max = Integer.MIN_VALUE;
        for (int cp = st; cp <= ed; cp++) {
            int lc = cp - 1 >= st ? solution(arr, st, cp - 1, dp) : 0;
            int rc = cp + 1 <= ed ? solution(arr, cp + 1, ed, dp) : 0;
            int myc = lc + rc + (lVal * rVal * arr[cp]);
            max = Math.max(max, myc);
        }
        dp[st][ed] = max;
        return max;
    }
    //tabulation
    public static void solution(int[] arr) {
        int n = arr.length;
        int dp[][] = new int[n][n];
        for (int gap = 0; gap < n; gap++) {
            for (int st = 0, ed = gap; ed < n; ed++, st++) {
                int lVal = st - 1 >= 0 ? arr[st - 1] : 1;
                int rVal = ed + 1 < arr.length ? arr[ed + 1] : 1;
                if (st == ed) {
                    int myVal = lVal * rVal * arr[st];
                    dp[st][ed] = myVal;
                    continue;
                }
                int max = Integer.MIN_VALUE;
                for (int cp = st; cp <= ed; cp++) {
                    int lc = cp - 1 >= st ? dp[st][cp-1] : 0;
                    int rc = cp + 1 <= ed ? dp[cp+1][ed] : 0;
                    int myc = lc + rc + (lVal * rVal * arr[cp]);
                    max = Math.max(max, myc);
                }
                dp[st][ed]=max;
            }
        }
        System.out.println(dp[0][n-1]);
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
        //System.out.println(solution(arr, 0, n - 1, new int[n][n]));
        solution(arr);
    }
}