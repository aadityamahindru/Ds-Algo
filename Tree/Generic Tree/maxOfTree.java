// Question
//  1. You are given a partially written GenericTree class.
// 2. You are required to complete the body of max function. The function is expected to find the node with maximum value and return it.
// 3. Input and Output is managed for you. 

                               
// Input Format
// Input is managed for you
// Output Format
// Output is managed for you
// Constraints
// None
// Sample Input
// 12
// 10 20 -1 30 50 -1 60 -1 -1 40 -1 -1
// Sample Output
// 60

 public static int max(Node node) {
    // write your code here
    int m=Integer.MIN_VALUE;
    for(int i=0;i<node.children.size();i++){
        m=Math.max(m,max(node.children.get(i)));
    }
    m=Math.max(m,node.data);
    return m;
  }
