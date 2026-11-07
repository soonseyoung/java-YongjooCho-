class Test {
    public static void main(String[] args) {
        Hash hash = new Hash(3, 37);
        System.out.println(hash.getHashValue("abc"));
        System.out.println(hash.getHashValue("Students"));
    }
}