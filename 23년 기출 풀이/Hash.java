public class Hash {
    long hashBase;
    long hashSize;

    public Hash(long hashBase, long hashSize) {
        this.hashBase = hashBase;
        this.hashSize = hashSize;
    }

    public long getHashValue(String str) {
        long value = 0;
        int len = str.length();
        for (int i = 0; i < len; i++) {
            value += (long) (str.charAt(i) * Math.pow(hashBase, len - i - 1));
        }
        return value % hashSize;
    }
}
