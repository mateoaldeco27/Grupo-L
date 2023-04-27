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

    //instanciamos un objeto pronostico y un objeto fase para poder acceder a sus atributos
    Pronostico pronostico = new Pronostico();
    Fase fase = new Fase();

    public void sumarPunto () {
      puntos += pronostico.puntoPronosticoAcertado ;
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


    public void setPuntosFinalesRonda(int resultadoRondaFinal, int partidosxRonda, int puntoExtraXronda, int puntoPronosticoAcertado) {
        if (partidosxRonda * puntoPronosticoAcertado == resultadoRondaFinal) {
            puntosFinalesRonda += resultadoRondaFinal + puntoExtraXronda;
        }
        else {
            puntosFinalesRonda += resultadoRondaFinal;
        }
    }

    public void setPuntosFinalesFase(int resultadoFaseFinal, int partidoxfase, int cantRondasFase, int resultadoFaseParcial, int partidosxRonda, int puntoExtraXronda, int puntoPronosticoAcertado) {
        if ((cantRondasFase*((partidosxRonda*puntoPronosticoAcertado)+puntoExtraXronda) == resultadoFaseParcial) ){
            puntosFinalesFase = resultadoFaseFinal + fase.getPuntoExtraFaseAcertada()  ;
        }
        else {
            puntosFinalesFase = resultadoFaseFinal;
        }
    }

}
