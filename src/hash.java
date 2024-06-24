import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Scanner;

public class hash {
    /*
    * Opciones
    * 2 --> text hash
    * 3 --> -* file hash
    * 4---> -* file -* destino hash
    *
    * Opciones extras:
    * -d destino
    * -f file del que se quiere hacer hash
    * -t type hash
    *
    * */


    public static void main(String[] args) {
        if(args.length==2 && correctFormat(args)) {
            String cadena = args[0];
            String hash=args[1];

            try {
                MessageDigest md = MessageDigest.getInstance(hash);

                byte[] resultado=md.digest(cadena.getBytes());
                StringBuilder hexString = new StringBuilder();
                for (byte b : resultado) {
                    String hex = Integer.toHexString(0xff & b);
                    if (hex.length() == 1) {
                        hexString.append('0');
                    }
                    hexString.append(hex);
                }

                System.out.println(hexString);
            } catch (NoSuchAlgorithmException e) {
                System.out.println("Algoritmo no encontrado, unicamente puedo encriptar MD5, SHA-1 y SHA-256");
            }
        }else{
            System.out.println("Comprueba los valores introducidor");
        }




    }

    private static boolean correctFormat(String[] args) {
        args = Arrays.stream(args).filter(a -> !a.isEmpty()).toArray(String[]::new);
        return (args.length >= 1);
    }

}
