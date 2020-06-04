// Question
//  1. You are given a partially written GenericTree class.
// 2. You are required to complete the body of size function. The function is expected to count the number of nodes in the tree and return it.
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
// 6

public static int size(Node node){
    // write your code here
    int ans=0;
     for(int i=0;i<node.children.size();i++){
         ans+=size(node.children.get(i));
     }
     ans +=1;
     return ans;
  }