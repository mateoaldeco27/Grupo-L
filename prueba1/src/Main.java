import java.io.File;
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

        Boolean archivo = Files.exists(Paths.get(textoNuevo));

        if (archivo == true) {
            Files.writeString(Paths.get(textoNuevo), contenido + "\n\t"+ contenido2);
            System.out.println("El archivo "+ nombreArchivo +" existe y ya se le ha agregado el contenido. Echale una mirada!! :)");
            System.out.println("Has mirado el archivo?");
            scanner.nextLine();
            System.out.println("Espero que sí, porque ya no existe más!!!!! XDD");
            Files.delete(Paths.get(textoNuevo));
        }
        else {
            System.out.println("El archivo "+ nombreArchivo +" no existe, pero descuida que ya ha se ha creado!! Vuelve a ejecutar el programa! :)");
            Files.createFile(Paths.get(textoNuevo));
        }

    }
}