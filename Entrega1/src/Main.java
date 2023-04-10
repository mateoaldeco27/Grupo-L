import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Main {
  public static void main(String[] args) throws IOException {

    // extraer los datos del archivo resultados.csv
    Path resultado = Paths.get("Entrega1/src/resultados.csv");
    // Path resultado = Paths.get("./resultados.csv");
    String resultadoString = Files.readString(resultado);
    String[] resultadoDatos = resultadoString.split("\n");

    // extraer los datos del archivo pronostico.csv
    Path pronostico = Paths.get("Entrega1/src/pronostico.csv");
    // Path pronostico = Paths.get("./pronostico.csv");
    String pronosticoString = Files.readString(pronostico);
    String[] pronosticoDatos = pronosticoString.split("\n");

    // new
    ArrayList<Partido> partidos = new ArrayList<>();

    // new
    ArrayList<Participante> participantes = new ArrayList<>();

    // Extracción de datos del .csv y armado de objetos Equipo y Partido
    
    ArrayList<Integer> puntos = new ArrayList<>();
    
    // agrego id
    int id = 0;
    int indicePartido = 0;

    int puntosTotales = 0;
    // for (int i = 1; i < 11; i++) {
    for (int i = 1; i < pronosticoDatos.length; i++) {
      // for (int i = 1; i < 4; i++) {

      String[] infoPronostico = pronosticoDatos[i].split(";");

      // creo participantes con if
      if (id != Integer.parseInt(infoPronostico[0])) {
        Participante nuevoParticipante = new Participante(Integer.parseInt(infoPronostico[0]), infoPronostico[1]);
        participantes.add(nuevoParticipante);
        id++;
      }

      indicePartido = i;

      while (indicePartido > 5) {
        indicePartido = indicePartido - (resultadoDatos.length - 1);
      }

      // Extracción de datos de la fila de resultados.csv
      System.out.println("indicePartido -> " + indicePartido + " i -> " + i); // ELIMINAR
      
      String[] infoPartido = resultadoDatos[indicePartido].split(";");

      // Armado de objetos equipo1, equipo2 y nuevoPartido, con base a las posiciones de las columnas de resultados.csv
      Equipo equipo1 = new Equipo(Integer.parseInt(infoPartido[0]), infoPartido[1], infoPartido[2]);
      Equipo equipo2 = new Equipo(Integer.parseInt(infoPartido[6]), infoPartido[5], infoPartido[7]);
      Partido nuevoPartido = new Partido(equipo1, Integer.parseInt(infoPartido[3]), Integer.parseInt(infoPartido[4]),
          equipo2);

      if (partidos.size() < resultadoDatos.length - 1) {
        partidos.add(nuevoPartido);
      }

      // Muestra num de partido e informacion
      //System.out.println(nuevoPartido.mostrameDatosPartido(indicePartido));// ELIMINAR

      String[] infoPronostico2 = pronosticoDatos[i].split(";");

      // Extracción de datos de la fila, armado del objeto pronostico, y seteo de
      // expectativa; con base al archivo pronostico.csv
      Pronostico nuevoPronostico = new Pronostico(nuevoPartido, equipo1, equipo2);

      nuevoPronostico.setParticipante(participantes.get(id - 1));

      /*
      for (String lista_infoPronostico2 : infoPronostico2) {
        //System.out.println(lista_infoPronostico2);
      }
      */

      // (nombre) espera que...
      //nuevoPronostico.ComprobarDatos(infoPronostico2, participantes, id);

      // indicePartido -> indicePartido
      //nuevoPartido.GanadorPartido(indicePartido);

      // Salida personalizada por cada participante
      //nuevoPronostico.AcertoElPronostico(participantes, id);

      // System.out.println("indice de partido pronostico -> "+ i);

      //System.out.println("-------------\nEn este Partido " + participantes.get(id - 1).getNombre() + " obtuvo: " + nuevoPronostico.puntos + " punto/s.\n");

      //System.out.println("id -> " + id);

      // Todos los objetos puntos comienzan con 0 para guardar correctamente el dato
      
    /*
      if (puntos.size() < participantes.size()) {
        puntos.add(0);
      }
      */

      // modificar valor de la coleccion puntos

      //System.out.println("puntos.get(" + (id - 1) + ") -> " + puntos.get(id - 1));

      //puntosTotales = puntos.get(id - 1) + nuevoPronostico.puntos;
      //System.out.println("puntosTotales -> " + puntosTotales);

      //System.out.println("nuevoPronostico.puntos -> " + nuevoPronostico.puntos);
      //puntos.set((id - 1), puntosTotales);

      
      mostramePorConsola(nuevoPartido, indicePartido, participantes, id, nuevoPronostico, puntos, infoPronostico);
    }

    System.out.println("\nCantidad de partidos son: " + partidos.size() + " y son:");
    for (int i = 0; i < partidos.size(); i++) {
      System.out.println("Partido " + (i + 1) + " -> Equipo 1: " + partidos.get(i).Equipo1.GetNombre() + " | Equipo 2: "
          + partidos.get(i).Equipo2.GetNombre() + ".\n"
          + "goles 1: " + partidos.get(i).getGoles1() + " | goles 2: " + partidos.get(i).getGoles2());
    }

    System.out.println("La cantidad de participantes son: " + participantes.size() + " y son:");
    for (Participante listaParticipantes : participantes) {
      System.out.println(listaParticipantes.getNombre());
    }


     listaGanadores(participantes);
    
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

    //System.out.println("nuevoPronostico.puntos before AcertoElPronostico -> " + nuevoPronostico.puntos);
     nuevoPronostico.AcertoElPronostico( participantes, idParticipantes);

    //System.out.println("nuevoPronostico.puntos after AcertoElPronostico -> " + nuevoPronostico.puntos);
    

    //for (int k = 0; k < puntos.size(); k++) {
      System.out.println("De momento, " + participantes.get(idParticipantes - 1).getNombre() + " tiene "
          + participantes.get(idParticipantes - 1).getPuntos() + " punto/s.\n");
    //}

    /*
    for (int i = 0; i < puntos.size(); i++) {
      //System.out.println(puntos.get(i));
    }
    */



    /*
    for (int k = 0; k < puntos.size(); k++) {
        //System.out.println( "puntos.get(" + k + ") | " + participantes.get(k).getNombre() + " --> " + participantes.get(k).getPuntos() + " puntos");
    }
*/
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


//System.out.println(participantesAux.get(l).getPuntos());
            }
          

          
            for (int j = 0; j < participantesAux.size(); j++) {
                //System.out.println("max : "+ max + " min "+ min);

//System.out.println("PuntosPart -> "+ participantesAux.get(j).getPuntos() + " max -> "+ max);

              
              if (participantesAux.get(j).getPuntos() >= max) {
                    max = participantesAux.get(j).getPuntos();
                    jmax = j;
                //System.out.println("jmax: "+ jmax);
                }
                else {
                    min = participantesAux.get(j).getPuntos();
                  jmin = j;
                  //System.out.println("jmin: "+ jmin);
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

}
