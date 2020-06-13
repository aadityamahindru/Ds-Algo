// Question
//  1. You are given a partially written BinaryTree class.
// 2. You are given a value data and a value k.
// 3. You are required to complete the body of printKNodesFar function. The function is expected to print all nodes which are k distance away in any direction from node with value equal to data.
// 4. Input is managed for you. 
                               
// Input Format
// Input is managed for you
// Output Format
// All nodes which are k distance away in any direction from node with value equal to data, each in a separate line
// Constraints
// None
// Sample Input
// 19
// 50 25 12 n n 37 30 n n n 75 62 n 70 n n 87 n n
// 37
// 2
// Sample Output
// 12
// 50  
  
  
  public static ArrayList<Node> nodeToRootPath(Node node, int data){
    // write your code here
    if(node==null){
        return new ArrayList<Node>();
    }
    if(node.data==data){
         ArrayList<Node> res=new ArrayList<>();
         res.add(node);
         return res;
    }
      ArrayList<Node> left=nodeToRootPath(node.left,data);
      if(left.size()>0){
          left.add(node);
          return left;
      }
       ArrayList<Node> right=nodeToRootPath(node.right,data);
      if(right.size()>0){
          right.add(node);
          return right;
      }
     return new ArrayList<Node>();
  }
  public static void printKLevelsDown(Node node, int k,Node block){
    // write your code here
    if(node==null){
        return;
    }
    if(node==block){
        return;
    }
    if(k==0){
        System.out.println(node.data);
        return;
    }
    printKLevelsDown(node.left,k-1,block);
    printKLevelsDown(node.right,k-1,block);
  }
  public static void printKNodesFar(Node node, int data, int k) {
    // write your code here
    ArrayList<Node> path=nodeToRootPath(node,data);
    for(int i=0;i<path.size()&&i<=k;i++){
        Node block=null;
        if(i!=0){
            block=path.get(i-1);
        }
        printKLevelsDown(path.get(i),k-i,block);
    }
  }