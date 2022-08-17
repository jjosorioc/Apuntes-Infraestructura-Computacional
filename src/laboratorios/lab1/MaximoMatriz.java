package laboratorios.lab1;

import java.util.concurrent.ThreadLocalRandom;

public class MaximoMatriz extends Thread {
    private final static int INT_MAX = 105345;
    private final static int DIM = 3;

    private static int[][] matriz = new int[DIM][DIM];
    private static int mayor = -1;
    private int mayorFila = -1;
    private int idThread;
    private int fila;

    public MaximoMatriz(int pIdThread, int pFila) {
        this.idThread = pIdThread;
        this.fila = pFila;
    }

    public static void crearMatriz() {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                matriz[i][j] = ThreadLocalRandom.current().nextInt(0, INT_MAX);
            }
        }
        System.out.println("Matriz creada");
        System.out.println("----------------------------------------------------");
        imprimirMatriz();
    }

    private static void imprimirMatriz() {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("----------------------------------------------------");
    }

    @Override
    public void run() {
        for (int j = 0; j < matriz.length; j++) {
            if (matriz[fila][j] > mayor) {
                mayor = matriz[fila][j];
                mayorFila = matriz[fila][j];
            }
        }
        if (mayorFila > mayor) {
            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        mayor = this.mayorFila;
        String warn = String.format("----------NUevo maximo encontrado ---------\n "
                + "ID Thread: %d- maximo local actual: %d- Maximo global actual: %d\n" + "\n",
                this.idThread, mayor, this.mayorFila);
        System.out.println(warn);
    }

    public static void main(String[] args) {
        MaximoMatriz[] t = new MaximoMatriz[DIM];
        for (int i = 0; i < DIM; i++) {
            t[i] = new MaximoMatriz(i, i);
            t[i].start();
        }

    }

}
