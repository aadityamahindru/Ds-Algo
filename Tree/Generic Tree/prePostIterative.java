// Question
//  1. You are given a partially written GenericTree class.
// 2. You are require to complete the body of function IterativePreandPostOrder. The function does not use recursion and prints preorder and postorder of the tree. Both orders are printed in separate lines (preorder first, followed by post order in next line). Elements in an order are separated by space.
// 3. Input and Output is managed for you. 
                               
// Input Format
// Input is managed for you
// Output Format
// Elements in preorder separated by a space
// Elements in postorder separated by a space
// Constraints
// None
// Sample Input
// 24
// 10 20 -50 -1 60 -1 -1 30 70 -1 -80 110 -1 -120 -1 -1 90 -1 -1 40 -100 -1 -1 -1
// Sample Output
// 10 20 -50 60 30 70 -80 110 -120 90 40 -100 
// -50 60 20 70 110 -120 -80 90 30 -100 40 10 




 public static void IterativePreandPostOrder(Node node) {
    // write your code here
    Stack<Pair> st=new Stack<>();
    String pre="",post="";
    st.push(new Pair(node,-1));
    while(st.size()>0){
        Pair top=st.peek();
        if(top.state==-1){
            pre +=top.node.data+" ";
            top.state++;
        }else if(top.state>=0&&top.state<top.node.children.size()){
            st.push(new Pair(top.node.children.get(top.state),-1));
            top.state++;
        }else if(top.state==top.node.children.size()){
            post += top.node.data+" ";
            st.pop();
        }
    }
    System.out.println(pre);
    System.out.println(post);
  }