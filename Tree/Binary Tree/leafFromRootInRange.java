// Question
//   1. You are given a partially written BinaryTree class.
// 2. You are given a value lo and a value hi
// 3. You are required to complete the body of pathToLeafFromRoot function. The function is expected to print all paths from root to leaves which have sum of nodes in range from lo to hi (both inclusive). The elements in path should be separated by spaces. Each path should be in a separate line.
// 4. Input is managed for you. 

                               
                               
// Input Format
// Input is managed for you
// Output Format
// The elements in path should be separated by spaces. Each path should be in a separate line.
// Constraints
// None
// Sample Input
// 23
// 50 25 12 n n 37 30 n n 40 n n 75 62 60 n n 70 n n 87 n n
// 150
// 250
// Sample Output
// 50 25 37 40
// 50 75 62 60
// 50 75 87


public static void pathToLeafFromRoot(Node node, String path, int sum, int lo, int hi){
    // write your code here
    if(node==null){
        return;
    }
    if(node.left==null&&node.right==null){
        sum+=node.data;
        path+=node.data;
        if(sum<hi&&sum>lo){
        System.out.println(path);
        }
        return;
    }
    pathToLeafFromRoot(node.left,path+node.data+" ",sum+node.data,lo,hi);
    pathToLeafFromRoot(node.right,path+node.data+" ",sum+node.data,lo,hi);
  }