package org.example;

import java.sql.*;

public class LectorDB
{

    private String[] resultadoDatosFila;
    private String[] pronosticoDatosFila;


    LectorDB()
    {
        System.out.println("ESTAMOS LEYENDO DE LA BASE DE DATOS");
        String url = "jdbc:mysql://sql10.freemysqlhosting.net:3306/sql10614022";
        String user = "sql10614022";
        String password = "W3YI6xDvYY";

        StringBuilder resultadoString = new StringBuilder();
        StringBuilder pronosticoString = new StringBuilder();

        try {
            // Establecer conexión con la base de datos
            Connection connection = DriverManager.getConnection(url, user, password);

            Statement stmtResultado = connection.createStatement();
            ResultSet rsResultado = stmtResultado.executeQuery("SELECT * FROM Resultados");
            while (rsResultado.next()) {
                resultadoString.append(rsResultado.getString("Fase-id")).append(";")
                        .append(rsResultado.getString("Ronda-id")).append(";")
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


        resultadoDatosFila = resultadoString.toString().split("\n");
        pronosticoDatosFila = pronosticoString.toString().split("\n");

    }

    public String[] getResultadoDatosFila() {
        return resultadoDatosFila;
    }

    public String[] getPronosticoDatosFila() {
        return pronosticoDatosFila;
    }

}

