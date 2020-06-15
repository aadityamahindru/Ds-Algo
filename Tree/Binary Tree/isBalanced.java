// Question
// 1. You are given a partially written BinaryTree class.
// 2. You are required to check if the tree is balanced. A binary tree is balanced if for every node the gap between height's of it's left and right subtree is not more than 1.
// 3. Input is managed for you. 

// Note -> Please refer the question video for clarity.
// Input Format
// Input is managed for you.
// Output Format
// true if the tree is balanced, false otherwise
// Constraints
// Time complexity must be O(n)
// Space should not be more than required for recursion (call-stack)
// Sample Input
// 21
// 50 25 12 n n 37 30 n n 51 n n 75 62 60 n n 70 n n n
// Sample Output
// false


public static class bPair{
      int height;
      boolean gap;
  }
  public static bPair balanced(Node node){
      if(node==null){
          bPair base=new bPair();
          base.height=-1;
          base.gap=true;
          return base;
      }
      bPair left=balanced(node.left);
      bPair right=balanced(node.right);
      boolean gap=true;
      if(left.height-right.height>1){
          gap=false;
      }
      bPair myres=new bPair();
      myres.gap=left.gap&&right.gap&&gap;
      myres.height=Math.max(left.height,right.height)+1;
      return myres;
  }



  // approch 2 using static


static boolean isBalanced =true;
  public static int balanced1(Node node){
      if(node==null){
          return 0;
      }
      int h=-1;
      if(isBalanced){
       int ln=balanced1(node.left);
       int rn=balanced1(node.right);
       h=Math.max(ln,rn)+1;
       int difference=Math.abs(ln-rn);
       if(difference>1){
           isBalanced=false;
        }
      }
       return h;
  }