package laboratorios.lab2.ejercicio1;

import java.util.concurrent.ThreadLocalRandom;

public class T extends Thread {
    public static int[][] matriz = new int[10][10];
    public static int MAXIMO = -99999;

    public static int[] array = new int[10];
    private int fila;

    public T(int i) {
        this.fila = i;
    }

    public static void crearMatriz() {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                matriz[i][j] = ThreadLocalRandom.current().nextInt(0, 99999);
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


    public void run() {
        this.mayorFila();
    }

    private synchronized void mayorFila() {

        for (int i = 0; i < matriz.length; i++) {
            if (matriz[fila][i] > MAXIMO) {
                MAXIMO = matriz[fila][i];
                array[fila] = matriz[fila][i];
            }
        }
    }



    public static void main(String[] args) {
        crearMatriz();

        for (int i = 0; i < matriz.length; i++) {
            T t = new T(i);
            t.start();
        }

        System.out.print("\n=======================================");
        System.out.println("\nEl mayor es: " + MAXIMO);


    }

}
