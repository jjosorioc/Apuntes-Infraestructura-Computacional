package lecturas.sincronizacion.semaforos;

import java.util.concurrent.Semaphore;

public class Connection {
    private static Connection instance = new Connection();

    private Semaphore semaphore = new Semaphore(10, true);

    private int connections = 0;

    private Connection() {}


    public static Connection getInstance() {
        return instance;
    }

    public void connect() {
        try {
            semaphore.acquire();
        } catch (InterruptedException e1) {

            e1.printStackTrace();
        }
        synchronized (this) {
            connections++;
            System.out.println("Current connections: " + this.connections);
        }



        synchronized (this) {
            connections--;
        }


        semaphore.release();

    }
}
