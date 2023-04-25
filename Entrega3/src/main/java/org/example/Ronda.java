package org.example;

import java.util.ArrayList;

public class Ronda {

    public Ronda()
    {
        //this.partido = partido;
        //partidos.add(partido);

    }

    ArrayList<Partido> partidos = new ArrayList<>();

    private int numero;
    private int resultadoRondaParcial;
    private int resultadoRondaFinal;
    private int partidosxronda = 3;


    public int getPartidosxronda() {
        return partidosxronda;
    }
    public void siguienteRonda() {
        this.numero++;
    }

    public int getNumero(){return numero;}
    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void agregarPartido(Partido partido)
    {
        partidos.add(partido);
    }
    public void setResultadoRondaParcial(int resultadoRondaParcial) {
        this.resultadoRondaParcial = resultadoRondaParcial;
    }

    public int getResultadoRondaParcial() {
        return resultadoRondaParcial;
    }

    public int getResultadoRondaFinal() {
        return resultadoRondaFinal;
    }


    public void sumaResultadoRondaFinalParticipante(ArrayList<Participante> participantes, int idParticipantes, int resultadoRondaFinal)
    {
        // resultadoRondaFinal += resultadoRondaParcial;
        // participantes.get(idParticipantes-1).setPuntosFinalesRondas(resultadoRondaFinal);
        resultadoRondaFinal = resultadoRondaFinal + resultadoRondaParcial;
        //System.out.println("EL RESULTADO FINAL ES: " + resultadoRondaFinal);

        participantes.get(idParticipantes - 1).setPuntosFinales(resultadoRondaFinal,partidosxronda);

    }

}
