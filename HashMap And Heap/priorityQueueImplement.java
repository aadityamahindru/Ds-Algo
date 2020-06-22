// Question
//  1. You are required to complete the code of our PriorityQueue class using the heap data structure. Please watch the question video carefully. The theoretical details of required functionality is explained in detail there. Implement the functions to achieve what is explained in the theoretical discussion in question video.
// 2. Here is the list of functions that you are supposed to complete
// 2.1. add -> Should accept new data.
// 2.2. remove -> Should remove and return smallest value, if available or print "Underflow" otherwise and return -1
// 2.3. peek -> Should return smallest value, if available or print "Underflow" otherwise and return -1
// 2.4. size -> Should return the number of elements available
// 3. Input and Output is managed for you.



import java.io.*;
import java.util.*;

public class Main {

  public static class PriorityQueue {
    ArrayList<Integer> data;

    public PriorityQueue() {
      data = new ArrayList<>();
    }
    public void swap(int i,int j){
        int iVal=data.get(i);
        int jVal=data.get(j);
        data.set(i,jVal);
        data.set(j,iVal);
    }
    public void upheapify(int ci){
        if(ci==0){
            return;
        }
        int pi=(ci-1)/2;
        if(data.get(pi)>data.get(ci)){
            swap(pi,ci);
            upheapify(pi);
        }
    }
    public void add(int val) {
      // write your code here
      data.add(val);
      upheapify(data.size()-1);
    }
    public void downheapify(int pi){
        int lci=(pi*2)+1;
        int rci=(pi*2)+2;
        int minIdx=pi;
        if(lci<data.size()&&data.get(lci)<data.get(minIdx)){
            minIdx=lci;
        }
        if(rci<data.size()&&data.get(rci)<data.get(minIdx)){
            minIdx=rci;
        }
        if(minIdx!=pi){
            swap(minIdx,pi);
            downheapify(minIdx);
        }
    }
    public int remove() {
      // write your code here
      if(size()==0){
          System.out.println("Underflow");
          return -1;
      }
      swap(0,data.size()-1);
      int rEle=data.remove(data.size()-1);
      downheapify(0);
      return rEle;
    }

    public int peek() {
      // write your code here
      if(size()==0){
          System.out.println("Underflow");
          return -1;
      }
      return data.get(0);
    }

    public int size() {
      // write your code here
      return data.size();
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    PriorityQueue qu = new PriorityQueue();

    String str = br.readLine();
    while (str.equals("quit") == false) {
      if (str.startsWith("add")) {
        int val = Integer.parseInt(str.split(" ")[1]);
        qu.add(val);
      } else if (str.startsWith("remove")) {
        int val = qu.remove();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("peek")) {
        int val = qu.peek();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("size")) {
        System.out.println(qu.size());
      }
      str = br.readLine();
    }
  }
}