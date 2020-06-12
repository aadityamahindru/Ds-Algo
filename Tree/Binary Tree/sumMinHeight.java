// Question
//  1. You are given a partially written BinaryTree class.
// 2. You are required to complete the body of size, sum, max and height function. The functions are expected to
// 2.1. size - return the number of nodes in BinaryTree
// 2.2. sum - return the sum of nodes in BinaryTree
// 2.3. max - return the highest node in BinaryTree
// 2.4. height - return the height of tree in terms of edges
// 3. Input and Output is managed for you. 
                               
// Input Format
// Input is managed for you
// Output Format
// Output is managed for you
// Constraints
// None
// Sample Input
// 19
// 50 25 12 n n 37 30 n n n 75 62 n 70 n n 87 n n
// Sample Output
// 9
// 448
// 87
// 3




 public static int size(Node node) {
    // write your code here
    if(node==null){
        return 0;
    }
    int lchild=size(node.left);
    int rchild=size(node.right);
    return lchild+rchild+1;
  }

  public static int sum(Node node) {
    // write your code here
    if(node==null){
        return 0;
    }
    int lchild=sum(node.left);
    int rchild=sum(node.right);
    int sum=lchild+rchild+node.data;
    return sum;
  }

  public static int max(Node node) {
    // write your code here
    if(node==null){
        return Integer.MIN_VALUE;
    }
    int lmax=max(node.left);
    int rmax=max(node.right);
    int max=Math.max(lmax,Math.max(rmax,node.data));
    return max;
    
  }

  public static int height(Node node) {
    // write your code here
     if(node==null){
      return -1;
    }
    int lchild=height(node.left);
    int rchild=height(node.right);
    int h=Math.max(lchild,rchild)+1;
    return h;
  }