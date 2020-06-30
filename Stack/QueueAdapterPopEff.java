  1. You are required to complete the code of our QueueToStackAdapter class. 
2. As data members you've' two queues available - mainQ and helperQ. mainQ is to contain data and helperQ is to assist in operations. (This is cryptic - take hint from video)
2. Here is the list of functions that you are supposed to complete
2.1. push -> Should accept new data in LIFO manner
2.2. pop -> Should remove and return data in LIFO manner. If not available, print "Stack underflow" and return -1.
2.3. top -> Should return data in LIFO manner. If not available, print "Stack underflow" and return -1.
2.4. size -> Should return the number of elements available in the stack
3. Input and Output is managed for you.

Note -> pop, top and size should work in constant time. push should work in linear time




public class Main {

  public static class QueueToStackAdapter {
    Queue<Integer> mainQ;
    Queue<Integer> helperQ;

    public QueueToStackAdapter() {
      mainQ = new ArrayDeque<>();
      helperQ = new ArrayDeque<>();
    }

    int size() {
      // write your code here
      return mainQ.size();
    }

    void push(int val) {
      // write your code here
      helperQ.add(val);
      while(mainQ.size()>0){
          int v=mainQ.remove();
          helperQ.add(v);
      }
      mainQ=helperQ;
      helperQ=new ArrayDeque<>();
    }

    int pop() {
      // write your code here
      if(size()==0){
          System.out.println("Stack underflow");
          return -1;
      }
      int val =mainQ.remove();
      return val;
    }

    int top() {
      // write your code here
      if(size()==0){
          System.out.println("Stack underflow");
          return -1;
      }
      int val =mainQ.peek();
      return val;
      
    }
  }