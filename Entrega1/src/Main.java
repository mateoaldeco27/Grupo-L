import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {

        //extraer los datos del archivo resultados.csv
        Path resultado = Paths.get("Entrega1/src/resultados.csv");
        //Path resultado = Paths.get("./resultados.txt");
        String resultadoString = Files.readString(resultado);
        String[] resultadoDatos = resultadoString.split("\n");

        //extraer los datos del archivo pronostico.csv
        Path pronostico = Paths.get("Entrega1/src/pronostico.csv");
       //Path pronostico = Paths.get("./pronostico.txt");
        String pronosticoString = Files.readString(pronostico);
        String[] pronosticoDatos = pronosticoString.split("\n");


        //new
        ArrayList<Partido> partidos = new ArrayList<>();

        //new
        ArrayList<Participante> participantes = new ArrayList<>();


        //Extracción de datos del .csv y armado de objetos Equipo y Partido
        ArrayList<Integer> puntos = new ArrayList<>();
        //agrego id
        int id = 0;
        int indicePartido = 0;

        int puntosTotales = 0;
        //for (int i = 1; i < 11; i++) {
        for (int i = 1; i < pronosticoDatos.length; i++) {

            String[] infoPronostico = pronosticoDatos[i].split(";");

            //creo participantes con if
            if (id != Integer.parseInt(infoPronostico[0])){
                Participante nuevoParticipante = new Participante(Integer.parseInt(infoPronostico[0]), infoPronostico[1], RESULTADO.ganador);
                participantes.add(nuevoParticipante);
                id++;

            }

            indicePartido = i;

            while( indicePartido > 5){
                indicePartido = indicePartido - (resultadoDatos.length - 1);
            }

            //Extracción de datos de la fila de resultados.csv
            System.out.println("indicePartido -> "+ indicePartido +" i -> "+ i);
            String[] infoPartido = resultadoDatos[indicePartido].split(";");

            //Armado de objetos equipo1, equipo2 y nuevoPartido, con base a las posiciones de las columnas de resultados.csv
            Equipo equipo1 = new Equipo(Integer.parseInt(infoPartido[0]), infoPartido[1], infoPartido[2]);
            Equipo equipo2 = new Equipo(Integer.parseInt(infoPartido[6]), infoPartido[5], infoPartido[7]);
            Partido nuevoPartido = new Partido(equipo1, Integer.parseInt(infoPartido[3]), Integer.parseInt(infoPartido[4]), equipo2);

            if (partidos.size() < resultadoDatos.length-1) {
                partidos.add(nuevoPartido);
            }

            //Muestra num de partido e informacion
            System.out.println(nuevoPartido.mostrameDatosPartido(indicePartido));

            String[] infoPronostico2 = pronosticoDatos[i].split(";");

            //Extracción de datos de la fila, armado del objeto pronostico, y seteo de expectativa; con base al archivo pronostico.csv
            Pronostico nuevoPronostico = new Pronostico(nuevoPartido, equipo1, equipo2);

            for (String lista_infoPronostico2 : infoPronostico2) {
                System.out.println(lista_infoPronostico2);
            }

            //(nombre) espera que...
            nuevoPronostico.ComprobarDatos(infoPronostico2,participantes, id);

            // indicePartido -> indicePartido
            nuevoPartido.GanadorPartido(indicePartido);

            //Salida personalizada por cada participante
            nuevoPronostico.AcertoElPronostico(participantes, id);

            System.out.println("indice de partido pronostico -> "+ i);

            System.out.println("-------------\nEn este Partido "+ participantes.get(id-1).getNombre() +" obtuvo: " + nuevoPronostico.puntos + " punto/s.\n");

            System.out.println("id -> "+ id);

            //Todos los objetos puntos comienzan con 0 para guardar correctamente el dato
            if (puntos.size() < participantes.size()) {
                puntos.add(0);
            }

            //modificar valor de la coleccion puntos

            System.out.println("puntos.get("+ (id-1) +") -> "+ puntos.get(id-1));

            puntosTotales = puntos.get(id-1) + nuevoPronostico.puntos;
            System.out.println("puntosTotales -> "+ puntosTotales);

            System.out.println("nuevoPronostico.puntos -> "+ nuevoPronostico.puntos);
            puntos.set((id-1), puntosTotales);

            for (int k = 0; k < puntos.size(); k++) {
                System.out.println("puntos.get("+ k +") | " + participantes.get(k).getNombre() + " --> " + puntos.get(k) + " puntos");
            }

        }

        /*
        for (int i = 1; i < pronosticoDatos.length; i++) {

            String[] infoPronostico = pronosticoDatos[i].split(";");

            //creo participantes con if
            if (id != Integer.parseInt(infoPronostico[0])){
                Participante nuevoParticipante = new Participante(Integer.parseInt(infoPronostico[0]), infoPronostico[1], RESULTADO.ganador);
                participantes.add(nuevoParticipante);
                id++;
            }

            //System.out.println("Id del participante i("+i+"): " + participantes.get(i).getId());

            System.out.println("partidos.size() before if -> "+ partidos.size());

            if (partidos.size() < 6)
            {

                System.out.println("partidos.size() next if -> "+ partidos.size());

                for (int indicePartido = 1; indicePartido < resultadoDatos.length; indicePartido++) {
                    //Extracción de datos de la fila de resultados.csv
                    String[] infoPartido = resultadoDatos[indicePartido].split(";");

                    //Armado de objetos equipo1, equipo2 y nuevoPartido, con base a las posiciones de las columnas de resultados.csv
                    Equipo equipo1 = new Equipo(Integer.parseInt(infoPartido[0]), infoPartido[1], infoPartido[2]);
                    Equipo equipo2 = new Equipo(Integer.parseInt(infoPartido[6]), infoPartido[5], infoPartido[7]);
                    Partido nuevoPartido = new Partido(equipo1, Integer.parseInt(infoPartido[3]), Integer.parseInt(infoPartido[4]), equipo2);


                    //new
                    if (!partidos.contains(nuevoPartido)) {

                        partidos.add(nuevoPartido);

                    }


                    //new modified
                    System.out.println(nuevoPartido.mostrameDatosPartido(indicePartido));

                    String[] infoPronostico2 = pronosticoDatos[indicePartido].split(";");

                    //Extracción de datos de la fila, armado del objeto pronostico, y seteo de expectativa; con base al archivo pronostico.csv
                    Pronostico nuevoPronostico = new Pronostico(nuevoPartido, equipo1, equipo2);
                    //new modified

                    for (String lista_infoPronostico2 : infoPronostico2) {
                        System.out.println(lista_infoPronostico2);
                    }

                    //
                    nuevoPronostico.ComprobarDatos(infoPronostico2);

                    // indicePartido -> indicePartido
                    nuevoPartido.GanadorPartido(indicePartido);

                    nuevoPronostico.AcertoElPronostico();


                    System.out.println("La cantidad de participantes de momento son: " + participantes.size() +" y son:");
                    for (Participante listaParticipantes : participantes) {
                        System.out.println(listaParticipantes.getNombre() +" ["+ (i-1) +"]");
                    }
                    System.out.println("i -> "+ i);
                    System.out.println("-------------\nEn este Partido "+ participantes.get(i-1).getNombre() +" obtuvo: " + nuevoPronostico.puntos + " punto/s.\n");
                    puntos = puntos + nuevoPronostico.puntos;

                     /*
                }
            }

        }
        */

        /*
        System.out.println("-------------------------------------\nLos puntos totales de Mariana son: " + puntos +"\n-------------------------------------\n");
           */
        System.out.println("\nCantidad de partidos son: "+ partidos.size() +" y son:");
        for (int i = 0; i < partidos.size(); i++) {
            System.out.println("Partido "+ (i+1) +" -> Equipo 1: "+ partidos.get(i).Equipo1.GetNombre() +" | Equipo 2: "+ partidos.get(i).Equipo2.GetNombre() +".\n"
                    +"goles 1: "+ partidos.get(i).getGoles1() +" | goles 2: "+ partidos.get(i).getGoles2());
        }

        System.out.println("La cantidad de participantes son: " + participantes.size() +" y son:");
        for (Participante listaParticipantes : participantes) {
            System.out.println(listaParticipantes.getNombre());
        }
    }

}

