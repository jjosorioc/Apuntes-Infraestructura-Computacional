package ejerciciosenclase.preparcial.ejercicio1;

public class Desplegador extends Thread {

    private BloqueSincronizador bloque;

    public Desplegador(BloqueSincronizador pBloque) {
        this.bloque = pBloque;
    }

    public void run() {
        this.bloque.recibir();
        System.out.println("Entrando...");	
        System.out.println("Trabajando...");
        this.bloque.trabajar();
        System.out.println("Despachando...");
        this.bloque.despachar();
    }
}
