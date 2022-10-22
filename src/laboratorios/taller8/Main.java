package laboratorios.taller8;

import java.security.NoSuchAlgorithmException;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class Main {
    private final static String ALGORITMO = "AES";


    public static void imprimir(byte[] contenido) {
        int i = 0;
        for (; i < contenido.length - 1; i++) {
            System.out.print(contenido[i] + " ");
        }
        System.out.println(contenido[i] + " ");
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        String texto = "La nueva realidad";
        System.out.println(texto);

        byte[] bytes = texto.getBytes();
        System.out.println("\nBytes del texto:");
        imprimir(bytes);

        KeyGenerator keygen = KeyGenerator.getInstance(ALGORITMO);
        SecretKey llave = keygen.generateKey();

        long tiempoInicial = System.nanoTime();
        byte[] textoCifrado = Simetrico.cifrar(llave, texto);
        long tiempoFinal = System.nanoTime();
        System.out.println("\nTexto cifrado -- Tiempo: " + (tiempoFinal - tiempoInicial) + " ns");
        imprimir(textoCifrado);

        tiempoInicial = System.nanoTime();
        byte[] textoDescifrado = Simetrico.descifrar(llave, textoCifrado);
        tiempoFinal = System.nanoTime();
        System.out
                .println("\nTexto descifrado -- Tiempo: " + (tiempoFinal - tiempoInicial) + " ns");
        imprimir(textoDescifrado);

        String textoDescifradoString = new String(textoDescifrado);

        System.out.println("\nTexto descifrado: " + textoDescifradoString);
    }
}
