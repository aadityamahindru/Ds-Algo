// Question
//   1. You are given a partially written GenericTree class.
// 2. You are required to complete the body of find function. The function is expected to find the given data in the tree, if found it should return true or return false.
// 3. Input and Output is managed for you. 
                               
                               
// Input Format
// Input is managed for you
// Output Format
// Output is managed for you
// Constraints
// None
// Sample Input
// 24
// 10 20 50 -1 60 -1 -1 30 70 -1 80 110 -1 120 -1 -1 90 -1 -1 40 100 -1 -1 -1
// 120
// Sample Output
// true



  public static boolean find(Node node, int data) {
    // write your code here
    if(node.data==data){
        return true;
    }
    for(Node child: node.children){
       boolean ans= find(child,data);
       if(ans==true){
           return ans;
       }
    }
    return false;
  }