//   Question
// 1. You are given a partially written BST class.
// 2. You are required to complete the body of size, sum, max, min and find function. The functions are expected to
// 2.1. size - return the number of nodes in BST
// 2.2. sum - return the sum of nodes in BST
// 2.3. max - return the value of node with greatest value in BST
// 2.4. min - return the value of node with smallest value in BST
// 2.5. find - return true if there is node in the tree equal to "data"
// 3. Input and Output is managed for you. 
// Input Format
// Input is managed for you
// Output Format
// Output is managed for you
// Constraints
// None
// Sample Input
// 19
// 50 25 12 n n 37 30 n n n 75 62 n 70 n n 87 n n
// 70
// Sample Output
// 9
// 448
// 87
// 12
// true
  
  
  
  
  static int max(Node node) {
        if (node.right == null) {
            return node.data;
        }
        int right = max(node.right);
        return right;
    }
    static int min(Node node) {
        if (node.left == null) {
            return node.data;
        }
        int left = min(node.left);
        return left;
    }
    static boolean find(Node node, int data) {
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
    public static int size(Node node) {
        // write your code here
        if (node == null) {
            return 0;
        }
        int lchild = size(node.left);
        int rchild = size(node.right);
        return lchild + rchild + 1;
    }

    public static int sum(Node node) {
        // write your code here
        if (node == null) {
            return 0;
        }
        int lchild = sum(node.left);
        int rchild = sum(node.right);
        int sum = lchild + rchild + node.data;
        return sum;
    }