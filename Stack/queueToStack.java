
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
    mainQ.add(val);
    }

    int pop() {
    if(mainQ.size()==0){
        System.out.println("Stack underflow");
        return -1;
    }
    while(mainQ.size()>1){
        helperQ.add(mainQ.remove());
    }
    int val = mainQ.remove();
    mainQ = helperQ;
    helperQ = new ArrayDeque();
    return val;
      // write your code here
    }

    int top() {
            if(mainQ.size()==0){
        System.out.println("Stack underflow");
        return -1;
    }
    while(mainQ.size()>1){
        helperQ.add(mainQ.remove());
    }
    int val = mainQ.peek();
     helperQ.add(mainQ.remove());
    mainQ = helperQ;
    helperQ = new ArrayDeque();
    return val;
      // write your code here
    }
    
  }