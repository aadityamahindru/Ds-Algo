// Question
// 1. You are given a partially written GenericTree class.
// 2. You are required to complete the body of levelorderLineWise function. The function is expected to visit every node in "levelorder fashion" and print them from left to right (level by level). All nodes on same level should be separated by a space. Different levels should be on separate lines. Please check the question video for more details.
// 3. Input is managed for you. 

                               
// Input Format
// Input is managed for you
// Output Format
// All nodes from left to right (level by level) all separated by a space.
// All levels on separate lines starting from top to bottom.
// Constraints
// None
// Sample Input
// 24
// 10 20 50 -1 60 -1 -1 30 70 -1 80 110 -1 120 -1 -1 90 -1 -1 40 100 -1 -1 -1
// Sample Output
// 10 
// 20 30 40 
// 50 60 70 80 90 100 
// 110 120 




// APPROACH 1  USING 2 QUEUE

 public static void levelOrderLinewise(Node node){
    // write your code here
    Queue<Node> mq=new ArrayDeque<>();
    mq.add(node);
    Queue<Node> cq=new ArrayDeque<>();
    while(mq.size()>0){
        Node temp=mq.remove();
        System.out.print(temp.data+" ");
        for(Node child : temp.children){
            cq.add(child);
        }
        if(mq.size()==0){
            mq=cq;
            cq=new ArrayDeque<>();
            System.out.println();
        }
    }
  }



  // APPROACH 2 using a null to make a differeence in level

    public static void levelOrderLinewise(Node node){
    // write your code here
    Queue<Node> mq=new ArrayDeque<>();
    mq.add(node);
    mq.add(new Node(Integer.MIN_VALUE));
    while(mq.size()>0){
        Node temp=mq.remove();
        if(temp.data==Integer.MIN_VALUE){
            System.out.println();
            if(mq.size()!=0){
               mq.add(new Node(Integer.MIN_VALUE)); 
            }
        }else{
            System.out.print(temp.data + " ");
            for (Node child: temp.children) {
                mq.add(child);
            }
        }
    }
  }





  //APPROACH 3 using pair class to store the level
      public static class Pair{
        Node node;
        int level;
        Pair(Node node,int level){
            this.node=node;
            this.level=level;
        }
    }
  public static void levelOrderLinewise(Node node){
    // write your code here
    Queue<Pair> q=new ArrayDeque<>();
    q.add(new Pair(node,1));
    int currLevel=1;
    while(q.size()>0){
        Pair p=q.remove();
        Node pairNode=p.node;
        int pairLevel=p.level;
        if(pairLevel!=currLevel){
            System.out.println();
            currLevel=pairLevel;
        }
        System.out.print(pairNode.data+" ");
        for(Node child : pairNode.children){
            q.add(new Pair(child,pairLevel+1));
        }
    }
  }
