// Question
//   1. You are given a partially written GenericTree class.
// 2. You are required to complete the body of lca function. The function is expected to return the lowest common ancestor of two data values that are passed to it. 
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
// 120
// 80
// Sample Output
// 80  
  
  
  
  
  public static ArrayList<Integer> nodeToRootPath(Node node, int data) {
    if (node.data == data) {
      ArrayList<Integer> path = new ArrayList<>();
      path.add(node.data);
      return path;
    }

    for (Node child : node.children) {
      ArrayList<Integer> ptc = nodeToRootPath(child, data);
      if (ptc.size() > 0) {
        ptc.add(node.data);
        return ptc;
      }
    }

    return new ArrayList<>();
  }

  public static int lca(Node node, int d1, int d2) {
    // write your code here
    ArrayList<Integer> p1=nodeToRootPath(node,d1);
    ArrayList<Integer> p2=nodeToRootPath(node,d2);
    int i=p1.size()-1;
    int j=p2.size()-1;
    while(i>=0&&j>=0&&p1.get(i)==p2.get(j)){
        i--;
        j--;
    }
    i++;
    j++;
    return p1.get(i);
  }
