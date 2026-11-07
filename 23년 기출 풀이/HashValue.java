public class HashValue {
    private String str;
    private long value;

    public HashValue(String str, long value) {
        this.str = str;
        this.value = value;
    }

    public long getValue() { return value; }
    public String getString() { return str; }
}
