// 1. You are given a number n, representing the size of array a.
// 2. You are given n numbers, representing the height of bars in a bar chart.
// 3. You are required to find and print the area of largest rectangle in the histogram.

// e.g.
// for the array [6 2 5 4 5 1 6] -> 12
                               
// Sample Input
// 7
// 6
// 2
// 5
// 4
// 5
// 1
// 6
// Sample Output
// 12


import java.io.*;
import java.util.*;

public class Main{
  
public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] a = new int[n];
    for(int i = 0; i < n; i++){
       a[i] = Integer.parseInt(br.readLine());
    }
    Stack<Integer> st=new Stack<>();
    int lb[]=new int[n];
    int rb[]=new int[n];
    for(int i=0;i<n;i++)
    {
        while(st.size()>0&&a[st.peek()]>=a[i]){
            st.pop();
        }
        if(st.size()==0){
            lb[i]=-1;
        }else{
            lb[i]=st.peek();
        }
        st.push(i);
    }
    st=new Stack<>();
    for(int i=n-1;i>=0;i--)
    {
        while(st.size()>0&&a[st.peek()]>=a[i]){
            st.pop();
        }
        if(st.size()==0){
            rb[i]=n;
        }else{
            rb[i]=st.peek();
        }
        st.push(i);
    }
    // code
    int max=0;
    for(int i=0;i<n;i++)
    {
        int width=rb[i]-lb[i]-1;
        int ans=width*a[i];
        if(ans>max){
            max=ans;
        }
    }
    System.out.println(max);
 }
}