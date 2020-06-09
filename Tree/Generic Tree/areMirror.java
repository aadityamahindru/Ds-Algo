// Question
//   1. You are given a partially written GenericTree class.
// 2. You are required to complete the body of areMirror function. The function is expected to check if the two trees passed to it are mirror images of each other in shape (data not to be checked, just the shape of tree).
// Note -> Watch the question video for clarity.
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
// 12
// 100 200 -1 300 500 -1 600 -1 -1 400 -1 -1
// Sample Output
// true






 public static boolean areMirror(Node n1, Node n2) {
    // write your code here
    if(n1.children.size()!=n2.children.size()){
       return false;
    }
     for(int i=0;i<n1.children.size();i++){
            int j=n2.children.size()-i-1;
            Node ch1=n1.children.get(i);
            Node ch2=n2.children.get(j);
            if(areMirror(ch1,ch2)==false){
                return false;
            }
        }
        return true;
  }