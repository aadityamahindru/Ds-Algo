// Question
//  1. You are given a partially written LinkedList class.
// 2. You are required to complete the body of reverseDR function. The function is expected to reverse the linked list by using recursion and changing the "data" data member of nodes.
// 3. Input and Output is managed for you. 

// Note -> The online judge can't force you to write recursive function, nor can it check if you changed the "data" data member or not. But that is what the expectation is, the intention in to help you learn.

                               
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

   Node left;
    protected void reverseDRHelper(Node right,int floor){
        if(right==null){
            return;
        }
        reverseDRHelper(right.next,floor+1);
        if(floor>=size/2){
            int temp=right.data;
            right.data=left.data;
            left.data=temp;
            left=left.next;
        }
    }
    public void reverseDR() {
      // write your code here
      left=head;
      reverseDRHelper(head,0);
    }