public class MyMapEntry {
    Object key;
    Object value;
    MyMapEntry next;

    public MyMapEntry(Object key, Object value, MyMapEntry next) {
        this.key = key;
        this.value = value;
        this.next = next;
    }
}
