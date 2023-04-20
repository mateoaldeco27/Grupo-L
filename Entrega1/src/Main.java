import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {

        // Path resultado = Paths.get("./resultados.csv");
        Path resultado = Paths.get("Entrega1/src/resultados.csv");
        // Path pronostico = Paths.get("./pronostico.csv");
        Path pronostico = Paths.get("Entrega1/src/pronostico.csv");

        String resultadoString;
        String pronosticoString;
        try {
            resultadoString = Files.readString(resultado);
            pronosticoString = Files.readString(pronostico);

        } catch (IOException e) {
            System.out.println("Error en la ruta del archivo");
            System.exit(0);
            throw new RuntimeException(e);
        }

        String[] resultadoDatosFila = resultadoString.split("\n");
        String[] pronosticoDatosFila = pronosticoString.split("\n");


        ArrayList<Partido> partidos = new ArrayList<>();

        ArrayList<Participante> participantes = new ArrayList<>();

        ArrayList<Ronda> rondas = new ArrayList<>();

        // agrego id
        int id = 0;
        int indicePartido;

        // ronda predeterminada
        Ronda nuevaRonda = new Ronda();
        rondas.add(nuevaRonda);

        // Extracción de datos del .csv y armado de objetos Equipo y Partido
        for (int i = 1; i < pronosticoDatosFila.length; i++) {

            String[] pronosticoColumna_Fila = pronosticoDatosFila[i].split(";");


            // creo participantes con if
            if (id != Integer.parseInt(pronosticoColumna_Fila[0])) {
                Participante nuevoParticipante = new Participante(Integer.parseInt(pronosticoColumna_Fila[0]), pronosticoColumna_Fila[1]);
                participantes.add(nuevoParticipante);
                id++;
            }

            indicePartido = i;
            while (indicePartido > resultadoDatosFila.length - 1) {
                indicePartido = indicePartido - (resultadoDatosFila.length - 1);
            }

            System.out.println("indicePartido -> " + indicePartido + " i -> " + i); // ELIMINAR

            // Extracción de datos de la fila de resultados.csv
            String[] resultadoColumna_Fila = resultadoDatosFila[indicePartido].split(";");


            // Armado de objetos equipo1, equipo2 y nuevoPartido, con base a las posiciones de las columnas de resultados.csv
            Equipo equipo1 = new Equipo(Integer.parseInt(resultadoColumna_Fila[2]), resultadoColumna_Fila[3], resultadoColumna_Fila[4]);
            Equipo equipo2 = new Equipo(Integer.parseInt(resultadoColumna_Fila[8]), resultadoColumna_Fila[7], resultadoColumna_Fila[9]);
            Partido nuevoPartido = new Partido(equipo1, Integer.parseInt(resultadoColumna_Fila[5]), Integer.parseInt(resultadoColumna_Fila[6]), equipo2);

            if (partidos.size() < resultadoDatosFila.length - 1) {
                partidos.add(nuevoPartido);
            }


            // Extracción de datos de la fila, armado del objeto pronostico, y seteo de expectativa; con base al archivo pronostico.csv
            Pronostico nuevoPronostico = new Pronostico(nuevoPartido, equipo1, equipo2);

            nuevoPronostico.setParticipante(participantes.get(id - 1));

            mostramePorConsola(nuevoPartido, indicePartido, participantes, id, nuevoPronostico, pronosticoColumna_Fila);
            ronda(indicePartido, id, nuevoPartido, rondas, resultadoDatosFila,resultadoColumna_Fila, participantes);
        }

        listaGanadores(participantes);

        System.out.println("rondas.size = " + rondas.size());
    }

    public static void mostramePorConsola(Partido nuevoPartido, int indicePartido, ArrayList<Participante> participantes,
                                          int idParticipantes, Pronostico nuevoPronostico, String[] infoPronostico) {

        System.out.println("\n000000000000000000000000");

        // Muestra número de partidos e información
        System.out.println(nuevoPartido.mostrameDatosPartido(indicePartido));

        // (nombre) espera que...
        nuevoPronostico.ComprobarDatos(infoPronostico, participantes, idParticipantes);

        // Equipo que ganó el partido
        nuevoPartido.GanadorPartido(indicePartido);

        // Salida personalizada por cada participante

        //System.out.println("nuevoPronostico.puntos before AcertoElPronostico -> " + nuevoPronostico.puntos);
        nuevoPronostico.AcertoElPronostico(participantes, idParticipantes);

        //System.out.println("nuevoPronostico.puntos after AcertoElPronostico -> " + nuevoPronostico.puntos);


        System.out.println("De momento, " + participantes.get(idParticipantes - 1).getNombre() + " tiene "
                + participantes.get(idParticipantes - 1).getPuntos() + " punto/s.\n");

        System.out.println("000000000000000000000000");

    }

    public static void listaGanadores(ArrayList<Participante> participantes) {
        ArrayList<Participante> participantesAux = (ArrayList<Participante>) participantes.clone();

        System.out.println("\n-------------------------\n\t   ¡GANADORES!\n");

        int max = participantesAux.get(0).getPuntos();

        int min = participantesAux.get(0).getPuntos();
        int jmax = 0;
        int jmin = 0;

        System.out.println("⬇️⬇️⬇️⬇️⬇️ MAYOR PUNTAJE ⬇️⬇️⬇️⬇️⬇️");
        System.out.println("-------------------------");
        for (int i = 0; i < participantesAux.size(); i++) {


            for (int j = 0; j < participantesAux.size(); j++) {

                if (participantesAux.get(j).getPuntos() >= max) {
                    max = participantesAux.get(j).getPuntos();
                    jmax = j;

                } else {
                    min = participantesAux.get(j).getPuntos();
                    jmin = j;
                }
            }
            System.out.println(participantesAux.get(jmax).getNombre() + "\t|\t" + max + "\tPUNTO/S" + "\n-------------------------");
            participantesAux.remove(jmax);
            max = participantesAux.get(0).getPuntos();
            min = participantesAux.get(0).getPuntos();
            i = 0;
        }
        System.out.println(participantesAux.get(0).getNombre() + "\t|\t" + min + "\tPUNTO/S\n-------------------------");
        System.out.println("⬆️⬆️⬆️⬆️⬆️MENOR PUNTAJE ⬆️⬆️⬆️⬆️⬆️");
    }

    public static void ronda(int i,int idParticipantes, Partido nuevoPartido,ArrayList<Ronda> rondas,  String[] resultadoDatosFila,String[] resultadoColumna_Fila, ArrayList<Participante> participantes) {

        // divido el iterador por la cantidad de partidos por ronda(3)
        int resto = i % rondas.get(0).getPartidosxronda();
        if (resto == 0) {
            //agrega el partido a la ronda
            rondas.get(rondas.size()-1).agregarPartido(nuevoPartido);
            System.out.println("agregamos otro partido: " + nuevoPartido.mostrameDatosPartido(i));

            //cada 3 partidos crea una nueva ronda y la añade a la arraylist rondas
            System.out.println("------ acá hay una nueva ronda --------");
            Ronda nuevaRonda = new Ronda();
            rondas.add(nuevaRonda);
            nuevaRonda.setResultadoRondaParcial(participantes.get(idParticipantes - 1).getPuntos());
            System.out.println("EL RESULTADO DE ESTA RONDA ES: " + nuevaRonda.getResultadoRondaParcial());
            nuevaRonda.sumaResultadoRondaFinal();
            //participantes.get(idParticipantes - 1).sumaPuntosFinales();
            participantes.get(idParticipantes - 1).setPuntos(0);

        }
        else {
                    if (Integer.parseInt(resultadoColumna_Fila[1]) <= rondas.get(0).getPartidosxronda() )
                    {
                        rondas.get(rondas.size() - 1).agregarPartido(nuevoPartido);
                        System.out.println("agregamos otro partido: " + nuevoPartido.mostrameDatosPartido(i));
                    }
        }
        System.out.println("EL RESULTADO FINAL ES: " + rondas.get(rondas.size()-1).getResultadoRondaFinal());
    }
}


