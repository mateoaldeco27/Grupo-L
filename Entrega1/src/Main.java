import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {

        //extraer los datos del archivo resultados.csv
        Path resultado = Paths.get("Entrega1/src/resultados.csv");
        String resultadoString = Files.readString(resultado);
        String[] resultadoDatos = resultadoString.split("\n");

        //extraer los datos del archivo pronostico.csv
        Path pronostico = Paths.get("Entrega1/src/pronostico.csv");
        String pronosticoString = Files.readString(pronostico);
        String[] pronosticoDatos = pronosticoString.split("\n");


        //new
        ArrayList<Partido> partidos = new ArrayList<>();

        //new
        ArrayList<Participante> participantes = new ArrayList<>();


        //Extracción de datos del .csv y armado de objetos Equipo y Partido
        int puntos = 0;
        //agrego id
        int id = 0;
        for (int i = 1; i < pronosticoDatos.length; i++) {

            String[] infoPronostico = pronosticoDatos[i].split(";");

            //creo participantes con if
            if (id != Integer.parseInt(infoPronostico[0])){
                Participante nuevoParticipante = new Participante(Integer.parseInt(infoPronostico[0]), infoPronostico[1], RESULTADO.ganador);
                participantes.add(nuevoParticipante);
                id++;
            }

            //System.out.println("Id del participante i("+i+"): " + participantes.get(i).getId());
            if (partidos.size() < 5 )
            {
                for (int j = 1; j < resultadoDatos.length; j++) {
                    //Extracción de datos de la fila de resultados.csv
                    String[] infoPartido = resultadoDatos[j].split(";");

                    //String[] infoPronostico = pronosticoDatos[i].split(";");


                    //Armado de objetos equipo1, equipo2 y nuevoPartido, con base a las posiciones de las columnas de resultados.csv
                    Equipo equipo1 = new Equipo(Integer.parseInt(infoPartido[0]), infoPartido[1], infoPartido[2]);
                    Equipo equipo2 = new Equipo(Integer.parseInt(infoPartido[6]), infoPartido[5], infoPartido[7]);
                    Partido nuevoPartido = new Partido(equipo1, Integer.parseInt(infoPartido[3]), Integer.parseInt(infoPartido[4]), equipo2);


                    //new
                    if (!partidos.contains(nuevoPartido)) {

                        partidos.add(nuevoPartido);


                    }

                    //System.out.println("---------------" + nuevoPartido.mostrameDatosPartido(j));


                    //new modified

                    nuevoPartido.mostrameDatosPartido(i);
                    //Extracción de datos de la fila, armado del objeto pronostico, y seteo de expectativa; con base al archivo pronostico.csv
                    Pronostico nuevoPronostico = new Pronostico(nuevoPartido, equipo1, equipo2);
                    //new modified
                    nuevoPronostico.ComprobarDatos(infoPronostico);


                    nuevoPartido.GanadorPartido(i);
                    nuevoPronostico.AcertoElPronostico();
                    System.out.println("\nEn este Partido Mariana obtuvo: " + nuevoPronostico.puntos + " punto/s.");
                    puntos = puntos + nuevoPronostico.puntos;
                }
            }

        }

        System.out.println("\nLos puntos totales de Mariana son: " + puntos);
/*
        for (Partido listaPartidos : partidos) {
            System.out.println(listaPartidos.getNombreEquipo1());
        }
*/
        System.out.println(partidos.size());
        System.out.println("La cantidad de participantes son: " + participantes.size());

        }

    }

