import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] a=new int[n];
        for(int i=0;i<n;i++)
        {
            a[i]=sc.nextInt();
        }
        int tar=sc.nextInt();
        printTargetSumSubsets(a,0,"",0,tar);
        System.out.println();

    }

    // set is the subset
    // sos is sum of subset
    // tar is target
    public static void printTargetSumSubsets(int[] arr, int idx, String set, int sos, int tar) {
        if(sos==tar&&idx==arr.length)
        {
            System.out.println(set+".");
            return;
        }
        if(sos>tar||idx==arr.length)
        {
            return;
        }
        printTargetSumSubsets(arr,idx+1,set+arr[idx]+", ",sos+arr[idx],tar);
         printTargetSumSubsets(arr,idx+1,set,sos,tar);
        
        
    }

}