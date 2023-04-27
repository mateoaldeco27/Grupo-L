package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class LectorCSV
{
    private String[] resultadoDatosFila;
    private String[] pronosticoDatosFila;


    LectorCSV()
    {

        System.out.println("ESTAMOS LEYENDO DE LOS ARCHIVOS .CSV");

        Path resultado = Paths.get("Entrega3/src/main/java/org/example/resultados.csv");

        Path pronostico = Paths.get("Entrega3/src/main/java/org/example/pronostico.csv");

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

         resultadoDatosFila = resultadoString.split("\n");
         pronosticoDatosFila = pronosticoString.split("\n");

    }

    public String[] getResultadoDatosFila() {
        return resultadoDatosFila;
    }

    public String[] getPronosticoDatosFila() {
        return pronosticoDatosFila;
    }
}

