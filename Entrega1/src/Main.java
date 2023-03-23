import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws IOException {

        Path archivo = Paths.get("Entrega1/src/resultados.txt");

        System.out.println(Files.readString(archivo));

        String archivoString = Files.readString(archivo);
        String[] archivoDatos = archivoString.split(";");

        for (int i = 1; i < archivoDatos.length; i++) {
            Partido.CrearPartido(archivoDatos[i]);
        }
    }
}

