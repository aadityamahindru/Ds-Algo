import java.util.*;

public class Main{
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
        }
        Node(int data,Node left,Node right){
            this.data=data;
            this.left=left;
            this.right=right;
        }
    }
    public static Node construct(int input[],int lo,int hi){
        if(lo>hi){
            return null;
        }
        
        int mid=(lo+hi)/2;
        int data=input[mid];
        Node lc=construct(input,lo,mid-1);
        Node rc=construct(input,mid+1,hi);
        Node node=new Node(data,lc,rc);
        return node;
    }
    public static void display(Node node){
    if(node==null){
        return;
    }
    String str="";
    if(node.left!=null){
        str+=node.left.data;
    }else{
        str+=".";
    }
    str += " <- "+node.data+" -> ";
    if(node.right!=null){
        str+=node.right.data;
    }else{
        str+=".";
    }
    System.out.println(str);
    display(node.left);
    display(node.right);
}

public static void main(String[] args) {

// write your code here
int input[]={12,25,37,50,67,75,82};
Node root =construct(input,0,input.length-1);
display(root);
 }
}