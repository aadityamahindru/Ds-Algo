import java.io.*;
import java.util.*;

public class Main {

  public static void radixSort(int[] arr) {
    //write your code here
    int max=Integer.MIN_VALUE;
    for(int val:arr){
        if(val>max){
            max=val;
        }
    }
    for(int exp=1,itr=1;max/exp>0;exp=exp*10,itr++){
        countSort(arr,exp,itr);
    }

  }

  public static void countSort(int[] arr, int exp, int itr) {
    //write your code here
    int farr[]=new int[10];
    for(int val:arr){
        int idx=(val/exp)%10;
        farr[idx]++;
    }
    for(int i=1;i<farr.length;i++){
        farr[i]+=farr[i-1];
    }
    int ans[]=new int[arr.length];
    for(int i=arr.length-1;i>=0;i--){
        int val=arr[i];
        int idx=(val/exp)%10;
        int pos=farr[idx];
        ans[pos-1]=val;
        farr[idx]--;
    }
    for(int i=0;i<arr.length;i++){
        arr[i]=ans[i];
    }
    System.out.print("After iteration no. "+itr+" -> ");
    print(arr);
  }

  public static void print(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();
  }

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }
    radixSort(arr);
    print(arr);
  }

}