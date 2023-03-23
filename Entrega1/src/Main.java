import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws IOException {

        System.out.println("Hello world!");

        Path archivo = Paths.get("Entrega1/src/resultados.txt");

        System.out.println(Files.readString(archivo));

        String archivoString = Files.readString(archivo);
        String[] archivoDatos = archivoString.split(";");

        System.out.println(archivoDatos.length);

        int cantColumnas = 0;
        for (String lineas2aux : archivoString.split(",")) {
            cantColumnas++;
        }
        for (String lineas : archivoString.split(";")) {
            System.out.println(lineas);
            for (String lineas2 : lineas.split(",")) {
                System.out.println(lineas2);
                Equipo equipo1 = new Equipo();
            }
        }

        System.out.println("cantColumnas -> "+ cantColumnas);

    }
}
