// Question
// 1. You are given a 2d array where 0's represent land and 1's represent water. Assume every cell is linked to it's north, east, west and south cell.
// 2. You are required to find and count the number of islands.
// Input Format
// Input has been managed for you
// Output Format
// Number of islands
// Constraints
// None
// Sample Input
// 8
// 8
// 0 0 1 1 1 1 1 1
// 0 0 1 1 1 1 1 1
// 1 1 1 1 1 1 1 0
// 1 1 0 0 0 1 1 0
// 1 1 1 1 0 1 1 0
// 1 1 1 1 0 1 1 0
// 1 1 1 1 1 1 1 0
// 1 1 1 1 1 1 1 0
// Sample Output
// 3

import java.io.*;
import java.util.*;

public class Main {
   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int m = Integer.parseInt(br.readLine());
      int n = Integer.parseInt(br.readLine());
      int[][] arr = new int[m][n];

      for (int i = 0; i < arr.length; i++) {
         String parts = br.readLine();
         for (int j = 0; j < arr[0].length; j++) {
            arr[i][j] = Integer.parseInt(parts.split(" ")[j]);
         }
      }

      // write your code here
      System.out.println(island(arr));
   }
    public static int island(int area[][]){
        boolean visited[][]=new boolean[area.length][area[0].length];
        int size=0;
        for(int i=0;i<area.length;i++){
            for(int j=0;j<area[0].length;j++){
                if(!visited[i][j]&&area[i][j]==0){
                    gcc(area,i,j,visited);
                    size++;
                }
            }
        }
        return size;
    }
    public static void gcc(int area[][],int x,int y,boolean visited[][]){
        visited[x][y]=true;
        if(x-1>=0 && !visited[x-1][y]&& area[x-1][y]==0)
            gcc(area,x-1,y,visited);
        if(y+1<area[0].length && !visited[x][y+1]&& area[x][y+1]==0)
            gcc(area,x,y+1,visited);
        if(x+1<area.length && !visited[x+1][y]&& area[x+1][y]==0)
            gcc(area,x+1,y,visited);
        if(y-1>=0 && !visited[x][y-1]&& area[x][y-1]==0)
            gcc(area,x,y-1,visited);
    }
}