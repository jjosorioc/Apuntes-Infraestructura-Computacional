package lecturas.sincronizacion.eventos.productorConsumidor;

public class Consumidor extends Thread  {

    private Buffer buffer;
    private int n;
  

    public Consumidor(int n, Buffer buffer) {
        this.n = n;
        this.buffer = buffer;
    }
}
