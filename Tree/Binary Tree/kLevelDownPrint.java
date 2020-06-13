// Question
//  1. You are given a partially written BinaryTree class.
// 2. You are given a value k.
// 3. You are required to complete the body of printKLevelsDown function. The function is expected to print in different lines all nodes which are k level deep. Use preorder for printing.
// 4. Input is managed for you. 
                               
// Input Format
// Input is managed for you
// Output Format
// All nodes k-level deep printed in separated lines and visited in preorder
// Constraints
// None
// Sample Input
// 19
// 50 25 12 n n 37 30 n n n 75 62 n 70 n n 87 n n
// 3
// Sample Output
// 30
// 70


public static void printKLevelsDown(Node node, int k){
    // write your code here
    if(node==null){
        return;
    }
    if(k==0){
        System.out.println(node.data);
        return;
    }
    printKLevelsDown(node.left,k-1);
    printKLevelsDown(node.right,k-1);
  }