import java.io.*;
import java.util.*;

public class Main {

  public static void countSort(int[] arr, int min, int max) {
   //write your code here
   int farr[]=new int[max-min+1];
   for(int val : arr){
       int idx=val-min;
       farr[idx]++;
   }
   // making prefix sum array
   for(int i=1;i<farr.length;i++){
       farr[i]+=farr[i-1];
   }
   // making sorted stable array
   int ans[]=new int[arr.length];
   for(int i=arr.length-1;i>=0;i--){
       int val=arr[i];
       int pos=farr[val-min];
       ans[pos-1]=val;
       farr[val-min]--;
   }
   for(int i=0;i<arr.length;i++){
       arr[i]=ans[i];
   }
  }

  public static void print(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.println(arr[i]);
    }
  }

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;
    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
      max = Math.max(max, arr[i]);
      min = Math.min(min, arr[i]);
    }
    countSort(arr,min,max);
    print(arr);
  }

}