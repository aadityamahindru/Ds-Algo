// Question
//   1. You are given a partially written GenericTree class.
// 2. You are required to complete the body of nodeToRootPath function. The function is expected to return in form of linked list the path from element to root, if the element with data is found.
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
// [120, 80, 30, 10] 
 
 
 
 
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