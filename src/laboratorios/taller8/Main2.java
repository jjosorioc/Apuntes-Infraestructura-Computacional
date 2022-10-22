package laboratorios.taller8;

import java.security.NoSuchAlgorithmException;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class Main2 {


    public static void main(String[] args) throws NoSuchAlgorithmException {

        String texto = "La nueva realidad";
        KeyGenerator keygen = KeyGenerator.getInstance("AES");

        SecretKey k1 = keygen.generateKey();
        SecretKey k2 = keygen.generateKey();

        byte[] tc1 = Simetrico.cifrar(k1, texto);
        byte[] tc2 = Simetrico.cifrar(k2, texto);

        System.out.println("\nDescifrar tc1 con k1: " + new String(Simetrico.descifrar(k1, tc1)));
        Main.imprimir(tc1);

        System.out.println("\nDescifrar tc1 con k2: " + new String(Simetrico.descifrar(k2, tc2)));
        Main.imprimir(tc2);
    }
}
