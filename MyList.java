public class MyList{
    Object[] data;
    int capacity;   // maximum capacity of the list
    int num;    // current size of list
    static final int DEFAULT_CAPACITY = 100;

    public MyList() {
        this(DEFAULT_CAPACITY);
    }

    public MyList(int capacity) {
        this.capacity = capacity;
        data = new Object[capacity];    // null array
        num = 0;
    }

    public void add(Object a) {
        if(num == capacity) {
            Object[] datanew = new Object[DEFAULT_CAPACITY + num];
            for(int i = 0; i < num; i++) {
                datanew[i] = data[i];
            }
            data = datanew; // data now refers to he new array
            capacity = capacity + DEFAULT_CAPACITY;
        }
        data[num] = a;
        num++;
    }

    public void add(Object a, int index) {
        if(index < 0) {
            System.out.println("index out of bounds");

            return;
        }

        if(num == capacity) {
            Object[] datanew = new Object[DEFAULT_CAPACITY + num];
            for(int i = 0; i < index; i++) {
                datanew[i] = data[i];
            }
            for(int i = index + 1; i < num + 1; i++) {
                datanew[i] = data[i];
            }
            data = datanew; // data now refers to he new array
            capacity = capacity + DEFAULT_CAPACITY;
        }

        data[index] = a;
        if(index > num) {
            data[num] = a;
            num++;
        }
    }

    public Object remove(int index) {
        if(index < 0 || index > num){
            System.out.println("index out of bounds");

            return null;
        }

        Object ret = data[index];
        // shift elements to left
        for(int j = index; j < num - 1; j++){
            data[j] = data[j + 1];
        }
        num--;

        return ret;
    }

    public Object get(int index) {
        if(index < 0 || index >= num) {
            System.out.println("index out of bounds");
        }
        return data[index];
    }

    public int indexOf(Object a) {
        for(int i = 0; i < num; i++) {
            if(data[i].equals(a))
                return i;
        }
        return -1;
    }

    public boolean contains(Object a) {
        for(int i = 0; i < num; i++) {
            if(data[i].equals(a))
                return true;
        }
        return false;
    }

    // public Object set(Object a, int index) {
    // 
    // }

    public int size() {
        return num;
    }

    public boolean isEmpty() {
        if(num == 0)
            return true;

        return false;
    }

    public static void main(String... arg) {
        
    }
}