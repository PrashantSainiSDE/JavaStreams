public class G1Demo {
    public static void main(String[] args) {

        // Allocate objects in a loop
        for (int i = 0; i < 100000; i++) {
            Object obj = new Object();
        }

        // Explicitly trigger garbage collection
        System.gc();

        // Sleep for a short
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        byte[] largeArray = new byte[150 * 1024 * 1024];

        // Allocate more objects after garbage collection
        for (int i = 0; i < 5000; i++) {
            Object obj = new Object();
        }

        //Explicitly trigger garbage collection
        System.gc();
    }
}
