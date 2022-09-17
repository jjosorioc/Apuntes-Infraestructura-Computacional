package ejerciciosenclase.parcial1;

import java.util.LinkedList;

public class Buffer {
    private int capacidadSolicitudes;

    private LinkedList<String> solicitudes;

    public Buffer(int capacidadSolicitudes) {
        this.capacidadSolicitudes = capacidadSolicitudes;
        this.solicitudes = new LinkedList<>();
    }


    /**
     * Este método lo usan los clientes para agregar una solicitud al buffer
     * 
     * @param solicitud
     */
    public synchronized void almacenarSolicitud(String solicitud) {
        while (this.solicitudes.size() == this.capacidadSolicitudes) {
            try {
                wait();
            } catch (InterruptedException e) {

            }
        }

        this.solicitudes.add(solicitud);
       
    }


    /**
     * Este método lo usan los servidores para obtener una solicitud del buffer
     * 
     * @return
     */
    public synchronized String retirarSolicitud() {
        while (this.solicitudes.size() == 0) {
            try {
                wait();
            } catch (InterruptedException e) {

            }
        }


        notifyAll();
        

        return this.solicitudes.removeFirst();
    }



}
