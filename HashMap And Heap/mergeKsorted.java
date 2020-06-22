// Question
// 1. You are given a list of lists, where each list is sorted.
// 2. You are required to complete the body of mergeKSortedLists function. The function is expected to merge k sorted lists to create one sorted list.
// Input Format
// Input is managed for you
// Output Format
// Output is managed for you
// Constraints
// Space complextiy = O(k)
// Time complexity = nlogk
// where k is the number of lists and n is number of elements across all lists
// Sample Input
// 4
// 5
// 10 20 30 40 50
// 7
// 5 7 9 11 19 55 57
// 3
// 1 2 3
// 2
// 32 39
// Sample Output
// 1 2 3 5 7 9 10 11 19 20 30 32 39 40 50 55 57 



import java.io.*;
import java.util.*;

public class Main {
    public static class Pair implements Comparable<Pair>{
        int li;
        int di;
        int val;
        Pair(int li,int di,int val){
            this.li=li;
            this.di=di;
            this.val=val;
        }
        public int compareTo(Pair other){
            return this.val-other.val;
        }
    }
   public static ArrayList<Integer> mergeKSortedLists(ArrayList<ArrayList<Integer>> lists){
      ArrayList<Integer> rv = new ArrayList<>();

      // write your code her
      PriorityQueue<Pair> pq=new PriorityQueue<>();
      for(int lIdx=0;lIdx<lists.size();lIdx++){
          ArrayList<Integer> iList=lists.get(lIdx);
          int val=iList.get(0);
          pq.add(new Pair(lIdx,0,val));
      }
      while(pq.size()>0){
          Pair minPair=pq.remove();
          rv.add(minPair.val);
          minPair.di++;
          if(minPair.di<lists.get(minPair.li).size()){
              minPair.val=lists.get(minPair.li).get(minPair.di);
              pq.add(minPair);
          }
      }
      return rv;
   }

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int k = Integer.parseInt(br.readLine());
      ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
      for(int i = 0; i < k; i++){
         ArrayList<Integer> list = new ArrayList<>();

         int n = Integer.parseInt(br.readLine());
         String[] elements = br.readLine().split(" ");
         for(int j = 0; j < n; j++){
            list.add(Integer.parseInt(elements[j]));
         }

         lists.add(list);
      }

      ArrayList<Integer> mlist = mergeKSortedLists(lists);
      for(int val: mlist){
         System.out.print(val + " ");
      }
      System.out.println();
   }

}