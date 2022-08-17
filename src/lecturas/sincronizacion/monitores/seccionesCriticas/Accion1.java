package lecturas.sincronizacion.monitores.seccionesCriticas;

public class Accion1 {
    private int x = 0;
    private int y = 1;

    public void accionar() {
        synchronized (this) {
            this.accion(x);
            this.accion(y);
        }
    }

    private void accion(int y2) {
        System.out.println("Accionando: " + y2);
    }

    public static void main(String[] args) {
        Accion1 a = new Accion1();
        a.accionar();
    }
}
