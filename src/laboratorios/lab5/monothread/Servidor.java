package laboratorios.lab5.monothread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static final int PUERTO = 3400;

    public static void main(String[] args) throws IOException {
        ServerSocket ss = null;
        boolean continuar = true;

        System.out.println("Main Server ...");

        try {
            ss = new ServerSocket(PUERTO);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.err.println("No se pudo crear el socket en el puerto: " + PUERTO);
            System.exit(-1);
        }


        while (continuar) {
            // Crea el socket en el lado servidor
            // Queda bloqueado esperando la conexión del cliente
            Socket socket = ss.accept();

            try {
                // Se conectan los flujos, tanto de salida como de entrada
                PrintWriter escritor = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader lector =
                        new BufferedReader(new InputStreamReader(socket.getInputStream()));


                // Se ejectura el protocolo en el lado servidor
                ProtocoloServidor.procesar(lector, escritor);

                // Se cierran los flujos y el socket
                escritor.close();
                lector.close();
                socket.close();

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
