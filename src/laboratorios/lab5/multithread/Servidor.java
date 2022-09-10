package laboratorios.lab5.multithread;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static final int PUERTO = 3400;

    public static void main(String[] args) throws IOException {
        ServerSocket ss = null;
        boolean continuar = true;

        int numeroThreads = 0;

        System.out.println("Main Server ...");

        try {
            ss = new ServerSocket(PUERTO);
        } catch (Exception e) {
            System.out.println("Error al crear el socket");
            System.exit(-1);
        }


        while (continuar) {
            // Crear el socket
            Socket socket = ss.accept();

            // Crear el thread con el socket y id
            ThreadServidor thread = new ThreadServidor(socket, numeroThreads);
            numeroThreads++;

            /// Start
            thread.start();

        }
        ss.close();
    }
}
