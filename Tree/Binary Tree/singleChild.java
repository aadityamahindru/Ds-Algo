// Question
//  1. You are given a partially written BinaryTree class.
// 2. You are required to complete the body of printSingleChildNodes function. The function is expected to print in separate lines, all such nodes which are only child of their parent. Use preorder for traversal.
// 3. Input and Output is managed for you. 
                               
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
// 30
// 70

  public static void printSingleChildNodes(Node node, Node parent){
    // write your code here
    if(node==null){
        return;
    }
    if(parent!=null&&(parent.right==null||parent.left==null)){
       System.out.println(node.data);
    }
    printSingleChildNodes(node.left,node);
    printSingleChildNodes(node.right,node);
  }