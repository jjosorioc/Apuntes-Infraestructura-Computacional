package lecturas.sincronizacion.monitores.actividad;

public class T extends Thread {


    public void run() {
        sumarLista();

    }

    /**
     * Para imprimir los nums del 1-10 volví este método estático
     */
    private synchronized  void sumarLista() {
        Lista.sumar();
    }


    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new T().start();
        }
    }
}
