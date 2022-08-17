package lecturas.sincronizacion.monitores.actividad;

public class Lista {
    public static int suma = 0;

    public static void sumar() {
        suma++;
        System.out.println("Suma: " + suma);
    }

    /**
     * Corrección de la actividad 1-5
     * 
     * @param n
     */
    public static void printNum(int n) {
        System.out.println("Numero: " + n);
    }
}
