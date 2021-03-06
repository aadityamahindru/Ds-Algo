// Question
// 1. You are given a number n, representing the size of array a.
// 2. You are given n numbers, representing elements of array a.
// 3. You are required to print the longest sequence of consecutive elements in the array (ignoring duplicates)

// Note -> In case there are two sequences of equal length (and they are also the longest), then print the one for which the starting point of which occurs first in the array.
// Input Format
// A number n
// n1
// n2
// .. n number of elements
// Output Format
// Elements of longest sequence of consecutive elements of array in separate lines (ignoring duplicates)
// Constraints
// 1 <= n <= 30
// 0 <= n1, n2, .. n elements <= 15
// Sample Input
// 17
// 12
// 5
// 1
// 2
// 10
// 2
// 13
// 7
// 11
// 8
// 9
// 11
// 8
// 9
// 5
// 6
// 11
// Sample Output
// 5
// 6
// 7
// 8
// 9
// 10
// 11
// 12
// 13


import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    int a[]=new int[n];
    for(int i=0;i<n;i++){
        a[i]=sc.nextInt();
    }
    HashMap<Integer,Boolean> hm=new HashMap<>();
    for(int key:a){
        hm.put(key,true);
    }
    for(int key:hm.keySet()){
        if(hm.containsKey(key-1)){
            hm.put(key,false);
        }
    }
    int sp=-1;;
    int size=0;
    for(int i=0;i<n;i++){
        int key=a[i];
        if(hm.get(key)==true){
            int nextEle=key+1;
            int lsize=1;
            while(hm.containsKey(nextEle)){
                nextEle++;
                lsize++;
            }
            if(lsize>size){
                size=lsize;
                sp=key;
            }
        }
    }
    for(int i=0;i<size;i++){
        System.out.println(sp+i);
    }
 }
}