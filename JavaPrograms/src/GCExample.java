public class GCExample {
    public static void main(String[] args) {
        String str1 = new String("Hello");
        String str2 = new String("world!");

        str1 = null;
        System.gc();

        System.out.println("Garbage collection executed");
    }

    @Override
    protected void finalize() throws Throwable{
        System.out.println("Garbage collection is performed by JVM");
    }
}
