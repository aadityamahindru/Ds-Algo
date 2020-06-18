// Question
// 1. You are given a partially written BST class.
// 2. You are required to complete the body of lca function. "lca" function is expected to find the lowest commong ancestor of d1 and d2.
// 3. Input and Output is managed for you. 

// Note -> Please watch the question video for clarity.
// Input Format
// Input is managed for you
// Output Format
// Output is managed for you
// Constraints
// None
// Sample Input
// 21
// 50 25 12 n n 37 30 n n n 75 62 60 n n 70 n n 87 n n
// 12
// 30
// Sample Output
// 25



public static int lca(Node node, int d1, int d2) {
    // write your code here
    if(node ==null){
        return -1;
    }
    if((d1<=node.data&&d2>=node.data)||(d1>=node.data&&d2<=node.data)){
        return node.data;
    }else if(d1<node.data&&d2<node.data){
        int l=lca(node.left,d1,d2);
        return l;
    }else{
        int r=lca(node.right,d1,d2);
        return r;
    }
  }