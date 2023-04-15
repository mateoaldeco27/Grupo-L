package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Main {
  public static void main(String[] args) throws IOException {

      // extraer los datos del archivo resultados.csv
      Path resultado = Paths.get("Test/src/main/java/org/example/resultados.csv");
      // extraer los datos del archivo pronostico.csv
      Path pronostico = Paths.get("Test/src/main/java/org/example/pronostico.csv");
      if (!Files.exists(resultado) || !Files.exists(pronostico)) {
          System.out.println("Error en la ruta del archivo");
          System.exit(0);
      }
      // Path resultado = Paths.get("./resultados.csv");
      String resultadoString = Files.readString(resultado);
      String[] resultadoDatos = resultadoString.split("\n");

      // Path pronostico = Paths.get("./pronostico.csv");
      String pronosticoString = Files.readString(pronostico);
      String[] pronosticoDatos = pronosticoString.split("\n");

    // new
    ArrayList<Partido> partidos = new ArrayList<>();

    // new
    ArrayList<Participante> participantes = new ArrayList<>();

    ArrayList<Ronda> rondas = new ArrayList<>();

    ArrayList<Integer> idRondas = new ArrayList<>();

    // Extracción de datos del .csv y armado de objetos Equipo y Partido
    

    
    // agrego id
    int id = 0;
    int indicePartido = 0;

    int puntosTotales = 0;

    for (int i = 1; i < pronosticoDatos.length; i++) {

        String[] infoPronostico = pronosticoDatos[i].split(";");

        // creo participantes con if
      if (id != Integer.parseInt(infoPronostico[0])) {
        Participante nuevoParticipante = new Participante(Integer.parseInt(infoPronostico[0]), infoPronostico[1]);
        participantes.add(nuevoParticipante);
        id++;
      }

      indicePartido = i;


      while (indicePartido > resultadoDatos.length-1) {
        indicePartido = indicePartido - (resultadoDatos.length - 1);
      }

      // Extracción de datos de la fila de resultados.csv
      System.out.println("indicePartido -> " + indicePartido + " i -> " + i); // ELIMINAR
      
      String[] infoPartido = resultadoDatos[indicePartido].split(";");


      // Armado de objetos equipo1, equipo2 y nuevoPartido, con base a las posiciones de las columnas de resultados.csv
      Equipo equipo1 = new Equipo(Integer.parseInt(infoPartido[3]), infoPartido[4], infoPartido[5]);
      Equipo equipo2 = new Equipo(Integer.parseInt(infoPartido[9]), infoPartido[9], infoPartido[10]);
      Partido nuevoPartido = new Partido(equipo1, Integer.parseInt(infoPartido[6]), Integer.parseInt(infoPartido[7]), equipo2);

      if (partidos.size() < resultadoDatos.length-1) {
        partidos.add(nuevoPartido);
      }

      ronda(nuevoPartido, infoPartido, resultadoDatos, rondas, idRondas);


      // Extracción de datos de la fila, armado del objeto pronostico, y seteo de
      // expectativa; con base al archivo pronostico.csv
      Pronostico nuevoPronostico = new Pronostico(nuevoPartido, equipo1, equipo2);

      nuevoPronostico.setParticipante(participantes.get(id - 1));

    }

    listaGanadores(participantes);

    System.out.println(rondas.size());

  }

  public static void mostramePorConsola(Partido nuevoPartido, int indicePartido, ArrayList<Participante> participantes,
      int idParticipantes, Pronostico nuevoPronostico, ArrayList<Integer> puntos, String[] infoPronostico) {

    System.out.println("\n000000000000000000000000");

    // Muestra número de partidos e información
    System.out.println(nuevoPartido.mostrameDatosPartido(indicePartido));

    // (nombre) espera que...
    nuevoPronostico.ComprobarDatos(infoPronostico, participantes, idParticipantes);

    // Equipo que ganó el partido
    nuevoPartido.GanadorPartido(indicePartido);

    // Salida personalizada por cada participante

     nuevoPronostico.AcertoElPronostico( participantes, idParticipantes);

     System.out.println("De momento, " + participantes.get(idParticipantes - 1).getNombre() + " tiene "
          + participantes.get(idParticipantes - 1).getPuntos() + " punto/s.\n");

     System.out.println("000000000000000000000000");

    

  }

    public static void listaGanadores (ArrayList<Participante> participantes) {
      ArrayList<Participante> participantesAux = (ArrayList<Participante>)participantes.clone();


      System.out.println("\n-------------------------\n\t   ¡GANADORES!\n");

    int max = participantesAux.get(0).getPuntos();

//System.out.println(max);
      
    int min = participantesAux.get(0).getPuntos();
    int jmax = 0;
      int jmin = 0;



System.out.println("⬇️⬇️⬇️⬇️⬇️ MAYOR PUNTAJE ⬇️⬇️⬇️⬇️⬇️");
      System.out.println("-------------------------");
        for (int i = 0; i < participantesAux.size(); i++) {


            for (int l=0; l < participantesAux.size(); l++ ) {   

            }
          
            for (int j = 0; j < participantesAux.size(); j++) {

                if (participantesAux.get(j).getPuntos() >= max) {
                    max = participantesAux.get(j).getPuntos();
                    jmax = j;

                }
                else {
                    min = participantesAux.get(j).getPuntos();
                  jmin = j;

                }
            }
            System.out.println(participantesAux.get(jmax).getNombre() + "\t|\t"+ max + "\tPUNTO/S"+ "\n-------------------------" );
            participantesAux.remove(jmax);
            max = participantesAux.get(0).getPuntos();
          min = participantesAux.get(0).getPuntos();
            i = 0;
        }
      System.out.println(participantesAux.get(0).getNombre() + "\t|\t"+ min + "\tPUNTO/S\n-------------------------");
    System.out.println("⬆️⬆️⬆️⬆️⬆️ MENOR PUNTAJE ⬆️⬆️⬆️⬆️⬆️");

}

public static void ronda (Partido nuevoPartido, String[] infoPartido, String[] resultadoDatos, ArrayList<Ronda> rondas, ArrayList<Integer> idRondas)  {

      if (!idRondas.contains(Integer.parseInt(infoPartido[0]))) {
                idRondas.add(Integer.parseInt(infoPartido[0]));
                Ronda nuevaRonda = new Ronda(nuevoPartido);
                rondas.add(nuevaRonda);
                nuevaRonda.setNumero(Integer.parseInt(infoPartido[0]));
        }
      System.err.println(rondas.size());

    }
}
