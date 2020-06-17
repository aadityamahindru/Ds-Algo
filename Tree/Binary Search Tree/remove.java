// Question
// 1. You are given a partially written BST class.
// 2. You are required to complete the body of remove function. "remove" function is expected to remove a new node with given data to the tree and return the new root.
// 3. Input and Output is managed for you. 

// Note -> Please watch the question video to figure out the algorithm required for deletion. It specifies some requirements of the question as well.
// Input Format
// Input is managed for you
// Output Format
// Output is managed for you
// Constraints
// None
// Sample Input
// 15
// 50 25 12 n n 37 n n 75 62 n n 87 n n
// 62
// Sample Output
// 25 <- 50 -> 75
// 12 <- 25 -> 37
// . <- 12 -> .
// . <- 37 -> .
// . <- 75 -> 87
// . <- 87 -> .



public static Node max(Node node){
        while(node.right!=null){
            node=node.right;
        }
        return node;
    }
  public static Node remove(Node node, int data) {
    // write your code  herei
    if(data<node.data){
        node.left=remove(node.left,data);
    }else if(data>node.data){
        node.right=remove(node.right,data);
    }else{
        if(node.left==null&&node.right==null){
            return null;
        }else if(node.right==null){
            return node.left;
        }else if(node.left==null){
            return node.right;
        }else{
            Node maxNode=max(node.left);
            int temp=maxNode.data;
            maxNode.data=node.data;
            node.data=temp;
            node.left=remove(node.left,data);
        }
    }
    return node;
  }
