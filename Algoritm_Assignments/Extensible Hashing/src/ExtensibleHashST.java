import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class ExtensibleHashST<K,V> {
    private List<Bucket<K,V>> directory;
    Map<Bucket<K,V>,Integer>info=new HashMap<>();
    private int global_i=0;
    private int bucketSize;
    public boolean contains(K key) { return get(key) != null; }
    public boolean isEmpty() { return directory.isEmpty(); }
    public int size() {
        Info();
        int count=0;
        Collection<Integer> values = info.values();
        for (Integer value : values) {
            count+=value;
        }
        info.clear();
        return count;
    }
    public void Info(){
        for(int i=0;i<directory.size()-1;i++){
            if(!info.containsKey(directory.get(i))){
                info.put(directory.get(i),directory.get(i).getSize());
            }
        }
    }
    public int getBucketCount(){
        Info();
        return info.size();
    }
    private static class Bucket<K,V>{
        private int size;
        private List<K> keys;
        private List<V> vals;
        int bit=0;
        public Bucket(){this(4);}
        public Bucket(int size){
            this.size=size;
            this.keys=new ArrayList<>(size);
            this.vals=new ArrayList<>(size);
        }
        public void put(K key,V value){
            if(keys.contains(key)){
                int index= this.keys.indexOf(key);
                this.vals.set(index,value);
                return;
            }
            this.keys.add(key);
            this.vals.add(value);
        }
        public V get(K key){
            int index=this.keys.indexOf(key);
            if(index!=-1){
                return vals.get(index);
            }
            return null;
        }
        public void BucketShow(){
            for(int i=0;i<getSize();i++){
                System.out.println(keys.get(i)+":"+vals.get(i));
            }
        }
        public int getSize(){return keys.size();}
        public int getBit(){return bit;}
    }

    public ExtensibleHashST(){this(4);}
    public ExtensibleHashST(int size){
        this.directory=new ArrayList<>();
        this.directory.add(new Bucket<>(size));
        this.bucketSize=size;
    }
    private int hash(K key) {
        return key.hashCode() & ((1 <<global_i) - 1);
    }
    public V get(K key){
        int index=hash(key);
        Bucket<K,V> bucket=directory.get(index);
        return bucket.get(key);
    }
    public void resize(){
        directory.addAll(directory);
        global_i++;
    }
    public void put(K key,V value){
        int index=hash(key);
        Bucket<K,V>bucket=directory.get(index);
        if(bucket.getSize()>=bucketSize && bucket.bit==global_i){
            resize();
        }
        if(bucket.getSize()>=bucketSize && bucket.bit<global_i){
            bucket.put(key,value);
            while(true){
                Bucket<K,V>Bucket1,Bucket0;
                Bucket1=new Bucket<>();
                Bucket0=new Bucket<>();
                for(K newkey:bucket.keys) {
                    V newval = bucket.get(newkey);
                    int hash = hash(newkey);
                    if ((newkey.hashCode() & ((1 << bucket.bit) - 1)) == hash) {
                        Bucket1.put(newkey, newval);
                    } else {
                        Bucket0.put(newkey, newval);
                    }
                }
                    List<Integer> l = new ArrayList<Integer>();
                    for(int i=0;i<directory.size();i++){
                        if(directory.get(i)==bucket){
                            l.add(i);
                        }
                    }
                    for(int i:l) {
                        if((i & ((1<<bucket.bit)-1))==i){
                            directory.set(i,Bucket1);
                        }
                        else{
                            directory.set(i,Bucket0);
                        }
                    }
                    Bucket0.bit=bucket.bit+1;
                    Bucket1.bit=Bucket0.bit;
                if(Bucket0.getSize()>bucketSize && bucket.bit==global_i){
                    bucket=Bucket0;
                    resize();
                }
                else if(Bucket1.getSize()>bucketSize && bucket.bit==global_i){
                    bucket=Bucket1;
                    resize();
                }
               else break;
            }
        }
        else{
            bucket.put(key,value);
        }
    }

    public Iterable<K> keys(){
        List<K> allKeys=new ArrayList<>();
        for(Bucket<K,V> bucket: directory){
            for(K key: bucket.keys){
                allKeys.add(key);
            }
        }
        return allKeys;
    }
    public void summaryInfo(){
        System.out.printf("Global i=%d비트, (key,value) 쌍의 수 = %d, 버킷의 수 = %d \n",global_i,size(),getBucketCount());
    }

public void detailInfo() {
    summaryInfo();
    Map<Integer, Integer> bucketIndexMap = new HashMap<>();
    int count = 0;
    int idx=0;
    for (Bucket<K, V> bucket : directory) {
        int bucketIndex = getBucketIndex(bucket);
        if (!bucketIndexMap.containsKey(bucketIndex)) {
            bucketIndexMap.put(bucketIndex, count);
            System.out.printf("Directory[%d] -> Bucket %d\n", idx++, count++);
        } else {
            int existingBucketNumber = bucketIndexMap.get(bucketIndex);
            System.out.printf("Directory[%d] -> Bucket %d\n", idx++, existingBucketNumber);
        }
    }
    Set<Integer> keys = bucketIndexMap.keySet();
    for (Integer i: keys) {
        Bucket<K,V>bucket=directory.get(i);
        System.out.printf(" Bucket %d: size = %d, nbits = %d비트 \n",bucketIndexMap.get(i),bucket.getSize(),bucket.bit);
        bucket.BucketShow();
    }
}
    private int getBucketIndex(Bucket<K, V> bucket) {
        for (int i = 0; i < directory.size(); i++) {
            if (directory.get(i) == bucket) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        ExtensibleHashST<Integer, Integer> st1 = new ExtensibleHashST<>();

        int x = 0;
        while (st1.size() < 10) {
            st1.put(x, x+100);
            x += 4;
        }
       st1.detailInfo();

        Scanner sc = new Scanner(System.in);
        System.out.print("\n\n파일 이름? ");
        String fname = sc.next();
        sc.close();

        ExtensibleHashST<String, Integer> st2 = new ExtensibleHashST<>(8);
        try {
            sc = new Scanner(new File(fname));
            while (sc.hasNext()) {
                String word = sc.next();
                if (word.length() < 8)	continue;
                if (!st2.contains(word))	st2.put(word, 1);
                else	st2.put(word, st2.get(word) + 1);
            }

            String maxKey = "";
            int maxValue = 0;
            for (String word : st2.keys())
                if (st2.get(word) > maxValue) {
                    maxValue = st2.get(word);
                    maxKey = word;
                }
            System.out.println(maxKey + " " + maxValue);
            st2.summaryInfo();

        } catch (FileNotFoundException e) { e.printStackTrace(); }
        if (sc != null)
            sc.close();
    }
}