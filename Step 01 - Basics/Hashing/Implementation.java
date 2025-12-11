public class MyHashMap<K,V>{  //LinkedList of entries

    private class Entry<K,V> {
        private K key;
        private V value;
        private Entry<K,V> next;

        public Entry(K key , V value){
            this.key = key;
            this.value = value;
            this.next  = null;
        }

        public K getKey(){
            return this.key;
        }
        public V getValue(){
            return this.value;

        }
        public void setValue(V value){
            this.value = value;
        }
    }

    private final int SIZE = 5; // m 
    private Entry<K,V> table[];
    public MyHashMap(){
        table = new Entry[SIZE];
    }

    public void put(K key , V value){
        int hash = key.hashCode() % SIZE;//7887744%5 [0,4]
        Entry<K,V> e = table[hash];
        if(e == null){
            table[hash] = new Entry<K,V>(key, value);
            return;
        }
        else{
            while (e.next != null) {
                if(e.getKey() == key){
                    e.setValue(value);
                    return;
                }
                e = e.next;
            }
            if(e.getKey() == key){
                    e.setValue(value);
                    return;
                }
            e.next = new Entry<K,V>(key, value);

        }


    }

    public V get(K key){
        int hash = key.hashCode()%SIZE;
        Entry<K,V> e = table[hash];
        if (e == null) {
            return null;
        }
        else{
            while (e != null) {
                if(e.getKey() == key){
                    return e.getValue();
                }
                e = e.next;
            }
        }
        return null;
    }

    public Entry<K,V> remove(K key){
        int hash = key.hashCode()%SIZE;
        Entry<K,V> e = table[hash];
        if (e == null) {
            return null;
        }
        if(e.getKey() == key){
            table[hash] = e.next;
            e.next = null; 
            return e ;
        }
        Entry<K,V> prev = e;
        e = e.next;
        while (e != null) {
            if(e.getKey() == key){
                prev.next = e.next;
                e.next = null;
                return e;
            }
            prev = e;
            e = e.next;
        }
        return null;

    }



    public static void main(String[] args) {
        MyHashMap<Integer , Integer> mp = new MyHashMap<>();
        mp.put(1, 1);
        mp.put(2, 2);
        mp.put(3, 3);
        System.out.println(mp.get(1));
        System.out.println(mp.remove(1).getValue());
    }
}
