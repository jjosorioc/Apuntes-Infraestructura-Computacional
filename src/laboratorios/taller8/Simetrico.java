package laboratorios.taller8;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;

public class Simetrico {

    /**
     * ECB (Electronic Code Book): Cada bloque es cifrado con el mismo algoritmo y la misma llave.
     * Este esquema no es suficientemente fuerte dado que el texto cifrado puede generar fuga de
     * información sobre el contenido de la entrada cuando diferentes bloques de la entrada son
     * iguales.
     * 
     * CBC (Cipher Block Chaining): El modo CBC ejecuta operaciones adicionales sobre los bloques de
     * entrada para garantizar que los bloques cifrados de salida sean diferentes aun cuando los
     * bloques de entrada sean iguales. Observe que estos algoritmos cuentan con un vector de
     * inicialización (VI) que permite procesar el primer bloque de la misma manera que los demás
     */
    private final static String PADDING = "AES/ECB/PKCS5Padding";


    /**
     * Método que cifra un mensaje
     * 
     * @param llave
     * @param texto
     * @return
     */
    public static byte[] cifrar(SecretKey llave, String texto) {
        byte[] textoCifrado;

        try {
            Cipher cifrador = Cipher.getInstance(PADDING);
            byte[] textoClaro = texto.getBytes();

            cifrador.init(Cipher.ENCRYPT_MODE, llave);
            textoCifrado = cifrador.doFinal(textoClaro);

            return textoCifrado;
        } catch (Exception e) {
            System.out.println("Excepcion: " + e.getMessage());
            return null;
        }
    }


    /**
     * Método para descifrar un mensaje.
     * 
     * @param llave
     * @param texto
     * @return
     */
    public static byte[] descifrar(SecretKey llave, byte[] texto) {
        byte[] textoClaro;

        try {
            Cipher cifrador = Cipher.getInstance(PADDING);
            cifrador.init(Cipher.DECRYPT_MODE, llave);
            textoClaro = cifrador.doFinal(texto);


        } catch (Exception e) {
            System.out.println("Excepcion: " + e.getMessage());
            return null;
        }
        return textoClaro;
    }



}
