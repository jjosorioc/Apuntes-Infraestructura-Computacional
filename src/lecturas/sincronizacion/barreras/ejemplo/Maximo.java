package lecturas.sincronizacion.barreras.ejemplo;

public class Maximo {
    private int maximo = 0;

    public Maximo(int maximo) {
        this.maximo = maximo;
    }

    public synchronized int darMaximo() {
        return maximo;
    }

    public synchronized void anotar(int n) {
        if (n > maximo) {
            maximo = n;
        }
    }

}
