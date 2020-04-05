import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int r=sc.nextInt();
        int c=sc.nextInt();
        int a[][]=new int[n][n];
        printKnightsTour(a,r,c,1);
        System.out.println();
        
    }

    public static void printKnightsTour(int[][] chess,int row,int col, int mov) {
       int n=chess.length;
       if(row<0||col<0||row>=n||col>=n||chess[row][col]!=0)
       {
           return;
       }
       if(mov==n*n)
       {
            chess[row][col]=mov;
            displayBoard(chess);
             chess[row][col]=0;
             return;
           
       }
        chess[row][col]=mov;
        printKnightsTour(chess,row-2,col+1,mov+1);
        printKnightsTour(chess,row-1,col+2,mov+1);
        printKnightsTour(chess,row+1,col+2,mov+1);
        printKnightsTour(chess,row+2,col+1,mov+1);
        printKnightsTour(chess,row+2,col-1,mov+1);
        printKnightsTour(chess,row+1,col-2,mov+1);
        printKnightsTour(chess,row-1,col-2,mov+1);
        printKnightsTour(chess,row-2,col-1,mov+1);
        chess[row][col]=0;
        
        
    }

    public static void displayBoard(int[][] chess){
        for(int i = 0; i < chess.length; i++){
            for(int j = 0; j < chess[0].length; j++){
                System.out.print(chess[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
    }
}