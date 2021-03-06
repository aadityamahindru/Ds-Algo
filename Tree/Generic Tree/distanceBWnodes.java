//  Question
//   1. You are given a partially written GenericTree class.
// 2. You are required to complete the body of distanceBetweenNodes function. The function is expected to return the distance (in terms of number of edges) between two nodes in a generic tree.
// Please watch the question video to understand what lca is.
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
// 100
// 110
// Sample Output
// 5
 
 
 
 public static ArrayList<Integer> nodeToRootPath(Node node, int data){
    // write your code here
    if(node.data==data){
        ArrayList<Integer> res=new ArrayList<>();
        res.add(node.data);
        return res;
    }
    for(Node child: node.children){
        ArrayList<Integer> path=nodeToRootPath(child,data);
        if(path.size()>0){
            path.add(node.data);
            return path;
        }
    }
    ArrayList<Integer> res=new ArrayList<>();
        return res;
 }
 
 public static int distanceBetweenNodes(Node node, int d1, int d2){
    // write your code here
    ArrayList<Integer> p1 = nodeToRootPath(node, d1);
    ArrayList<Integer> p2 = nodeToRootPath(node, d2);

    int i = p1.size() - 1;
    int j = p2.size() - 1;

    while(i >= 0 && j >= 0 && p1.get(i) == p2.get(j)){
      i--;
      j--;
    }
    i++;
    j++;
    return (i+j);
  }