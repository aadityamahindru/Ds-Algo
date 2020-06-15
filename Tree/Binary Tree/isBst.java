// Question
// 1. You are given a partially written BinaryTree class.
// 2. You are required to check if the tree is a Binary Search Tree (BST) as well. In a BST every node has a value greater than all nodes on it's left side and smaller value than all node on it's right side.
// 3. Input is managed for you. 

// Note -> Please refer the question video for clarity.
// Input Format
// Input is managed for you.
// Output Format
// true if the tree is a BST, false otherwise
// Constraints
// Time complexity must be O(n)
// Space should not be more than required for recursion (call-stack)
// Sample Input
// 19
// 50 25 12 n n 37 30 n n n 75 62 n 49 n n 87 n n
// Sample Output
// false

 public static class bstPair{
        int min;
        int max;
        boolean isTreeBst;
    } 
    public static bstPair isBst(Node node){
        if(node==null){
            bstPair base=new bstPair();
            base.min=Integer.MAX_VALUE;
            base.max=Integer.MIN_VALUE;
            base.isTreeBst=true;
            return base;
        }
        bstPair left =isBst(node.left);
        bstPair right=isBst(node.right);
        boolean nBst=node.data>=left.max&&node.data<=right.min;
        bstPair myres=new bstPair();
        myres.min=Math.min(node.data,Math.min(left.min,right.min));
        myres.max=Math.max(node.data,Math.max(left.max,right.max));
        myres.isTreeBst=left.isTreeBst&&nBst&&right.isTreeBst;
        return myres;
    }