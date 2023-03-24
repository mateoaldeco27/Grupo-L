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


        //Extracción de datos del .txt y armado de objetos
        for (int i = 1; i < resultadoDatos.length; i++)
        {
            //Extracción de datos de la fila
            String[] infoPartido = resultadoDatos[i].split(",");

            Equipo equipo1 = new Equipo(Integer.parseInt(infoPartido[0]), infoPartido[1], infoPartido[2]);
            Equipo equipo2 = new Equipo(Integer.parseInt(infoPartido[6]), infoPartido[5], infoPartido[7]);
            Partido nuevoPartido = new Partido(equipo1, Integer.parseInt(infoPartido[3]), Integer.parseInt(infoPartido[4]), equipo2);
            System.out.println("\nEn el Partido "+ i +" jugaron "+ equipo1.GetNombre() +" y "+ equipo2.GetNombre() +". "+ equipo1.GetNombre() +" hizo "+ nuevoPartido.getGoles1() +" gol/goles y "+ equipo2.GetNombre() +" hizo "+ nuevoPartido.getGoles2() +" gol/goles.");
            System.out.println("El Nombre del Equipo 1 es: "+ equipo1.GetNombre() +", su id es: "+ equipo1.GetId() +" y su descipción es: "+ equipo1.GetDescripcion() +"\nEl Nombre del Equipo 2 es: "+ equipo2.GetNombre() +" su id es: "+ equipo2.GetId() +" y su descipción es: "+ equipo2.GetDescripcion());

            //extracción de los datos del pronostico
            Pronostico nuevoPronostico = new Pronostico(nuevoPartido,equipo1,equipo2);
            nuevoPronostico.ComprobarDatos(pronosticoDatos[i]);

            //NO ESTA FUNCIONANDO CORRECTAMENTE, SIEMPRE ME ARROJA EL MISMO RESULTADO.
            nuevoPronostico.AcertoElPronostico();
            System.out.println("los puntos totales son: " + nuevoPronostico.puntos);




        }














    }
}

