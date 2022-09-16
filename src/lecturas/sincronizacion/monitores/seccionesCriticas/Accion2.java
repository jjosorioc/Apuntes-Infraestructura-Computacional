package lecturas.sincronizacion.monitores.seccionesCriticas;

@SuppressWarnings("all") // Sorry
public class Accion2 {
    private int x = 0;
    private int y = 1;

    private Integer objX = Integer.valueOf(1);
    private Integer objY = Integer.valueOf(2);

    private void accion(int y2) {
        System.out.println("Accionando: " + y2);
    }

    public void accionar() {
        // synchronized (this.objX) {
        // this.accion(x);

        // }
        // synchronized (this.objY) {
        // this.accion(y);
        // }
    }



    public static void main(String[] args) {
        Accion2 a = new Accion2();
        a.accionar();
    }
}
