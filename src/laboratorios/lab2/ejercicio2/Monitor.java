package laboratorios.lab2.ejercicio2;

public class Monitor {
    private static int id = 0;



    public synchronized int darId() {
        int idViejo = id;
        id++;
        System.out.println("Fila " + idViejo + " asignada");
        return idViejo;
    }
}
