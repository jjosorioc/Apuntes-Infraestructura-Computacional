package laboratorios.lab1;

public class EjThreads01 extends Thread {
	public void run()
	{
		System.out.println("Extendiendo la clase Thread.");
	}
	
	
	public static void main(String[] args) {
		EjThreads01 threads01 = new EjThreads01();
		threads01.start();
	}
}
