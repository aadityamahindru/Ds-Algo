//   Question
//  1. You are given a partially written LinkedList class.
// 2. You are required to complete the body of reversePR and reversePRHelper functions. The functions are expected to reverse the linked list by using recursion and changing the "next" data member of nodes.
// 3. Input and Output is managed for you. 

// Note -> The online judge can't force you to write recursive function, nor can it check if you changed the "next" data member or not. But that is what the expectation is, the intention in to help you learn.

                               
// Input Format
// Input is managed for you
// Output Format
// Output is managed for you
// Constraints
// 1. Time complexity -> O(n)
// 2. Space complexity -> O(n)
// Sample Input
// 11
// 1 2 3 4 5 6 7 8 9 10 11
// 100
// 200
// Sample Output
// 1 2 3 4 5 6 7 8 9 10 11 
// 200 11 10 9 8 7 6 5 4 3 2 1 100 
  
  
  
  private void reversePRHelper(Node node){
      // write your code here
      if(node==null){
          return;
      }
      reversePRHelper(node.next);
      if(node==tail){
          return;
      }else{
          node.next.next=node;
      }
    }

    public void reversePR(){
      // write your code here
      reversePRHelper(head);
      head.next=null;
      Node temp=head;
      head=tail;
      tail=temp;
    }