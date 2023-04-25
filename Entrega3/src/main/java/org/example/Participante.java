package org.example;

import java.util.ArrayList;

public class Participante {

    public Participante (int identification, String name)
    {
        id = identification;
        nombre = name;
    }

    private int id;
    private String nombre;
    private int puntos;
    private int puntosFinales;

    public void sumarPunto () {
      puntos++;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public int getPuntos() {
    return puntos;
  }

    public String getNombre() {
        return nombre;
    }

    public int getPuntosFinales() {
        return puntosFinales;
    }

    public void setPuntosFinales(int resultadoRondaFinal, int partidosxRonda) {
        if (partidosxRonda * 1 == resultadoRondaFinal) {
            puntosFinales += resultadoRondaFinal + 1;
        }
        else {
            puntosFinales += resultadoRondaFinal;
        }
    }

}
