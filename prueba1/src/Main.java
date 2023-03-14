import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);

        String nombreArchivo = "textoNuevo.txt";
        String textoNuevo = "prueba1/"+ nombreArchivo;

        String contenido = "Hello world!";
        String contenido2 = "Creo que ya pueden ver este código!! No?";

        final Path paths = Paths.get(textoNuevo);
        boolean archivo = Files.exists(paths);

        if (archivo) {
            Files.writeString(paths, contenido + "\n\t"+ contenido2);
            System.out.println("El archivo "+ nombreArchivo +" existe y ya se le ha agregado el contenido. Echale una mirada!! :)");
            System.out.println("Has mirado el archivo?");
            scanner.nextLine();
            System.out.println("Espero que sí, porque ya no existe más!!!!! XDD");
            Files.delete(paths);
        }
        else {
            System.out.println("El archivo "+ nombreArchivo +" no existe, pero descuida que ya ha se ha creado!! Vuelve a ejecutar el programa! :)");
            Files.createFile(paths);
        }

    }
}