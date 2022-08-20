package laboratorios.lab2.ejercicio2;



public class T extends Thread {

    public static Monitor monitor = new Monitor();

    private int fila;



    public void run() {
        // this.mayorFila();

        this.fila = monitor.darId();

    }


    @Override
    public String toString() {
        return "Fila " + fila;
    }


    public static void main(String[] args) {
        // crearMatriz();


        for (int i = 0; i < 10; i++) {
            T t = new T();
            t.start();
        }


    }

}
