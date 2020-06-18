//   Question
// 1. You are given a partially written BST class.
// 2. You are required to complete the body of pir function. "pir" function is expected to print all nodes between d1 and d2 (inclusive and in increasing order).
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
// 65
// Sample Output
// 12
// 25
// 30
// 37
// 50
// 60
// 62
  
  public static void pir(Node node, int d1, int d2) {
    // write your code here
    if(node==null ){
        return;
    }
    if(d1<node.data&&d2<node.data){
        pir(node.left,d1,d2);
    }else if(d1>node.data&&d2>node.data){
        pir(node.right,d1,d2);
    }else{
        pir(node.left,d1,d2);
        System.out.println(node.data);
        pir(node.right,d1,d2);
    }
  }