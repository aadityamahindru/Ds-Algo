// Question
// 1. You are given an array of integers, which represents the vertices of an N-sided convex polygon in clockwise order.
// 2. You have to triangulate the given polygon into N-2 triangles.
// 3. The value of a triangle is the product of the labels of vertices of that triangle.
// 4. The total score of the triangulation is the sum of the value of all the triangles.
// 5. You have to find the minimum score of the triangulation of the given polygon.
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
// 6


import java.io.*;
import java.util.*;

public class Main {

    public static int minScoreTriangulation(int[] arr, int st, int ed, int dp[][]) {
        if (st + 1 == ed) {
            return 0;
        }
        if (dp[st][ed] != 0) {
            return dp[st][ed];
        }
        int min = Integer.MAX_VALUE;
        for (int cp = st + 1; cp < ed; cp++) {
            int lc = minScoreTriangulation(arr, st, cp, dp);
            int rc = minScoreTriangulation(arr, cp, ed, dp);
            int myc = arr[st] * arr[ed] * arr[cp];
            int tc = lc + rc + myc;
            min = Math.min(min, tc);
        }
        dp[st][ed] = min;
        return min;
    }
    public static int minScoreTriangulation(int arr[]) {
        int n = arr.length;
        int dp[][] = new int[n][n];
        for (int gap = 2; gap < n; gap++) {
            for (int st = 0, ed = gap; ed < n; ed++, st++) {
                if (st + 1 == ed) {
                    dp[st][ed]= 0;
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
        return dp[0][n-1];
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        System.out.println(minScoreTriangulation(arr));
    }
}