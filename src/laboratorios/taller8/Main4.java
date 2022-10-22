package laboratorios.taller8;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import javax.crypto.SecretKey;

public class Main4 {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // Recuperar llave
        FileInputStream archivo = new FileInputStream("src/laboratorios/taller8/llave.txt");
        ObjectInputStream ois = new ObjectInputStream(archivo);
        byte[] textCifrado = (byte[]) ois.readObject();
        ois.close();

        System.out.println("\nTexto cifrado");
        Main.imprimir(textCifrado);

        // Recuperar texto cifrado
        archivo = new FileInputStream("src/laboratorios/taller8/llave.txt");
        ois = new ObjectInputStream(archivo);
        SecretKey llave = (SecretKey) ois.readObject();
        ois.close();

        System.out.println(llave);

    }
}
