package org.example;

import java.util.ArrayList;

public class Fase {
    Fase() {}

    ArrayList<Ronda> rondas = new ArrayList<>();
    private int resultadoFaseParcial;
    private int resultadoFaseFinal;
    private int puntoExtraFaseAcertada = 1;
    private int cantRondasFase = 2;

    //instanciamos un objeto pronostico y un objeto fase para poder acceder a sus atributos
    Pronostico pronostico = new Pronostico();
    Ronda ronda = new Ronda();

    private int partidoxfase = (cantRondasFase * ronda.getPartidosxronda());


    public int getPuntoExtraFaseAcertada() {
        return puntoExtraFaseAcertada;
    }
    public int getPartidoxfase() {return partidoxfase;}

    public void agregarRonda(Ronda ronda) {
        rondas.add(ronda);
    }

    public void setResultadoFaseParcial(int resultadoFaseParcial) {
        this.resultadoFaseParcial = resultadoFaseParcial;
    }

   public int getResultadoFaseParcial() {return resultadoFaseParcial;}

    public void sumaResultadoFaseFinalParticipante(ArrayList<Participante> participantes, int idParticipantes, int resultadoFaseFinal) {

        resultadoFaseFinal = resultadoFaseFinal + resultadoFaseParcial;

        participantes.get(idParticipantes - 1).setPuntosFinalesFase(resultadoFaseFinal, partidoxfase, cantRondasFase, resultadoFaseParcial, ronda.getPartidosxronda(),ronda.getPuntoExtraXronda(), pronostico.puntoPronosticoAcertado);
    }
}
