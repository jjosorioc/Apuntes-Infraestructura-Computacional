package lecturas.sincronizacion.monitores.actividad;

public class Lista2 {
    private static int suma = 0;

    public synchronized static void sumar() {
        suma++;
        System.out.println("Suma: " + suma);
    }
}
