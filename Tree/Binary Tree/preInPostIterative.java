//  Question
//   1. You are given a partially written BinaryTree class.
// 2. You are required to complete the body of iterativePrePostInTraversal function. The function is expected to print pre order, in order and post order of the tree in separate lines (first pre, then in and finally post order). All elements in an order must be separated by a space.
// 3. Input is managed for you. 
                               
                               
// Input Format
// Input is managed for you
// Output Format
// pre order (elements separated by space)
// in order (elements separated by space)
// post order (elements separated by space)
// Constraints
// None
// Sample Input
// 19
// 50 25 12 n n 37 30 n n n 75 62 n 70 n n 87 n n
// Sample Output
// 50 25 12 37 30 75 62 70 87 
// 12 25 30 37 50 62 70 75 87 
// 12 30 37 25 70 62 87 75 50 
 
 
 
 
 public static void iterativePrePostInTraversal(Node node) {
    String pre="",in="",post="";
    Stack<Pair> st=new Stack<>();
    st.push(new Pair(node,1));
    while(st.size()>0){
        Pair top=st.peek();
        if(top.state==1){
             pre+=top.node.data+" ";
            if(top.node.left!=null){
                st.push(new Pair(top.node.left,1));
            }
            top.state++;
        }else if(top.state==2){
             in+=top.node.data+" ";
            if(top.node.right!=null){
                st.push(new Pair(top.node.right,1));
            }
            top.state++;
        }else{
            post+=top.node.data+" ";
            st.pop();
        }
    }
    System.out.println(pre);
    System.out.println(in);
    System.out.println(post);
    // write your code here
  }