// Question
//  1. You are given a partially written BinaryTree class.
// 2. You are required to complete the body of levelorder function. The function is expected to print tree level by level, left to right. Each level must be on a separate line and elements of same level should be separated by space
// 3. Input is managed for you. 
                               
// Input Format
// Input is managed for you
// Output Format
// Each level must be on a separate line and elements of same level should be separated by space
// Constraints
// None
// Sample Input
// 19
// 50 25 12 n n 37 30 n n n 75 62 n 70 n n 87 n n
// Sample Output
// 50 
// 25 75 
// 12 37 62 87 
// 30 70 


 public static void levelOrder(Node node) {
    // write your code here
    Queue<Node> mq=new ArrayDeque<>();
    Queue<Node> cq=new ArrayDeque<>();
    mq.add(node);
    while(mq.size()>0){
        Node temp=mq.remove();
        System.out.print(temp.data+" ");
        if(temp.left!=null){
            cq.add(temp.left);
        }
        if(temp.right!=null){
            cq.add(temp.right);
        }
        if(mq.size()==0){
            System.out.println();
            mq=cq;
            cq=new ArrayDeque<>();
        }
    }
  }
