package org.example;

public class Participante {

    public Participante (int identification, String name)
    {
        id = identification;
        nombre = name;
        
    }

    private int id;
    private String nombre;
    //private RESULTADO expectativa;

    private int puntos;
    //private int puntosTotales;
    public void sumarPunto () {
      puntos++;
    }

    

    //int puntosTotales = 0;
  
    //puntosTotales = 1;

    /*public int getPuntosTotales() {
      return puntosTotales;
    }*/



  public int getPuntos() {
    return puntos;
  }


  
  
  
    public String getNombre() {
        return nombre;
    }


  /*
  public RESULTADO getExpectativa() {
        return expectativa;
    }
*/

    public int getId() {
        return id;
    }


}
