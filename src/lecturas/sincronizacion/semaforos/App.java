package lecturas.sincronizacion.semaforos;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class App {
    public static void main(String[] args) throws InterruptedException {
        // Semaphore semaphore = new Semaphore(1);

        // semaphore.acquire(); // Waits if there aren't resources availale == 0
        // semaphore.release();

        // System.out.println("Available permits: " + semaphore.availablePermits()); // Recursos
        // disponibles



        ExecutorService executor = Executors.newCachedThreadPool();


        for (int i = 0; i < 200; i++) {
            executor.submit(new Runnable() {
                public void run() {
                    Connection.getInstance().connect();
                }
            });
        }

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.DAYS);
    }
}
