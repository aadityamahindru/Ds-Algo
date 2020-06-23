// Question
//  1. You are given a partially written LinkedList class.
// 2. You are required to complete the body of mergeTwoSortedLists function. The function is static and is passed two lists which are sorted. The function is expected to return a new sorted list containing elements of both lists. Original lists must stay as they were.
// 3. Input and Output is managed for you. 
                               
// Input Format
// Input is managed for you
// Output Format
// Output is managed for you
// Constraints
// 1. O(n) time complexity and constant space complexity expected.
// Sample Input
// 5
// 10 20 30 40 50
// 10
// 7 9 12 15 37 43 44 48 52 56
// Sample Output
// 7 9 10 12 15 20 30 37 40 43 44 48 50 52 56 
// 10 20 30 40 50 
// 7 9 12 15 37 43 44 48 52 56 

    public static LinkedList mergeTwoSortedLists(LinkedList l1, LinkedList l2) {
      // write your code hered
      LinkedList ls=new LinkedList();
      Node lis1=l1.head;
      Node lis2=l2.head;
      while(lis1!=null&&lis2!=null)
      {
          if(lis1.data<=lis2.data)
          {
              ls.addLast(lis1.data);
               lis1=lis1.next;
          }else{
              ls.addLast(lis2.data);
              lis2=lis2.next;
          }
      }
      while(lis1!=null)
      {
          ls.addLast(lis1.data);
          lis1=lis1.next;
      }
      while(lis2!=null)
      {
          ls.addLast(lis2.data);
          lis2=lis2.next;
      }
      return ls;
    }
  }