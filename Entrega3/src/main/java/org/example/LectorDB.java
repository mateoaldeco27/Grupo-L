//package org.example;

import java.sql.*;
import java.util.ArrayList;

/*public class LectorDB
{
    LectorDB()
    {
        System.out.println("ESTAMOS LEYENDO DE LA BASE DE DATOS");
        String url = "jdbc:mysql://sql10.freemysqlhosting.net:3306/sql10614022";
        String user = "sql10614022";
        String password = "W3YI6xDvYY";

        StringBuilder resultadoString = new StringBuilder();;
        StringBuilder pronosticoString = new StringBuilder();

        try {
            // Establecer conexión con la base de datos
            Connection connection = DriverManager.getConnection(url, user, password);

            Statement stmtResultado = connection.createStatement();
            ResultSet rsResultado = stmtResultado.executeQuery("SELECT * FROM Resultados");
            while (rsResultado.next()) {
                resultadoString.append(rsResultado.getString("Ronda-id")).append(";")
                        .append(rsResultado.getString("Partido-nro")).append(";")
                        .append(rsResultado.getString("id-Equipo 1")).append(";")
                        .append(rsResultado.getString("Equipo 1")).append(";")
                        .append(rsResultado.getString("descripción-Equipo 1")).append(";")
                        .append(rsResultado.getString("Cant. goles 1")).append(";")
                        .append(rsResultado.getString("Cant. goles 2")).append(";")
                        .append(rsResultado.getString("Equipo 2")).append(";")
                        .append(rsResultado.getString("id-Equipo 2")).append(";")
                        .append(rsResultado.getString("descripción-Equipo 2")).append("\n");
            }


            Statement stmtPronostico = connection.createStatement();
            ResultSet rsPronostico = stmtPronostico.executeQuery("SELECT * FROM Pronostico");
            while (rsPronostico.next())
            {
                pronosticoString.append(rsPronostico.getString("idParticipante")).append(";")
                        .append(rsPronostico.getString("nombreParticipante")).append(";")
                        .append(rsPronostico.getString("id-Equipo 1")).append(";")
                        .append(rsPronostico.getString("Gana 1")).append(";")
                        .append(rsPronostico.getString("Empata")).append(";")
                        .append(rsPronostico.getString("Gana 2")).append(";")
                        .append(rsPronostico.getString("id-Equipo 2")).append("\n");
            }

            connection.close();
        }  catch (SQLException e) {System.out.println(e);}


            String[] resultadoDatosFila = resultadoString.toString().split("\n");
            String[] pronosticoDatosFila = pronosticoString.toString().split("\n");


            ArrayList<Partido> partidos = new ArrayList<>();

            ArrayList<Participante> participantes = new ArrayList<>();

            ArrayList<Ronda> rondas = new ArrayList<>();
            ArrayList<Fase> fases = new ArrayList<>();

            // agrego id
            int id = 0;
            int indicePartido;
            int resultadoRondaFinal = 0;
            int resultadoFaseFinal = 0;

            // ronda predeterminada
            Ronda nuevaRonda = new Ronda();
            rondas.add(nuevaRonda);
            // fase predetermindada
            Fase nuevaFase = new Fase();
            fases.add(nuevaFase);

            // Extracción de datos del .csv y armado de objetos Equipo y Partido
            for (int i = 1; i < pronosticoDatosFila.length; i++) {

                String[] pronosticoColumna_Fila = pronosticoDatosFila[i].split(";");


                // creo participantes con if
                if (id != Integer.parseInt(pronosticoColumna_Fila[0])) {
                    Participante nuevoParticipante = new Participante(Integer.parseInt(pronosticoColumna_Fila[0]), pronosticoColumna_Fila[1]);
                    participantes.add(nuevoParticipante);
                    id++;
                }

                //
                indicePartido = i;
                while (indicePartido > resultadoDatosFila.length - 1) {
                    indicePartido = indicePartido - (resultadoDatosFila.length-1);
                }

                System.out.println("indicePartido -> " + indicePartido + " i -> " + i); // ELIMINAR

                // Extracción de datos de la fila de resultados.csv
                String[] resultadoColumna_Fila = resultadoDatosFila[indicePartido].split(";");


                // Armado de objetos equipo1, equipo2 y nuevoPartido, con base a las posiciones de las columnas de resultados.csv
                Equipo equipo1 = new Equipo(Integer.parseInt(resultadoColumna_Fila[2]), resultadoColumna_Fila[3], resultadoColumna_Fila[4]);
                Equipo equipo2 = new Equipo(Integer.parseInt(resultadoColumna_Fila[8]), resultadoColumna_Fila[7], resultadoColumna_Fila[9]);
                Partido nuevoPartido = new Partido(equipo1, Integer.parseInt(resultadoColumna_Fila[5]), Integer.parseInt(resultadoColumna_Fila[6]), equipo2);

                if (partidos.size() < resultadoDatosFila.length - 1 ) {
                    partidos.add(nuevoPartido);
                }


                // Extracción de datos de la fila, armado del objeto pronostico, y seteo de expectativa; con base al archivo pronostico.csv
                Pronostico nuevoPronostico = new Pronostico(nuevoPartido, equipo1, equipo2);

                nuevoPronostico.setParticipante(participantes.get(id -1));

                mostramePorConsola(nuevoPartido, indicePartido, participantes, id, nuevoPronostico, pronosticoColumna_Fila);
                ronda(indicePartido, id, resultadoRondaFinal, nuevoPartido, rondas, resultadoColumna_Fila, participantes);
                fase(indicePartido, id, resultadoFaseFinal, nuevaRonda, fases, resultadoColumna_Fila, participantes);
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
                + participantes.get(idParticipantes -1).getPuntos() + " punto/s.\n");

        System.out.println("000000000000000000000000");

    }

        public static void listaGanadores(ArrayList<Participante> participantes) {

        ArrayList<Participante> participantesAux = (ArrayList<Participante>) participantes.clone();

        System.out.println("\n-------------------------\n\t   ¡GANADORES!\n");

        int max = participantesAux.get(0).getPuntosFinalesFase();
        int min = participantesAux.get(0).getPuntosFinalesFase();

        int jmax = 0;
        int jmin = 0;

        System.out.println("↓↓↓↓↓ MAYOR PUNTAJE ↓↓↓↓↓");
        System.out.println("-------------------------");

        for (int i = 0; i < participantesAux.size(); i++) {

            for (int j = 0; j < participantesAux.size(); j++) {

                if (participantesAux.get(j).getPuntosFinalesFase() >= max) {
                    max = participantesAux.get(j).getPuntosFinalesFase();
                    jmax = j;

                } else {
                    min = participantesAux.get(j).getPuntosFinalesFase();
                    jmin = j;
                }
            }
            System.out.println(participantesAux.get(jmax).getNombre() + "\t|\t" + max + "\tPUNTO/S" + "\n-------------------------");
            participantesAux.remove(jmax);
            max = participantesAux.get(0).getPuntosFinalesFase();
            min = participantesAux.get(0).getPuntosFinalesFase();
            i = 0;
        }
        System.out.println(participantesAux.get(0).getNombre() + "\t|\t" + min + "\tPUNTO/S\n-------------------------");
        System.out.println("↑↑↑↑↑ MENOR PUNTAJE ↑↑↑↑↑");
    }

        public static void ronda(int i,int idParticipantes, int resultadoRondaFinal, Partido nuevoPartido,ArrayList<Ronda> rondas, String[] resultadoColumna_Fila, ArrayList<Participante> participantes) {

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
            nuevaRonda.setResultadoRondaParcial(participantes.get(idParticipantes -1).getPuntos());
            System.out.println("EL RESULTADO DE ESTA RONDA ES: "+ nuevaRonda.getResultadoRondaParcial());


            nuevaRonda.sumaResultadoRondaFinalParticipante(participantes, idParticipantes,resultadoRondaFinal);

            participantes.get(idParticipantes-1 ).setPuntos(0);

            System.out.println("EL RESULTADO FINAL DE LAS RONDAS ES: "+participantes.get(idParticipantes -1).getPuntosFinalesFase());

        }
        else {
            if (Integer.parseInt(resultadoColumna_Fila[2]) <= rondas.get(0).getPartidosxronda())
            {
                rondas.get(rondas.size()-1).agregarPartido(nuevoPartido);
                System.out.println("agregamos otro partido: " + nuevoPartido.mostrameDatosPartido(i));
            }
        }

    }

    public static void fase(int i, int idParticipantes, int resultadoFaseFinal, Ronda nuevaRonda, ArrayList<Fase> fases, String[] resultadoColumna_Fila, ArrayList<Participante> participantes) {

        // divido el iterador por la cantidad de rondas por fase(2)
        int resto = i % fases.get(0).getRondasxfase();
        if (resto == 0) {
            //agrega la ronda a la fase
            fases.get(fases.size()-1).agregarRonda(nuevaRonda);
            //cada 2 rondas crea una nueva fase y la añade a la arraylist fases
            System.out.println("------ acá hay una nueva fase --------");
            Fase nuevaFase = new Fase();
            fases.add(nuevaFase);
            nuevaFase.setResultadoFaseParcial(participantes.get(idParticipantes -1).getPuntos());
            System.out.println("EL RESULTADO DE ESTA FASE ES: " + nuevaFase.getResultadoFaseParcial());


            nuevaFase.sumaResultadoFaseFinalParticipante(participantes, idParticipantes, resultadoFaseFinal);

            participantes.get(idParticipantes-1 ).setPuntos(0);

            System.out.println("EL RESULTADO FINAL DE LAS FASES ES: "+participantes.get(idParticipantes -1).getPuntosFinales());

        }
        else {
            if (Integer.parseInt(resultadoColumna_Fila[1]) <= fases.get(0).getRondasxfase())
            {
                fases.get(fases.size()-1).agregarRonda(nuevaRonda);
            }
        }

    }


}*/
