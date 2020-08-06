// Question
// 1. You are given an array(arr) of different dates in format DDMMYYYY.
// 2. You have to sort these dates in increasing order.
// Input Format
// An Integer N 
// arr1
// arr2..
// n integers
// Output Format
// Check the sample output and question video.
// Constraints
// 1 <= N <= 10000
// Sample Input
// 5
// 12041996
// 20101996
// 05061997
// 12041989
// 11081987
// Sample Output
// 11081987
// 12041989
// 12041996
// 20101996
// 5061997

import java.io.*;
import java.util.*;

public class Main {

  public static void sortDates(int[] arr) {
    //write your code here
    for(int i=1;i<=3;i++){
        countSort(arr,i);
    }

  }

  public static void countSort(int[] arr,int itr) {
    //write your code here
    int farr[];
    if(itr==1){
        farr=new int[32];
    }else if(itr==2){
        farr=new int[13];
    }else{
        farr=new int[10000];
    }
    for(int date:arr){
        if(itr==1){
            farr[(date/1000000)]++;
        }else if(itr==2){
            farr[(date/10000)%100]++;
        }else{
            farr[(date%10000)]++;
        }
    }
    for(int i=1;i<farr.length;i++){
        farr[i]+=farr[i-1];
    }
    int ans[]=new int[arr.length];
    for(int i=arr.length-1;i>=0;i--){
        int date=arr[i];
        int pos;
        if(itr==1){
            pos=farr[(date/1000000)]--;
        }else if(itr==2){
            pos=farr[(date/10000)%100]--;
        }else{
            pos=farr[(date%10000)]--;
        }
        ans[pos-1]=date;
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
    for (int i = 0; i < n; i++) {
      String str = scn.next();
      arr[i] = Integer.parseInt(str, 10);
    }
    sortDates(arr);
    print(arr);
  }

}