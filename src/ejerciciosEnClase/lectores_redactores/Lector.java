package ejerciciosEnClase.lectores_redactores;

public class Lector extends Thread {

    private Archivo archivo;

    private int id;

    public Lector(Archivo archivo, int pId) {
        this.archivo = archivo;
        this.id = pId;
    }

    public void run() {
        archivo.entrarLector();
        System.out.println("Lector " + id + " entro a leer");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Lector " + id + " salio de leer");
        archivo.salirLector();
    }
    
}
