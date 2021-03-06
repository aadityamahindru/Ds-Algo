// Question
//  1. You are given a partially written BinaryTree class.
// 2. You are required to complete the body of createLeftCloneTree function. The function is expected to create a new node for every node equal in value to it and inserted between itself and it's left child. Check question video for clarity.
// 3. Input and Output is managed for you. 
                               
// Input Format
// Input is managed for you.
// Output Format
// Output is managed for you. 
// Constraints
// None
// Sample Input
// 23
// 50 25 12 n n 37 30 n n 40 n n 75 62 60 n n 70 n n 87 n n
// Sample Output
// 50 <- 50 -> 75
// 25 <- 50 -> .
// 25 <- 25 -> 37
// 12 <- 25 -> .
// 12 <- 12 -> .
// . <- 12 -> .
// 37 <- 37 -> 40
// 30 <- 37 -> .
// 30 <- 30 -> .
// . <- 30 -> .
// 40 <- 40 -> .
// . <- 40 -> .
// 75 <- 75 -> 87
// 62 <- 75 -> .
// 62 <- 62 -> 70
// 60 <- 62 -> .
// 60 <- 60 -> .
// . <- 60 -> .
// 70 <- 70 -> .
// . <- 70 -> .
// 87 <- 87 -> .
// . <- 87 -> .  
  
  
  
  public static Node createLeftCloneTree(Node node){
    // write your code here
    if(node==null){
        return null;
    }
    Node ln= createLeftCloneTree(node.left);
    Node rn=createLeftCloneTree(node.right);
    Node nnode=new Node(node.data,node.left,null);
    node.left=nnode;
    return node;
  }
