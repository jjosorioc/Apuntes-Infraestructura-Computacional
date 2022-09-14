package ejerciciosenclase.lectores_redactores;

public class Redactor extends Thread {

    private Archivo archivo;
    
    private int id;
    
    public Redactor(Archivo archivo, int pId) {
        this.archivo = archivo;
        this.id = pId;
    }
    
    public void run() {
        archivo.entrarRedactor();
        System.out.println("Redactor " + id + " entro a redactar");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Redactor " + id + " salio de redactar");
        archivo.salirRedactor();
    }

}
