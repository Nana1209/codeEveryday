import java.util.Iterator;
import java.util.LinkedList;

public class MyHashMap {
    private class Pair{
        int key;
        int value;
        public Pair(int key,int value){
            this.key=key;
            this.value=value;
        }

        public int getKey() {
            return key;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }
    private LinkedList[] myHashMap;
    private static final int BASE=857;
    /** Initialize your data structure here. */
    public MyHashMap() {

        myHashMap=new LinkedList[BASE];
        for(LinkedList temp:myHashMap){
            temp=new LinkedList<Pair>();
        }
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        LinkedList<Pair> temp=myHashMap[hash(key)];
        Iterator<Pair> i = temp.iterator();
        boolean has=false;
        while(i.hasNext()){
            Pair pair=i.next();
            if(pair.getKey()==key){
                pair.setValue(value);
                has=true;
            }
        }
        if(!has){
            temp.add(new Pair(key,value));
        }
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        LinkedList<Pair> temp=myHashMap[hash(key)];
        Iterator<Pair> i = temp.iterator();
        while(i.hasNext()){
            Pair pair=i.next();
            if(pair.getKey()==key){
                return pair.getValue();
            }
        }
        return -1;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        LinkedList<Pair> temp=myHashMap[hash(key)];
        Iterator<Pair> i = temp.iterator();
        while(i.hasNext()){
            Pair pair=i.next();
            if(pair.getKey()==key){
                temp.remove(pair);
            }
        }
    }
    public int hash(int key){
        return key%BASE;
    }
}
