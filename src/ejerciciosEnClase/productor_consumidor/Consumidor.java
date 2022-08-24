package ejerciciosEnClase.productor_consumidor;

public class Consumidor extends Thread {

    private Buzon buzon;
    
    private int n;
    
    public Consumidor(int pN, Buzon pBuzon) {
        this.n = pN;
        this.buzon = pBuzon;
    }
    
    public void run() {
        for (int i = 0; i < n; i++) {
            this.buzon.retirar();
        }
    }
        
}
