package lecturas.sincronizacion.eventos.ejemplo;
// En general esta clase se encarga de correr los threads. La implementación es distinta, pero hace lo mismo que ejemplos anteriores


public class App { 
    public static void main(String[] args) throws InterruptedException { 
        final Processor processor = new Processor(); 
        Thread t1= new Thread(new Runnable() { 
             @Override 
             public void run() { 
                try { 
                    processor.produce(); //Este thread corre el proceso de producir
                }
                catch (InterruptedException e) { 
                    e.printStackTrace(); 
                } 
            } 
        }); 
        Thread t2 = new Thread(new Runnable() { 
            @Override public void run(){ 
                try { 
                    processor.consume();  // Este thread corre el proceso de consumir
                }
                catch (InterruptedException e) {
                     e.printStackTrace(); 
                    } 
                } 
            }); 
            t1.start(); 
            t2.start();
        }
}