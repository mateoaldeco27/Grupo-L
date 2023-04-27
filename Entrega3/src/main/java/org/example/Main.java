package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //Pedimos un imput del usuario
        Scanner scn = new Scanner(System.in);
        try {
            System.out.println("Escriba db o csv");
            String eleccion = scn.nextLine();

            CSVoDB(eleccion);

            scn.close();
        }
        catch (InputMismatchException e) {
            e.toString();
        }
    }

    public static void CSVoDB(String eleccion)
    {
        String[] resultadoDatosFila;
        String[] pronosticoDatosFila;

        eleccion = eleccion.toUpperCase();
        if (eleccion.equals("CSV") )
        {
            LectorCSV lectorCSV = new LectorCSV();

            resultadoDatosFila = lectorCSV.getResultadoDatosFila();
            pronosticoDatosFila = lectorCSV.getPronosticoDatosFila();

            LectorManager lectorManager = new LectorManager(resultadoDatosFila, pronosticoDatosFila);

            lectorManager.programa();
        }
        else if(eleccion.equals("DB"))
        {
            LectorDB lectorDB = new LectorDB();

            resultadoDatosFila = lectorDB.getResultadoDatosFila();
            pronosticoDatosFila = lectorDB.getPronosticoDatosFila();

            LectorManager lectorManager = new LectorManager(resultadoDatosFila, pronosticoDatosFila);

            lectorManager.programa();
        }
        else{
            System.out.println("La entrada es incorrecta. Por favor, escriba CSV o DB");
        }
    }
}