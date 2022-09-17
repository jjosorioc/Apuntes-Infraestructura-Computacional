package ejerciciosenclase.parcial1;

/**
 * Clientes y servidores
 */
public class T extends Thread {

    private String tipo = "";

    private String mensaje = "";

    private static Buffer buffer = new Buffer(10); // Capacidad varía

    private T servidor;

    /**
     * Constructor cliente
     * 
     * @param tipo
     * @param mensaje
     */
    public T(String tipo, String mensaje) {
        this.tipo = tipo;
        this.mensaje = mensaje;
    }


    public void asignarServidor(T servidor) {
        this.servidor = servidor;
    }

    /**
     * Constructor servidor
     * 
     * @param tipo
     */
    public T(String tipo) {
        this.tipo = tipo;
    }



    @Override
    public void run() {

        if (this.tipo.equals("cliente")) {
            buffer.almacenarSolicitud(this.mensaje);

            synchronized (buffer) {
                try {

                    buffer.wait();
                    System.out.println(
                            "Mensaje inicial: " + this.mensaje + " " + buffer.retirarSolicitud());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }



        } else {
            mensaje = buffer.retirarSolicitud();
            this.traduccion();

            buffer.almacenarSolicitud(this.mensaje);

            synchronized (buffer) {
                buffer.notify();
            }



        }

    }


    public void traduccion() {
        // System.out.println("Traduccion: " + this.mensaje);
        this.mensaje = "Traduccion: " + this.mensaje;
    }


    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            T cliente = new T("cliente", "Hola" + i);
            T servidor = new T("servidor");
            cliente.asignarServidor(servidor);
            cliente.start();
            servidor.start();
        }


    }
}
