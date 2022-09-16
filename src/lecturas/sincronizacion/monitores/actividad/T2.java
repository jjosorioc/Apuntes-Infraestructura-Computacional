package lecturas.sincronizacion.monitores.actividad;

public class T2 extends Thread {
    public void run() {
        synchronized (Lista2.class) {
            Lista2.sumar();
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++)
            new T2().start();
    }
}
