package org.example;


public class Participante {

    public Participante (int identification, String name)
    {
        id = identification;
        nombre = name;
    }

    private int id;
    private String nombre;
    private int puntos;
    private int puntosFinalesRonda;

    private int puntosFinalesFase;

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

    public int getPuntosFinalesRonda() {
        return puntosFinalesRonda;
    }

    public int getPuntosFinalesFase() {
        return puntosFinalesFase;
    }


    public void resetPuntosFinalesRonda() {
        puntosFinalesRonda = 0;
    }


    public void setPuntosFinalesRonda(int resultadoRondaFinal, int partidosxRonda) {
        if (partidosxRonda * 1 == resultadoRondaFinal) {
            puntosFinalesRonda += resultadoRondaFinal + 1;
        }
        else {
            puntosFinalesRonda += resultadoRondaFinal;
        }
    }

    public void setPuntosFinalesFase(int resultadoFaseFinal, int partidoxfase, int cantRondasFase, int resultadoFaseParcial) {
        if ((cantRondasFase*4) == resultadoFaseParcial) {
            puntosFinalesFase =++ resultadoFaseFinal ;
        }
        else {
            puntosFinalesFase = resultadoFaseFinal;
        }
    }

}
