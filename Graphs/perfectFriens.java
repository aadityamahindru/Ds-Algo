// Question
// 1. You are given a number n (representing the number of students). Each student will have an id from 0 to n - 1.
// 2. You are given a number k (representing the number of clubs)
// 3. In the next k lines, two numbers are given separated by a space. The numbers are ids of students belonging to same club.
// 4. You have to find in how many ways can we select a pair of students such that both students are from different clubs.
// Input Format
// Input has been managed for you
// Output Format
// Check the sample output
// Constraints
// None
// Sample Input
// 7
// 5
// 0 1
// 2 3
// 4 5
// 5 6
// 4 6
// Sample Output
// 16

import java.io.*;
import java.util.*;

public class Main {
   static class Edge {
      int src;
      int nbr;
      Edge(int src, int nbr){
         this.src = src;
         this.nbr = nbr;
      }
   }
   public static void main(String[] args) throws Exception {
      Scanner sc=new Scanner(System.in);
      int n = sc.nextInt();
      int k = sc.nextInt();
      ArrayList<Edge> graph[]=new ArrayList[n];
      for(int i=0;i<n;i++){
          graph[i]=new ArrayList<>();
      }
      for(int i=0;i<k;i++){
          int v1=sc.nextInt();
          int v2=sc.nextInt();
          graph[v1].add(new Edge(v1,v2));
          graph[v2].add(new Edge(v2,v1));
      }
      // write your code here
      System.out.println(perfectFriends(graph));
   }
    public static int perfectFriends(ArrayList<Edge> graph[]){
        ArrayList<ArrayList<Integer>> clubs=getAllClubs(graph);
        ArrayList<Integer> clubFreq=new ArrayList<>();
        for(ArrayList<Integer> club:clubs){
            clubFreq.add(club.size());
        }
        int noc=0;
        for(int i=0;i<clubFreq.size();i++){
            for(int j=i+1;j<clubFreq.size();j++){
                noc+=clubFreq.get(i)*clubFreq.get(j);
            }
        }
        return noc;
    }
    public static ArrayList<ArrayList<Integer>> getAllClubs(ArrayList<Edge> graph[]){
      ArrayList<ArrayList<Integer>> clubs = new ArrayList<>();
      boolean visited[]=new boolean[graph.length];
      for(int vtx=0;vtx<graph.length;vtx++){
          if(visited[vtx]==false){
             ArrayList<Integer> comp= new ArrayList<Integer>();
             gcc(graph,vtx,visited,comp);
              clubs.add(comp);
          }
      }
      return clubs;
   }
   public static void gcc(ArrayList<Edge> graph[],int vtx,boolean visited[],ArrayList<Integer> comp){
      visited[vtx]=true;
      comp.add(vtx);
      for(Edge e:graph[vtx]){
          if(visited[e.nbr]==false){
              gcc(graph,e.nbr,visited,comp);
          }
      }
   }
}