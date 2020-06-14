// Question
//  1. You are given a partially written BinaryTree class.
// 2. You are required to complete the body of diameter1 function. The function is expected to return the number of edges between two nodes which are farthest from each other in terms of edges.
// 3. Input and Output is managed for you. 

                               
// Input Format
// Input is managed for you.
// Output Format
// Output is managed for you. 
// Constraints
// None
// Sample Input
// 19
// 50 25 12 n n 37 30 n n n 75 62 n 70 n n 87 n n
// Sample Output
// 6  
  
  
   public static class diaPair{
        int diameter;
        int height;
    }
    public static diaPair diameter2(Node node){
        if(node==null){
            diaPair base=new diaPair();
            base.diameter=0;
            base.height=-1;
            return base;
        }
        diaPair lPair= diameter2(node.left);
        diaPair rPair=diameter2(node.right);
        int localDia=lPair.height+rPair.height+2;
        diaPair myres=new diaPair();
        myres.diameter=Math.max(localDia,Math.max(lPair.diameter,rPair.diameter));
        myres.height=Math.max(lPair.height,rPair.height)+1;
        return myres;
    }





    //another approch as used in generic tree (travel and change)

  static int dia=-1;
  public static int diameter1(Node node) {
    // write your code here
    if(node==null){
        return -1;
    }
    int h=-1;
    int ld=diameter1(node.left);
    int rd=diameter1(node.right);
    h=Math.max(h,Math.max(rd,ld));
    int d=ld+rd+2;
    if(d>dia){
        dia=d;
    }
    return h+1;
  }
