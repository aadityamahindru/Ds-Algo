//  Question
//   1. You are given a partially written GenericTree class.
// 2. You are required to complete the body of levelorderLineWiseZZ function. The function is expected to visit every node in "levelorder fashion" but in a zig-zag manner i.e. 1st level should be visited from left to right, 2nd level should be visited from right to left and so on. All nodes on same level should be separated by a space. Different levels should be on separate lines. Please check the question video for more details.
// 3. Input is managed for you. 
                               
                               
// Input Format
// Input is managed for you
// Output Format
// All nodes on the same level should be separated by a space.
// 1st level should be visited left to right, 2nd from right to left and so on alternately.
// All levels on separate lines starting from top to bottom.
// Constraints
// None
// Sample Input
// 24
// 10 20 50 -1 60 -1 -1 30 70 -1 80 110 -1 120 -1 -1 90 -1 -1 40 100 -1 -1 -1
// Sample Output
// 10 
40 30 20 
50 60 70 80 90 100 
120 110 
 
 
 
 
  public static void levelOrderLinewiseZZ(Node node){
    // write your code here
    Stack<Node> ms=new Stack<>();
    Stack<Node> cs=new Stack<>();
    ms.push(node);
    int lvl=1;
    while(ms.size()>0){
        Node temp=ms.pop();
        System.out.print(temp.data+" ");
        if(lvl%2==0){
            for(int i=temp.children.size()-1;i>=0;i--){
               Node child=temp.children.get(i);
               cs.push(child); 
            }
        }else{
         for(Node child : temp.children){
            cs.push(child);
         }
        }
        if(ms.size()==0)
        {
            System.out.println();
            ms=cs;
            cs=new Stack<>();
            lvl++;
        }
    }
  }
