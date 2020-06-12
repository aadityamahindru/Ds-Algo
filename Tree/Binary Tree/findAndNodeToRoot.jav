// Question
//  1. You are given a partially written BinaryTree class.
// 2. You are given an element.
// 3. You are required to complete the body of find and nodeToRoot function. The functions are expected to 
// 3.1. find -> return true or false depending on if the data is found in binary tree.
// 3.2. nodeToRoot -> returns the path from node (correspoding to data) to root in form of an arraylist (root being the last element)
// 4. Input iand Output is managed for you. 
                               
// Input Format
// Input is managed for you
// Output Format
// Output is managed for you
// Constraints
// None
// Sample Input
// 19
// 50 25 12 n n 37 30 n n n 75 62 n 70 n n 87 n n
// 30
// Sample Output
// true
// [30, 37, 25, 50]  
  
  public static boolean find(Node node, int data){
    // write your code here
    if(node==null){
        return false;
    }
    if(node.data==data){
        return true;
    }
    if(find(node.left,data)){
        return true;
    }else if(find(node.right,data)){
        return true;
    }
    return false;
  }


  public static ArrayList<Integer> nodeToRootPath(Node node, int data){
    // write your code here
    if(node==null){
        return new ArrayList<Integer>();
    }
    if(node.data==data){
         ArrayList<Integer> res=new ArrayList<>();
         res.add(data);
         return res;
    }
      ArrayList<Integer> left=nodeToRootPath(node.left,data);
      if(left.size()>0){
          left.add(node.data);
          return left;
      }
       ArrayList<Integer> right=nodeToRootPath(node.right,data);
      if(right.size()>0){
          right.add(node.data);
          return right;
      }
     return new ArrayList<Integer>();
  }