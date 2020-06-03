
// Intersection Point Of Linked Lists
// Question
//    1. You are given a partially written LinkedList class.
// 2. You are required to complete the body of findIntersection function. The function is passed two linked lists which start separately but merge at a node and become common thereafter. The function is expected to find the point where two linked lists merge. You are not allowed to use arrays to solve the problem.
// 3. Input and Output is managed for you. 

                               
                               
                               
// Input Format
// Input is managed for you
// Output Format
// Output is managed for you
// Constraints
// 1. Time complexity -> O(n)
// 2. Space complexity -> constant
// Sample Input
// 5
// 1 2 3 4 5
// 8
// 11 22 33 44 55 66 77 88
// 2
// 3
// Sample Output
44


public static int findIntersection(LinkedList one, LinkedList two){
      // write your code here
      Node t1=one.head;
      Node t2=two.head;
      int diff=Math.abs(one.size-two.size);
      if(one.size>two.size){
          for(int i=0;i<diff;i++){
              t1=t1.next;
          }
      }else{
           for(int i=0;i<diff;i++){
              t2=t2.next;
          }
      }
      while(t1!=t2){
          t1=t1.next;
          t2=t2.next;
      }
      return t1.data;
    }