package laboratorios.lab5.monothread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class ProtocoloCliente {


    public static void procesar(BufferedReader stdIn, BufferedReader pIn, PrintWriter pOut)
            throws IOException {


        // Lee del teclado
        System.out.println("Escriba el mensaje para enviar: ");
        String fromUser = stdIn.readLine();

        // Envía el mensaje al servidor
        pOut.println(fromUser);

        String fromSever = "";

        // Lee la respuesta del servidor
        // Si lo que llega del servidor no es null observe la asignación luego la condición
        if ((fromSever = pIn.readLine()) != null) {
            System.out.println("Servidor: " + fromSever);
        }

    }
}
