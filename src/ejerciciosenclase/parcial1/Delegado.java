package ejerciciosenclase.parcial1;

public class Delegado extends Thread {

    @Override
    public void run() {
        try {
            ProtocoloServidor.procesar();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
