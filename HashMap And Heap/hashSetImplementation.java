class MyHashSet {

    /** Initialize your data structure here. */
    private int size;
    private LinkedList<Integer> buckets[];
    public void init(int n){
        buckets=new LinkedList[n];
        for(int i=0;i<n;i++){
            buckets[i]=new LinkedList<>();
        }
    }
    public MyHashSet() {
        init(16);
        size=0;
    }
    public int hashFunction(Integer key){
        int hc=key.hashCode();
        int bi=Math.abs(hc)%buckets.length;
        return bi;
    }
    public int findInBucket(int bi,int key){
        int di=0;
        for(int val:buckets[bi]){
            if(val==key){
                return di;
            }
            di++;
        }
        return -1;
    }
    public void add(int key) {
        int bi=hashFunction(key);
        int di=findInBucket(bi,key);
        if(di==-1){
            buckets[bi].addLast(key);
            size++;
        }else{
            return;
        }
        double lambda=(size*1.0)/buckets.length;
        if(lambda>2.0){
            rehashing();
        }
    }
    public void rehashing(){
        LinkedList<Integer> oldBuckets[]=buckets;
        init(2*buckets.length);
        for(LinkedList<Integer> bucket:oldBuckets){
            for(int val:bucket){
                add(val);
            }
        }
    }
    public void remove(int key) {
        int bi=hashFunction(key);
        int di=findInBucket(bi,key);
        if(di!=-1){
            buckets[bi].remove(di);
            size--;
        }
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int bi=hashFunction(key);
        int di=findInBucket(bi,key);
        if(di!=-1){
            return true;
        }else{
            return false;
        } 
    }
}
