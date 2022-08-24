package ejerciciosEnClase.productor_consumidor;

public class Productor extends Thread {

    private Buzon buzon;

    private int n;

    public Productor(int pN, Buzon pBuzon) {
        this.n = pN;
        this.buzon = pBuzon;
    }

    public void run() {
        for (int i = 0; i < n; i++) {
            this.buzon.almacenar(i);
        }
    }
    
}
