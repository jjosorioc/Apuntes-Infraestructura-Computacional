package ejerciciosenclase.esperaactiva;

public class App {
    public static void main(String[] args) throws InterruptedException {
        final Processor processor = new Processor();

        /*
         * Creación thread 1
         */
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    processor.produce();
                } catch (InterruptedException e) {

                }
            }
        });


        /*
         * Creación thread 2
         */
        Thread t2 = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    processor.consume();
                } catch (InterruptedException e) {

                }
            }
        });


        // Start

        t1.start();
        t2.start();

        t1.join();
        t2.join();


    }
}
