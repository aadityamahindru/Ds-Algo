import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(fibt(n));
    }
    static int fibr(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int fib1 = fibr(n - 1);
        int fib2 = fibr(n - 2);
        return fib1 + fib2;
    }
    static int fibm(int n, int dp[]) {
        if (n == 0 || n == 1) {
            return dp[n] = n;
        }
        if (dp[n] != 0) {
            return dp[n];
        }
        int fib1 = fibm(n - 1, dp);
        int fib2 = fibm(n - 2, dp);
        return dp[n] = fib1 + fib2;
    }
    static int fibt(int n) {
        int dp[]=new int[n+1];
        for (int i = 0; i <= n; i++) {
            if (i == 0 || i == 1) {
                 dp[i] = i;
                 continue;
            }
            int fib1 = dp[i-1];
            int fib2 = dp[i-2];
            dp[i] = fib1 + fib2;

        }
        return dp[n];
    }
}