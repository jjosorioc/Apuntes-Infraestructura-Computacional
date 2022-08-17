package ejerciciosEnClase;

public class Maximo {
    private int maximo = 0;

    public synchronized void anotar(int n) {
        if (n > maximo) {
            maximo = n;
        }
    }

    public synchronized int getMaximo() {
        return maximo;
    }
}
