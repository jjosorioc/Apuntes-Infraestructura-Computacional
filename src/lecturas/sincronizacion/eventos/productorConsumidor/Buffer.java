package lecturas.sincronizacion.eventos.productorConsumidor;

import java.util.ArrayList;

public class Buffer {
    private ArrayList buff;
    private int n;

    public Buffer(int n) {
        this.n = n;
        buff = new ArrayList();
    }

    public synchronized void almacenar(Integer i) {
        while (buff.size() == n) {
            try {
                wait(); // Conceptual
            } catch (InterruptedException e) {
            }
        }
        buff.add(i);
        notify();
    }


    public synchronized Integer retirar() {
        while (buff.size() == 0) {
            try {
                wait(); // Conceptual
            } catch (InterruptedException e) {
            }
        }
        Integer i = (Integer) buff.remove(0);
        notify();
        return i;
    }

}
