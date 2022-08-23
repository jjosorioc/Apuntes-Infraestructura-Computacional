package lecturas.sincronizacion.eventos.ejemplo2;

/**
 * Ejemplo en clase: Lectura de un archivo con diferentes threads.
 */
public class Ejemplo2 {
    private int nRedactores = 0;
    private int nLectores = 0;

    public synchronized void entrarLeer() throws InterruptedException {
        // Escriura exclusiva
        if (nRedactores != 0)
            wait();
        nLectores++; // Numero de lectores usando el archivo
    }


    public synchronized void entrarEscribir() throws InterruptedException {
        if (nRedactores != 0 || nLectores != 0) {
            wait();
        }
        nRedactores++;
    }

    public synchronized void salirLeer() {
        nLectores--;
        // El otro lector
        if (nLectores == 0)
            notify(); // Despierta solo 1 escritos
    }

    public synchronized void salirEscribir() {
        nRedactores--;
        notifyAll();
    }

}
