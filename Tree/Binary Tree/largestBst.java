// Question
//   1. You are given a partially written BinaryTree class.
// 2. You are required to find the root of largest sub-tree which is a BST. Also, find the number of nodes in that sub-tree.
// 3. Input is managed for you. 

// Note -> Please refer the question video for clarity.
                               
                               
// Input Format
// Input is managed for you.
// Output Format
// @
// Constraints
// Time complexity must be O(n)
// Space should not be more than required for recursion (call-stack)
// Sample Input
// 23
// 50 25 12 n n 37 30 n n 51 n n 75 62 60 n n 70 n n 87 n n
// Sample Output
// 25@5 
 
 
 public static class bstPair{
      int max;
      int min;
      int size;
      Node root;
      boolean isTreeBst;
  }
  public static bstPair largestBst(Node node){
       if(node==null){
            bstPair base=new bstPair();
            base.min=Integer.MAX_VALUE;
            base.max=Integer.MIN_VALUE;
            base.size=0;
            base.root=null;
            base.isTreeBst=true;
            return base;
        }
        bstPair left =largestBst(node.left);
        bstPair right=largestBst(node.right);
        boolean nBst=node.data>=left.max&&node.data<=right.min;
        bstPair myres=new bstPair();
        myres.min=Math.min(node.data,Math.min(left.min,right.min));
        myres.max=Math.max(node.data,Math.max(left.max,right.max));
        myres.isTreeBst=left.isTreeBst&&nBst&&right.isTreeBst;
        if(myres.isTreeBst){
            myres.size=left.size+right.size+1;
            myres.root=node;
        }else{
            if(left.size>=right.size){
                myres.size=left.size;
                myres.root=left.root;
            }else{
                myres.size=right.size;
                myres.root=right.root;
            }
        }
        return myres;
      
  }