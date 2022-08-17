package lecturas.sincronizacion.barreras;

import java.util.concurrent.CyclicBarrier;

public class Barrera {

    // Creación de la barrera para 2 Threads
    CyclicBarrier barrera = new CyclicBarrier(2);

    public void run() {
        try {
            barrera.await(); // Se queda esperando hasta que M threads hagan esta llamada.
        } catch (Exception e) {

        }

        // Aquí el código del thread.
    }
}
