package lecturas.sincronizacion.eventos;

/*
 * Lectura NC 1.4.2: Eventos
 * 
 * el proceso que debe esperar llama al método esperar () y el que debe ejecutarse antes no llama a
 * este método. En lugar de eso, ejecuta lo que tenga que hacer y cuando esté listo para dar paso al
 * primero, todo lo que debe hacer es invocar el método avisar ()
 * 
 */
public class MyWaitNotify {
    private ObjetoMonitor objMonitor = new ObjetoMonitor();

    /**
     * Espera pasiva
     */
    public void esperar() {
        synchronized (objMonitor) {
            try {
                objMonitor.wait(); // espera pasiva
            } catch (InterruptedException e) {
            }
        }
    }

    /**
     * Notifica
     */
    public void avisar() {
        synchronized (objMonitor) {
            objMonitor.notify();
        }
    }
}
