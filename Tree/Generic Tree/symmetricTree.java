// Question
//  1. You are given a partially written GenericTree class.
// 2. You are required to complete the body of IsSymmetric function. The function is expected to check if the tree is symmetric, if so return true otherwise return false. For knowing symmetricity think of face and hand. Face is symmetric while palm is not. Also, we are check only smmetricity of shape and not content. Check the question video for clarity.
// 3. Input and Output is managed for you. 
                               
// Input Format
// Input is managed for you
// Output Format
// Output is managed for you
// Constraints
// None
// Sample Input
// 20
// 10 20 50 -1 60 -1 -1 30 70 -1 80 -1 90 -1 -1 40 100 -1 110 -1 -1 -1
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
  public static boolean IsSymmetric(Node node) {
    // write your code here
    return areMirror(node,node);
  }
