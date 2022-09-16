package lecturas.sincronizacion.eventos.productorConsumidor;

@SuppressWarnings("unused")
public class Productor extends Thread {
    private Buffer buffer;
    private int n;

    public Productor(int n, Buffer buffer) {
        this.n = n;
        this.buffer = buffer;
    }


}
