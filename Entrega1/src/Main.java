import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws IOException {

        Path archivo = Paths.get("Entrega1/src/resultados.txt");

        System.out.println(Files.readString(archivo));

        String archivoString = Files.readString(archivo);

        //Split separando por filas eliminando el salto de línea
        String[] archivoDatos = archivoString.split("\n");

        int indiceColumna = 0;
        //Extracción de datos del .txt y armado de objetos
        for (int i = 1; i < archivoDatos.length; i++) {

            //Extracción de datos de la fila
            String[] infoPartido = archivoDatos[i].split(",");

            Equipo equipo1 = new Equipo(Integer.parseInt(infoPartido[indiceColumna]), infoPartido[indiceColumna+1], infoPartido[indiceColumna+2]);
            Equipo equipo2 = new Equipo(Integer.parseInt(infoPartido[indiceColumna+6]), infoPartido[indiceColumna+5], infoPartido[indiceColumna+7]);
            Partido partido1 = new Partido(equipo1, Integer.parseInt(infoPartido[indiceColumna+3]), Integer.parseInt(infoPartido[indiceColumna+4]), equipo2);
            System.out.println("\nEn el Partido "+ i +" jugaron "+ equipo1.GetNombre() +" y "+ equipo2.GetNombre() +". "+ equipo1.GetNombre() +" hizo "+ partido1.getGoles1() +" gol/goles y "+ equipo2.GetNombre() +" hizo "+ partido1.getGoles2() +" gol/goles.");
            System.out.println("El Nombre del Equipo 1 es: "+ equipo1.GetNombre() +", su id es: "+ equipo1.GetId() +" y su descipción es: "+ equipo1.GetDescripcion() +"\nEl Nombre del Equipo 2 es: "+ equipo2.GetNombre() +" su id es: "+ equipo2.GetId() +" y su descipción es: "+ equipo2.GetDescripcion());
        }
    }
}