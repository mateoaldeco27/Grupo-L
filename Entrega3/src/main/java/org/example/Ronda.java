package org.example;

import java.util.ArrayList;

public class Ronda {
    public Ronda() {}

    ArrayList<Partido> partidos = new ArrayList<>();

    private int resultadoRondaParcial;
    private int resultadoRondaFinal;
    private int partidosxronda = 3;
    private int puntoExtraXronda = 1;
    Pronostico pronostico = new Pronostico();



    public int getPuntoExtraXronda() {return puntoExtraXronda;}

    public int getPartidosxronda() {
        return partidosxronda;
    }

    public void agregarPartido(Partido partido)
    {
        partidos.add(partido);
    }

    public void setResultadoRondaParcial(int resultadoRondaParcial) {this.resultadoRondaParcial = resultadoRondaParcial;}
    public int getResultadoRondaParcial() {
        return resultadoRondaParcial;
    }

    public void sumaResultadoRondaFinalParticipante(ArrayList<Participante> participantes, int idParticipantes, int resultadoRondaFinal)
    {
        resultadoRondaFinal = resultadoRondaFinal + resultadoRondaParcial;

        participantes.get(idParticipantes - 1).setPuntosFinalesRonda(resultadoRondaFinal,partidosxronda,puntoExtraXronda,pronostico.puntoPronosticoAcertado);

    }

}
