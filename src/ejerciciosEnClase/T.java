package ejerciciosEnClase;

public class T extends Thread {
    private static Maximo oMax = new Maximo();
    private int num = 0;

    public T(int n) {
        this.num = n;
    }

    public void run() {
        oMax.anotar(num);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new T(i).start();
        }
        System.out.println(oMax.getMaximo());
    }

}
