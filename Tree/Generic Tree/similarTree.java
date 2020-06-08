// Question
//  1. You are given a partially written GenericTree class.
// 2. You are required to complete the body of areSimilar function. The function is expected to check if the two trees passed to it are similar in shape or not.
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
// 24
// 1 2 5 -1 6 -1 -1 3 7 -1 8 11 -1 12 -1 -1 9 -1 -1 4 10 -1 -1 -1
// Sample Output
// true





 public static boolean areSimilar(Node n1, Node n2) {
    // write your code here
    if(n1.children.size()!=n2.children.size()){
       return false;
    }
     for(int i=0;i<n1.children.size();i++){
            Node ch1=n1.children.get(i);
            Node ch2=n2.children.get(i);
            if(areSimilar(ch1,ch2)==false){
                return false;
            }
        }
        return true;
  }