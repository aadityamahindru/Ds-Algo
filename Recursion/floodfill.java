import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int arr[][]=new int[n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                arr[i][j]=sc.nextInt();
            }
        }
        floodfill(arr,0,0,"");
    }

    public static void floodfill(int[][] maze, int row, int col, String psf){
        int n=maze.length;
        int m=maze[0].length;
        if(row==n-1&&col==m-1)
        {
            System.out.println(psf);
            return;
        }
        if(row<0||col<0||row>n-1||col>m-1||maze[row][col]==1)
        {
            return;
        }
            maze[row][col]=1;
            floodfill(maze,row-1,col,psf+"t");
            floodfill(maze,row,col-1,psf+"l");
            floodfill(maze,row+1,col,psf+"d");
            floodfill(maze,row,col+1,psf+"r");
            maze[row][col]=0;
    }
}