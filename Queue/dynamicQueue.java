//create dynamic queue


void add(int val) {
      // write ur code here
      if(size == data.length){
        int ndata[]=new int[2*data.length];
        for(int i=0;i<data.length;i++)
        {
            int idx= (front+i)%data.length;
            ndata[i]=data[idx];
        }
        data=ndata;
        front=0;
        int idx = (front + size) % data.length;
        data[idx] = val;
        size++;
      } else {
        int idx = (front + size) % data.length;
        data[idx] = val;
        size++;
      }
    }