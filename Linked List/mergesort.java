// Question
//  1. You are given a partially written LinkedList class.
// 2. You are required to complete the body of mergeSort function. The function is static and is passed the head and tail of an unsorted list. The function is expected to return a new sorted list. The original list must not change.
// 3. Input and Output is managed for you. 

// Note - Watch the question video for theory of merge sort.

                               
// Input Format
// Input is managed for you
// Output Format
// Output is managed for you
// Constraints
// 1. O(nlogn) time complexity required.
// Sample Input
// 6
// 10 2 19 22 3 7
// Sample Output
// 2 3 7 10 19 22 
// 10 2 19 22 3 7 


    public static LinkedList mergeTwoSortedLists(LinkedList l1, LinkedList l2) {
      LinkedList ml = new LinkedList();

      Node one = l1.head;
      Node two = l2.head;
      while (one != null && two != null) {
        if (one.data < two.data) {
          ml.addLast(one.data);
          one = one.next;
        } else {
          ml.addLast(two.data);
          two = two.next;
        }
      }

      while (one != null) {
        ml.addLast(one.data);
        one = one.next;
      }

      while (two != null) {
        ml.addLast(two.data);
        two = two.next;
      }

      return ml;
    }
     public static Node midNode(Node head,Node tail) {
      Node f = head;
      Node s = head;

      while (f != tail && f.next != tail) {
        f = f.next.next;
        s = s.next;
      }

      return s;
    }

    public static LinkedList mergeSort(Node head, Node tail){
      // write your code here
      if(head==tail){
          LinkedList baseAns=new LinkedList();
          baseAns.addLast(head.data);
          return baseAns;
      }
      Node mid=midNode(head,tail);
      LinkedList left=mergeSort(head,mid);
      LinkedList right=mergeSort(mid.next,tail);
      LinkedList ans=mergeTwoSortedLists(left,right);
      return ans;
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n1 = Integer.parseInt(br.readLine());
    LinkedList l1 = new LinkedList();
    String[] values1 = br.readLine().split(" ");
    for (int i = 0; i < n1; i++) {
      int d = Integer.parseInt(values1[i]);
      l1.addLast(d);
    }

    LinkedList sorted = LinkedList.mergeSort(l1.head, l1.tail);
    sorted.display();
    l1.display();
  }
}