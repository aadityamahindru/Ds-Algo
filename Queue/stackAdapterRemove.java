  public static class StackToQueueAdapter {
    Stack<Integer> mS;
    Stack<Integer> hS;

    public StackToQueueAdapter() {
      mS = new Stack<>();
      hS = new Stack<>();
    }

    int size() {
        return mS.size();
    }

    void add(int val) {
        while(mS.size()>0){
            hS.push(mS.pop());
        }
        mS.push(val);
        while(hS.size()>0){
            mS.push(hS.pop());
        }    
    }

    int remove() {
        if(mS.size()==0){
            System.out.println("Queue underflow");
            return -1;
        }
        return mS.pop();
    }

    int peek() {
         if(mS.size()==0){
            System.out.println("Queue underflow");
            return -1;
        }
        return mS.peek();
    }
  }

  