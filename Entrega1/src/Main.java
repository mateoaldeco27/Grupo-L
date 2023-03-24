import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws IOException {

        //extraer los datos del archivo resultados.txt
        Path resultado = Paths.get("Entrega1/src/resultados.txt");
        String resultadoString = Files.readString(resultado);
        String[] resultadoDatos = resultadoString.split("\n");

        //extraer los datos del archivo pronostico.txt
        Path pronostico = Paths.get("Entrega1/src/pronostico.txt");
        String pronosticoString = Files.readString(pronostico);
        String[] pronosticoDatos = pronosticoString.split("\n");


        //Extracción de datos del .txt y armado de objetos Equipo y Partido
        int puntos = 0;
        for (int i = 1; i < resultadoDatos.length; i++)
        {
            //Extracción de datos de la fila de resultados.txt
            String[] infoPartido = resultadoDatos[i].split(",");

            //Armado de objetos equipo1, equipo2 y nuevoPartido, con base a las posiciones de las columnas de resultados.txt
            Equipo equipo1 = new Equipo(Integer.parseInt(infoPartido[0]), infoPartido[1], infoPartido[2]);
            Equipo equipo2 = new Equipo(Integer.parseInt(infoPartido[6]), infoPartido[5], infoPartido[7]);
            Partido nuevoPartido = new Partido(equipo1, Integer.parseInt(infoPartido[3]), Integer.parseInt(infoPartido[4]), equipo2);
            System.out.println("\nEn el Partido "+ i +" jugaron "+ equipo1.GetNombre() +" y "+ equipo2.GetNombre() +". "+ equipo1.GetNombre() +" hizo "+ nuevoPartido.getGoles1() +" gol/goles y "+ equipo2.GetNombre() +" hizo "+ nuevoPartido.getGoles2() +" gol/goles.");
            System.out.println("El Nombre del Equipo 1 es: "+ equipo1.GetNombre() +", su id es: "+ equipo1.GetId() +" y su descipción es: "+ equipo1.GetDescripcion() +"\nEl Nombre del Equipo 2 es: "+ equipo2.GetNombre() +" su id es: "+ equipo2.GetId() +" y su descipción es: "+ equipo2.GetDescripcion());

            //Extracción de datos de la fila, armado del objeto pronostico, y seteo de expectativa; con base al archivo pronostico.txt
            Pronostico nuevoPronostico = new Pronostico(nuevoPartido,equipo1,equipo2);
            nuevoPronostico.ComprobarDatos(pronosticoDatos[i]);

            //Resultados del partido y comparación con el pronóstico de Mariana.
            System.out.println("Goles Equipo 1 -> "+ nuevoPartido.getGoles1());
            System.out.println("Goles Equipo 2 -> "+ nuevoPartido.getGoles2());
            System.out.println("Ganador Partido "+ i +":");
            nuevoPartido.GanadorPartido();
            nuevoPronostico.AcertoElPronostico();
            System.out.println("En este Partido Mariana sacó: " + nuevoPronostico.puntos +" punto/s.");
            puntos = puntos + nuevoPronostico.puntos;
            System.out.println("De momento Mariana tiene: " + puntos +" punto/s.");
        }

        System.out.println("\nLos puntos totales de Mariana son: " + puntos);

    }
}

