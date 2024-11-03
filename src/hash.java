import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

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
            String cadena;
            String hash;
            

            try {
                System.out.println(args + args[0]);

            switch (tipe(args)){
                case 1:
                    //Opcion de ayuda --> 
                    // 1- -h basico 
                    if(args[0].equals("-h")){
                        hashHelp(args[0]);

                    }else{
                        throw new IOException();
                    }
                        
                break;
                case 2:
                    //Hash normal
                    if(correctStructure(args,2) ){
                        hash = args[0];
                        cadena = args[1];
                        hashText(hash, cadena);
                    }else{
                        throw new IOException();
                    }
                    
                    break;
                case 3:
                    //Hash de un archivo
                    if(correctStructure(args,3)){
                        hash = args[0];
                        cadena = args[2];
                        hashFile(hash, cadena);

                    }else{
                        throw new IOException();
                    }

                    break;
            }

               
            } catch (NoSuchAlgorithmException | IOException e) {
                System.out.println("Error format or Bad algorithm just MD5, SHA-1 and SHA-256");
            }

        }else{
            System.out.println("Bad format");
        }

    }

    private static void hashHelp(String h) {
        if(h.equals("-h")){
            System.out.println("Options of comands: ");
            System.out.println("Example: \t hash md5 text or hash hash_type -f  file.txt");
            System.out.println(" -h: \t help");
            System.out.println(" -f: \t Especifie the file that you want make a hash");
            System.out.println(" -hs: \t help");
            
            System.out.println("Hash Options: ");
            System.out.println("md5");
            System.out.println("sha-1");
            System.out.println("sha-256");
        }
    }

    private static String hashText(String hash, String text) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance(hash);
        byte[] resultado=md.digest(text.getBytes());
        StringBuilder hexString = new StringBuilder();
        for (byte b : resultado) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }

        return hexString.toString();

    }

    private static String hashFile(String hash, String file) throws NoSuchAlgorithmException, IOException {
        MessageDigest md = MessageDigest.getInstance(hash);
        InputStream is = Files.newInputStream(Paths.get(file));
        DigestInputStream dis = new DigestInputStream(is, md);
        byte[] buffer = new byte[1024];
        byte[] digest = md.digest();
        StringBuilder hexString = new StringBuilder();

        while (dis.read(buffer) != -1);
        for (byte b : digest) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }

            hexString.append(hex);
        }

        return hexString.toString();
    }

    private static boolean correctFormat(String[] args) {
        args = Arrays.stream(args).filter(a -> !a.isEmpty()).toArray(String[]::new);
        return (args.length >= 1);
    }

    private static boolean correctStructure(String [] args, int i ){
        boolean res = false;

        if(args[0].equals("md5") || args[0].equals("sha-1") || args[0].equals("sha-256") || 
         args[0].equals("MD5") || args[0].equals("SHA-1") || args[0].equals("SHA-256")){
             res = true;
             if(i == 3 && !args[1].equals("-f")){
                res = false;
             }
         }

        return res;
    }

    public static int tipe(String[] args){
        return args.length;
    }

}
