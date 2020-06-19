// Question
// 1. You are given a partially written BST class.
// 2. You are given a value. You are required to print all pair of nodes which add up to the given value. Make sure all pairs print the smaller value first and avoid duplicacies. Make sure to print the pairs in increasing order. Use the question video to gain clarity.
// 3. Input and Output is managed for you. 
// Input Format
// Input is managed for you
// Output Format
// "smaller node" "larger node"
// .. all pairs that add to target on separate lines
// Constraints
// None
// Sample Input
// 21
// 50 25 12 n n 37 30 n n n 75 62 60 n n 70 n n 87 n n
// 100
// Sample Output
// 25 75
// 30 70


public static boolean find(Node node, int data) {
        if (node == null) {
            return false;
        }
        if (node.data == data) {
            return true;
        }
        if (data > node.data) {
            return find(node.right, data);
        } else {
            return find(node.left, data);
        }
    }
    public static void tsp(Node root,Node node,int tar){
        if(node==null){
            return;
        }
        tsp(root,node.left,tar);
        int val=node.data;
        int cVal=tar-val;
        if(val<cVal&&find(root,cVal)){
            System.out.println(val+" "+cVal);
        }
        tsp(root,node.right,tar);
    }



    // if we use extra space


    static ArrayList<Integer> list;
    public static void fillArray(Node node){
        if(node ==null){
            return;
        }
        fillArray(node.left);
        list.add(node.data);
        fillArray(node.right);
    }
    public static void tsp(Node node,int tar){
        list=new ArrayList<>();
        fillArray(node);
        int lo=0;
        int hi=list.size()-1;
        while(lo<hi){
            int v1=list.get(lo);
            int v2=list.get(hi);
            if(v1+v2<tar){
                lo++;
            }else if(v1+v2>tar){
                hi--;
            }else{
                System.out.println(v1+" "+v2);
                lo++;
                hi--;
            }
        }
    } 