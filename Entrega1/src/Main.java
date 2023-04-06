import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {

        //extraer los datos del archivo resultados.csv
        //Path resultado = Paths.get("Entrega1/src/resultados.csv");
        Path resultado = Paths.get("./resultados.txt");
        String resultadoString = Files.readString(resultado);
        String[] resultadoDatos = resultadoString.split("\n");

        //extraer los datos del archivo pronostico.csv
        //Path pronostico = Paths.get("Entrega1/src/pronostico.csv");
        Path pronostico = Paths.get("./pronostico.txt");
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
        int j = 0;

        int puntos1 = 0;
        //for (int i = 1; i < 11; i++) {
        for (int i = 1; i < pronosticoDatos.length; i++) {

            String[] infoPronostico = pronosticoDatos[i].split(";");

            //creo participantes con if
            if (id != Integer.parseInt(infoPronostico[0])){
                Participante nuevoParticipante = new Participante(Integer.parseInt(infoPronostico[0]), infoPronostico[1], RESULTADO.ganador);
                participantes.add(nuevoParticipante);
                id++;

            }

            //System.out.println("Id del participante i("+i+"): " + participantes.get(i).getId());

            //System.out.println("partidos.size() before if -> "+ partidos.size());

            j = i;
            if (i >= 6) {
                j = i - (6-1);
                if (j >= 6) {
                    j = 1;
                }

            }

            if (i == 6) {
                puntos1 = 0;
                System.out.println("puntos1 = 0 -> "+ puntos1);
            }

            //System.out.println("partidos.size() next if -> "+ partidos.size());

            //for (int j = 1; j < resultadoDatos.length; j++) {
            //Extracción de datos de la fila de resultados.csv
            System.out.println("j -> "+ j +" i -> "+ i);
            String[] infoPartido = resultadoDatos[j].split(";");

            //Armado de objetos equipo1, equipo2 y nuevoPartido, con base a las posiciones de las columnas de resultados.csv
            Equipo equipo1 = new Equipo(Integer.parseInt(infoPartido[0]), infoPartido[1], infoPartido[2]);
            Equipo equipo2 = new Equipo(Integer.parseInt(infoPartido[6]), infoPartido[5], infoPartido[7]);
            Partido nuevoPartido = new Partido(equipo1, Integer.parseInt(infoPartido[3]), Integer.parseInt(infoPartido[4]), equipo2);


            //new
            if (!partidos.contains(nuevoPartido)) {

                partidos.add(nuevoPartido);

            }


            //new modified
            System.out.println(nuevoPartido.mostrameDatosPartido(j));

            String[] infoPronostico2 = pronosticoDatos[i].split(";");

            //Extracción de datos de la fila, armado del objeto pronostico, y seteo de expectativa; con base al archivo pronostico.csv
            Pronostico nuevoPronostico = new Pronostico(nuevoPartido, equipo1, equipo2);
            //new modified

            for (String lista_infoPronostico2 : infoPronostico2) {
                System.out.println(lista_infoPronostico2);
            }

            //
            nuevoPronostico.ComprobarDatos(infoPronostico2);

            // j -> indicePartido
            nuevoPartido.GanadorPartido(j);

            nuevoPronostico.AcertoElPronostico();


            System.out.println("La cantidad de participantes de momento son: " + participantes.size() +" y son:");
            for (Participante listaParticipantes : participantes) {
                System.out.println(listaParticipantes.getNombre() +" ["+ (id-1) +"]");
            }
            System.out.println("i -> "+ i);
            System.out.println("-------------\nEn este Partido "+ participantes.get(id-1).getNombre() +" obtuvo: " + nuevoPronostico.puntos + " punto/s.\n");

            /*/
            puntos1 = puntos1 + nuevoPronostico.puntos;
            /*/

            System.out.println("id -> "+ id);
            if (puntos.size() < participantes.size()) {
                System.out.println("puntos.add(nuevoPronostico.puntos)");
                puntos.add(0);
            }

            System.out.println("\npuntos.size() -> "+ puntos.size() +"\n");

            /*
            for (int k = 0; k < puntos.size(); k++) {
                System.out.println("puntos.get("+ k +")"+ puntos.get(k));
            }/*/

            //modificar valor del carrito puntos

            //if (id == 2) { puntos.set(1, 0); }
            System.out.println("puntos.get("+ (id-1) +") -> "+ puntos.get(id-1));

            puntos1 = puntos.get(id-1) + nuevoPronostico.puntos;
            System.out.println("puntos1 -> "+ puntos1);

            System.out.println("id-1 -> "+ (id-1));
            System.out.println("puntos.get(id-1) -> "+ puntos.get(id-1));
            System.out.println("nuevoPronostico.puntos -> "+ nuevoPronostico.puntos);
            //System.out.println("puntos.set((id-1), 1024 -> "+ puntos.set((id-1), (1024)));
            System.out.println("puntos.set((id-1), (puntos.get(id-1) + nuevoPronostico.puntos)) -> "+ puntos.set((id-1), (puntos.get(id-1) + nuevoPronostico.puntos)));
            System.out.println("puntos.set((id-1), (nuevoPronostico.puntos)) -> "+ puntos.set((id-1), nuevoPronostico.puntos));
            puntos.set((id-1), puntos1);

            for (int k = 0; k < puntos.size(); k++) {
                System.out.println("puntos.get("+ k +")"+ puntos.get(k));
            }



                    /*
                    for (i = 0; i < puntos.size(); i++) {
                        System.out.println("Nuevo valor - puntos.get("+ i +") -> "+ puntos.get(i));
                    }

                    //puntos.get(0).replace(puntos.get(0) + nuevoPronostico.puntos);
                    //*/

            //}
            //}

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

                for (int j = 1; j < resultadoDatos.length; j++) {
                    //Extracción de datos de la fila de resultados.csv
                    String[] infoPartido = resultadoDatos[j].split(";");

                    //Armado de objetos equipo1, equipo2 y nuevoPartido, con base a las posiciones de las columnas de resultados.csv
                    Equipo equipo1 = new Equipo(Integer.parseInt(infoPartido[0]), infoPartido[1], infoPartido[2]);
                    Equipo equipo2 = new Equipo(Integer.parseInt(infoPartido[6]), infoPartido[5], infoPartido[7]);
                    Partido nuevoPartido = new Partido(equipo1, Integer.parseInt(infoPartido[3]), Integer.parseInt(infoPartido[4]), equipo2);


                    //new
                    if (!partidos.contains(nuevoPartido)) {

                        partidos.add(nuevoPartido);

                    }


                    //new modified
                    System.out.println(nuevoPartido.mostrameDatosPartido(j));

                    String[] infoPronostico2 = pronosticoDatos[j].split(";");

                    //Extracción de datos de la fila, armado del objeto pronostico, y seteo de expectativa; con base al archivo pronostico.csv
                    Pronostico nuevoPronostico = new Pronostico(nuevoPartido, equipo1, equipo2);
                    //new modified

                    for (String lista_infoPronostico2 : infoPronostico2) {
                        System.out.println(lista_infoPronostico2);
                    }

                    //
                    nuevoPronostico.ComprobarDatos(infoPronostico2);

                    // j -> indicePartido
                    nuevoPartido.GanadorPartido(j);

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

        System.out.println("\nCantidad de partidos son: "+ partidos.size() +" y son:");
        for (int i = 0; i < partidos.size(); i++) {
            System.out.println("Partido "+ (i+1) +" -> Equipo 1: "+ partidos.get(i).Equipo1.GetNombre() +" | Equipo 2: "+ partidos.get(i).Equipo2.GetNombre() +".\n"
                    +"goles 1: "+ partidos.get(i).getGoles1() +" | goles 2: "+ partidos.get(i).getGoles2());
        }
*/
        System.out.println("La cantidad de participantes son: " + participantes.size() +" y son:");
        for (Participante listaParticipantes : participantes) {
            System.out.println(listaParticipantes.getNombre());

        }


    }

}

