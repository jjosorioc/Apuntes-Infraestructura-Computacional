package lecturas.sincronizacion.monitores;

/**
 * Lo anterior implica que solo se garantiza exclusión mutua entre métodos synchronized del mismo
 * objeto. Dos objetos distintos de la misma clase son monitores diferentes y por lo tanto no hay
 * sincronización entre ellos
 */
public class T extends Thread {



    private static Maximo oMax = new Maximo();

    private int num = 0;

    public T(int num) {
        this.num = num;
    }

    public void run() {
        oMax.anotar(num);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new T(i).start();
        }
        System.out.println("El máximo es " + oMax.darMaximo());
    }
}
