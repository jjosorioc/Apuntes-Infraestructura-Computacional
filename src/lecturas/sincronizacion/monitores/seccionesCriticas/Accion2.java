package lecturas.sincronizacion.monitores.seccionesCriticas;

public class Accion2 {
    private int x = 0;
    private int y = 1;

    private Integer objX = new Integer(0);
    private Integer objY = new Integer(1);

    private void accion(int y2) {
        System.out.println("Accionando: " + y2);
    }

    public void accionar() {
        synchronized (this.objX) {
            this.accion(x);

        }
        synchronized (this.objY) {
            this.accion(y);
        }
    }



    public static void main(String[] args) {
        Accion2 a = new Accion2();
        a.accionar();
    }
}
