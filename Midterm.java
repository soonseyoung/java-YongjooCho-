public class Midterm {
    HashValue[] hashValues;
    Hash hash;

    Midterm(int hashBase, int hashSize, String str) {
        createHash(hashBase, hashSize);
        setString(str);
    }

    public void setString(String str) {
        String[] arr = str.split(" ");
        hashValues = new HashValue[arr.length];
        for (int i = 0; i < arr.length; i++) {
            String s = arr[i].trim();
            char ch = s.charAt(s.length() - 1);
            if (ch == ',' || ch == '.' || ch == ';') {
                s = s.substring(0, s.length() - 1);
            }
            hashValues[i] = new HashValue(s, hash.getHashValue(s));
        }
    }

    public void printHashValues() {
        for (HashValue hashValue : hashValues) {
            System.out.printf("%s : %d\n", hashValue.getString(), hashValue.getValue());
        }
    }

    public void createHash(int hashBase, int hashSize) {
        hash = new Hash(hashBase, hashSize);
    }

    public boolean isInWords(String str) {
        long value = hash.getHashValue(str);
        for (HashValue hashValue : hashValues) {
            if (value == hashValue.getValue() && str.equals(hashValue.getString())) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String s1 = "There was no lack of material; boys happened along every" +
                " little while; they came to jeer, but remained to whitewash.";
        String s2 = "Tom gave up the brush with reluctance in his face,"
                + " but alacrity in his heart.";

        Midterm m = new Midterm(3, 47, s1);
        m.printHashValues();
        System.out.printf("\"remained\" is in s1: %s\n", m.isInWords("remained"));
        System.out.printf("\"gave\" is in s1: %s\n", m.isInWords("gave"));
        System.out.println("\n\nCreates a new hash and sets a new string");
        m.createHash(3, 37);
        m.setString(s2);
        m.printHashValues();
        System.out.printf("\"remained\" is in s2: %s\n", m.isInWords("remained"));
        System.out.printf("\"gave\" is in s2: %s\n", m.isInWords("gave"));
    }
}
