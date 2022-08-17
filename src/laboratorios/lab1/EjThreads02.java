package laboratorios.lab1;
/**
 * 
 */

/**
 * @author jj
 *Creación de threads como implementación de la interfaz Runnable
 */
public class EjThreads02 implements Runnable {

	@Override
	public void run() {
		System.out.println("Implementando la interfaz Runnable.");

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Thread t = new Thread(new EjThreads02());
		
		t.start();
	}

}
