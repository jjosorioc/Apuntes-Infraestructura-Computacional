package ejerciciosEnClase.lectores_redactores;

/**
 * ejemplo visto en clase de Lectores-Redactores.
 * Este ejemplo es el que vimos antes de cambiar
 * lo de la inanicion de los lectores y redactores.
 */
public class Archivo {
    
    private int nRedactores = 0;
    private int nLectores = 0;

    /**
     * deja "entrar" lectores.
     */
    public synchronized void entrarLector() {
        while (nRedactores != 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        nLectores++;
    }

    /**
     * deja "salir" lectores.
     */
    public synchronized void salirLector() {
        nLectores--;
        if (nLectores == 0) {
            notify();
        }
    }

    /**
     * deja "entrar" redactores.
     */
    public synchronized void entrarRedactor() {
        while (nRedactores != 0 || nLectores != 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        nRedactores++;
    }

    /**
     * deja "salir" redactores.
     */
    public synchronized void salirRedactor() {
        nRedactores--;
        notifyAll();
    }

    public static void main(String[] args) {
        Archivo archivo = new Archivo();

        for (int i = 1; i < 3; i++) {
            new Lector(archivo, i).start();
            new Redactor(archivo, i).start();
        }
    }

}
