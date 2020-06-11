import java.util.*;

public class Main{
public static class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data=data;
        left=null;
        right=null;
    }
    Node(int data, Node lchild,Node rchild){
        this.data=data;
        left=lchild;
        right=rchild;
    }
}
public static class Pair{
    Node node;
    int state;
    Pair(Node node , int state){
        this.node=node;
        this.state=state;
    }
}
public static Node construct(Integer[] input){
    Node root=new Node(input[0]);
    Stack<Pair> st=new Stack<>();
    st.push(new Pair(root,1));
    int i=1;
    while(st.size()>0){
        Pair top=st.peek();
        if(top.state==1){
            Integer val=input[i];
            if(val!=null){
                Node node =new Node(val);
                top.node.left=node;
                st.push(new Pair(node,1));
            }
            top.state++;
            i++;
        }else if(top.state==2){
            Integer val=input[i];
            if(val!=null){
                Node node =new Node(val);
                top.node.right=node;
                st.push(new Pair(node,1));
            }
            top.state++;
            i++;
        }else if(top.state==3){
            st.pop();
        }
    }
    return root;
}
public static void main(String[] args) {

// write your code here.
    Integer[] input={10,20,40,null,null,5,60,null,null,null,30,null,70,80,null,null,90,null,null};
    Node root =construct(input);

 }
}