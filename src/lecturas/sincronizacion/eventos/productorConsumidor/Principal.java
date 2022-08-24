package lecturas.sincronizacion.eventos.productorConsumidor;

public class Principal {
    public static void main(String[] args) {
        Buffer buffer = new Buffer(10);
        Productor productor = new Productor(20, buffer);
        Consumidor consumidor = new Consumidor(20, buffer);
        productor.start();
        consumidor.start();
    }
}
