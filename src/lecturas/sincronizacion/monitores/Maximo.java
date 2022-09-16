package lecturas.sincronizacion.monitores;

public class Maximo {
    private int maximo = 0;

    public int darMaximo() {
        return maximo;
    }

    public synchronized void anotar(int n) {
        System.out.println("Thread " + n + " is in anotar");
        if (n > maximo)
            maximo = n;
    }

}
