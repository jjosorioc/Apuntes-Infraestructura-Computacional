package laboratorios.taller8;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.security.NoSuchAlgorithmException;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class Main3 {

    public static void main(String[] args) throws NoSuchAlgorithmException, IOException {
        String texto = "La nueva realidad";
        KeyGenerator keygen = KeyGenerator.getInstance("AES");

        // Genere una llave secreta y guárdela en un archivo. Utilice el siguiente fragmento de
        // código
        FileOutputStream archivo = new FileOutputStream("src/laboratorios/taller8/llave.txt");
        ObjectOutputStream oos = new ObjectOutputStream(archivo);

        SecretKey llave = keygen.generateKey();
        oos.writeObject(llave);
        oos.close();

        // Cifre un mensaje de entrada. Almacene el texto cifrado en un archivo. Utilice el
        // siguiente
        // fragmento de código
        byte[] textoCifrado = Simetrico.cifrar(llave, texto);
        archivo = new FileOutputStream("src/laboratorios/taller8/textoCifrado.txt");
        oos = new ObjectOutputStream(archivo);

        oos.writeObject(textoCifrado);
        oos.close();


    }
}
