//  Question
// 1. You are given a partially written BinaryTree class.
// 2. You are required to complete the body of tilt function. The function is expected to set the value of data member "tilt". "tilt" of a node is the absolute value of difference between sum of nodes in it's left subtree and right subtree. "tilt" of the whole tree is represented as the sum of "tilt"s of all it's nodes.
// 3. Input and Output is managed for you. 

// Note -> Please refer the video for clarity.
// Input Format
// Input is managed for you.
// Output Format
// Output is managed for you. 
// Constraints
// None
// Sample Input
// 19
// 50 25 12 n n 37 30 n n n 75 62 n 70 n n 87 n n
// Sample Output
// 390
 
 
 
 static int tilt = 0;
  public static int tilt(Node node){
    // write your code here to set the tilt data member
    if(node==null){
        return 0;
    }
    int l=tilt(node.left);
    int r=tilt(node.right);
    tilt+=Math.abs(l-r);
    return l+r+node.data;
  }



  // pair approch
   public static class tPair{
        int sum;
        int tilt;
    }
    public static tPair tilt1(Node node){
        if(node==null){
            tPair base=new tPair();
            base.sum=0;
            base.tilt=0;
            return base;
        }
        tPair left=tilt1(node.left);
        tPair right=tilt1(node.right);
        tPair res=new tPair();
        res.tilt=Math.abs(left.sum-right.sum)+left.tilt+right.tilt;
        res.sum=left.sum+right.sum+node.data;
        return res;
    }