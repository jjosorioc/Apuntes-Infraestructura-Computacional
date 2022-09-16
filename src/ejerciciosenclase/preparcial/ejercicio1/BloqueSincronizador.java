package ejerciciosenclase.preparcial.ejercicio1;

public class BloqueSincronizador {

    private int contador;
    private final int maximo = 5; // cambiable

    public BloqueSincronizador() {
        this.contador = 0;
    }

    public int getMaximo() {
        return this.maximo;
    }

    public synchronized void recibir() {
        while (this.contador == this.maximo) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.contador++;
        notify();
    }

    public synchronized void trabajar() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void despachar() {
        while (this.contador == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.contador--;
        notify();
    }
    
}
