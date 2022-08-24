package ejerciciosEnClase.productor_consumidor;

/**
 * ejemplo visto en clase de Productor-Consumidor.
 */
public class Principal {
    public static void main(String[] args) {
        Buzon buzon = new Buzon(10);
        Productor productor = new Productor(10, buzon);
        Consumidor consumidor = new Consumidor(10, buzon);
        
        productor.start();
        consumidor.start();
    }
    
}
