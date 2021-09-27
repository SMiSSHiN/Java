public class MyMapEntry {
    Object key;
    Object value;
    MyMapEntry next; // for HasMap, not used in this implementation

    public MyMapEntry(Object key, Object value, MyMapEntry next) {
        this.key = key;
        this.value = value;
        this.next = next;
    }
}
