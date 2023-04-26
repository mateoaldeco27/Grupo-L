package org.example;

import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        
        CSVoDB("csv");


    }
    public static void CSVoDB(String eleccion)
    {
        eleccion = eleccion.toUpperCase();
        if (eleccion.equals("CSV") )
        {
            LectorCSV lectorcsv = new LectorCSV();
        }
        else if(eleccion.equals("DB"))
        {
            //LectorDB lectorDB = new LectorDB();
        }
        else{
            System.out.println("La entrada es incorrecta. Por favor, escriba CSV o DB");
        }

    }

}