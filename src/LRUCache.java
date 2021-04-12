import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache<K,V> {
    private static final float hashTableLoadFactor=0.75f;
    private LinkedHashMap<K,V> map;
    private int cacheSize;

    public LRUCache(int cacheSize){
        this.cacheSize=cacheSize;
        int hashTableCapacity=(int)Math.ceil(cacheSize/hashTableLoadFactor)+1;
        map=new LinkedHashMap<K,V>(hashTableCapacity,hashTableLoadFactor,true){
            private static final long serialVersionUID=1;
            @Override
            protected boolean removeEldestEntry(Map.Entry<K,V> eldest){
                return size()> LRUCache.this.cacheSize;//超过指定容量的时候，删除最久不使用元素（head->next)
            }
        };
    }
    public synchronized V get(K key){
        return map.get(key);
    }
    public synchronized void put(K key,V value){
        map.put(key,value);
    }
    public synchronized int usedEntries(){
        return map.size();
    }
}
