package ejerciciosEnClase.productor_consumidor;

import java.util.ArrayList;

public class Buzon {
    
    private ArrayList<Integer> arrBuzon;
    private int n;

    public Buzon(int pN) {
        n = pN;
        arrBuzon = new ArrayList<Integer>();
    }

    public synchronized ArrayList<Integer> getArrBuzon() {
        return arrBuzon;
    }

    /**
     * agrega datos al buzon si no esta lleno.
     * 
     * @param pDato
     */
    public synchronized void almacenar(Integer pDato) {
        while (arrBuzon.size() == n) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        arrBuzon.add(pDato);
        System.out.println("Productor almaceno");
        System.out.println("P-Buzon: " + arrBuzon.size());
        notify();
    }

    /**
     * retira datos del buzon si no esta vacio.
     */
    public synchronized Integer retirar() {
        while (arrBuzon.size() == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Integer i = arrBuzon.remove(0);
        System.out.println("Consumidor retiro");
        System.out.println("C-Buzon: " + arrBuzon.size());
        notify();

        return i;
    }

}
