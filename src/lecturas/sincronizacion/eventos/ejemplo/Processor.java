package lecturas.sincronizacion.eventos.ejemplo;

import java.util.LinkedList;
import java.util.Random;

public class Processor {
    private LinkedList<Integer> list= new LinkedList<Integer>(); // lista de nuemeros enteros
    private final int LIMIT = 10; //limite de la lista
    private Object lock =new Object(); 
    public void produce()throws InterruptedException{ 
        int value = 0; 
        while(true){ 
            synchronized (lock){ 
                
                while (list.size()== LIMIT){ //si el tamaño de la lista es igual al limite, espera a que se produzca un evento de consumir
                    lock.wait(); 
                }
                list.add(value++); //agrega un numero a la lista
                lock.notify(); //notifica al thread que esta esperando en el metodo consume
                } 
        }
    }
    public void consume()throws InterruptedException{ 

        Random random = new Random();
        while(true){ 
            synchronized (lock){ 
                
                while (list.size()== 0){ //si el thread inica en este proceso y no hay nada en la lista, espera a que se produzca algo
                    lock.wait(); 
                }
                System.out.println("List size is "+list.size());
                int value= list.removeFirst(); // elimina el primer elemento de la lista
                System.out.println("Consumed value is "+value);
                lock.notify(); //notifica al thread que esta esperando en el metodo produce
                } 

                Thread.sleep(random.nextInt(1000));
        }

        
    }
}
