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
        String[] infopartido1 = archivoDatos[1].split(",");
        String[] infopartido2 = archivoDatos[2].split(",");

        Equipo equipo1 = new Equipo(Integer.parseInt(infopartido1[0]),infopartido1[1]);
        Equipo equipo2 = new Equipo(Integer.parseInt(infopartido1[5]),infopartido1[4]);

        Partido partido1 = new Partido(equipo1,Integer.parseInt(infopartido1[2]),Integer.parseInt(infopartido1[3]),equipo2);


    }
}

