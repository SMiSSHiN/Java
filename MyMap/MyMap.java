public class MyMap {
    MyMapEntry[] data;
    int capacity;   // maximum capacity of the list
    int num;    // current size of list
    static final int DEFAULT_CAPACITY = 100;
    
    public MyMap() {
        this(DEFAULT_CAPACITY);
    }

    public MyMap(int capacity) {
        this.capacity = capacity;
        data = new MyMapEntry[capacity];
        num = 0;
    }

    public void put(Object key, Object value) {
        MyMapEntry newEntry = new MyMapEntry(key, value, null);
        
        for(int i = 0; i < num; i ++) {
            if(data[i].key.equals(newEntry.key))
                return;
        }

        if(num == capacity) {
            MyMapEntry[] datanew = new MyMapEntry[DEFAULT_CAPACITY + num];
            for(int i = 0; i < num; i++) {
                datanew[i] = data[i];
            }
            data = datanew; // data now refers to he new array
            capacity = capacity + DEFAULT_CAPACITY;
        }
        data[num] = newEntry;
        num++;
    }

    public Object get(Object key) {
        for(int i = 0; i < num; i++) {
            if(data[i].key.equals(key))
                return data[i].value;
        }
        return null;
    }

    public Object get(Object key, Object byDefaulf) {
        for(int i = 0; i < num; i++) {
            if(data[i].key.equals(key))
                return data[i].value;
        }
        return byDefaulf;
    }

    public Object remove(Object key) {
        for(int i = 0; i < num; i++) {
            if (data[i].key.equals(key)) {
                Object ret = data[i].value;
                // shift elements to right
                for(int j = i; j < num; j++){
                    data[j] = data[j + 1];
                }
                num--;

                return ret;
            }
        }
        return null;
    }

    public boolean keyContains(Object key) {
        for(int i = 0; i < num; i++) {
            if(data[i].key.equals(key))
                return true;
        }
        return false;
    }

    public MyList getKeys() {
        if(num == 0)
            return null;

        MyList keys = new MyList(num);

        for(int i = 0; i < num; i++) {
            keys.add(data[i].key);
        }

        return keys;
    }

    public MyList getValues() {
        if(num == 0)
            return null;

        MyList values = new MyList(num);

        for(int i = 0; i < num; i++) {
            values.add(data[i].value);
        }

        return values;
    }
    // ???
    // public MyList getEntries() {}

    public int size() {
        return num;
    }

    public boolean isEmty() {
        if(num == 0)
            return true;
        return false;
    };

    public static void main(String... arg) {
        MyMap myMap = new MyMap(10);

        myMap.put(1001, "aaa");
        myMap.put(1002, "bbb");
        myMap.put(1003, "ccc");
        myMap.put(1004, "ddd");

        for(int i = 0; i < myMap.size(); i++)
            System.out.println("{Key: " + myMap.data[i].key + ", Value: " + myMap.data[i].value + "}");

        myMap.remove(1003);

        for(int i = 0; i < myMap.size(); i++)
            System.out.println("{Key: " + myMap.data[i].key + ", Value: " + myMap.data[i].value + "}");       

    }
}
