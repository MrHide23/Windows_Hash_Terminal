import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Scanner;

public class hash {
    /*
    * Opciones
    * 1 -h --> help
    * 2 --> text hash
    * 3 --> -* file hash
    * 4---> -* file -* destino hash
    *
    * Opciones extras:
    * -d destino
    * -f file del que se quiere hacer hash
    * -t text
    * -hs hash type
    *
    * */


    public static void main(String[] args) {
        /*
        * 1-berificamos formato
        * 2-Detectamos opcion
        * 3- Ejecutamos opcion
        * */
        if(correctFormat(args)) {
            String cadena = args[0];
            String hash=args[1];

            switch (tipe(args)){
                case 2:
                    //Opcion de ayuda --> 
                    // 1- -h basico 
                    /// 2- -hs hash type
                    break;
                    case 3:
                        //Hash normal
                        break;
                    case 4:
                        //Hash de un archivo 
                        break:
                default:
                    System.out.println("Options of comands: ");
                    System.out.println(" -h: \t help");
                    System.out.println(" -f: \t Especifie the file that you want make a hash");
                    System.out.println(" -hs: \t help");
                    break;
            }

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

    public static int tipe(String[] args){
        return args.length;

    }

}
