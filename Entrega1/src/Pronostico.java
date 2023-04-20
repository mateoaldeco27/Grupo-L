//import java.io.IOException;
import java.util.ArrayList;

public class Pronostico {
    public Pronostico(Partido partido, Equipo equipo1, Equipo equipo2)
    {
        this.partido = partido;
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;

    }

    private Partido partido;
    private Equipo equipo1;
    private Equipo equipo2;


     private Participante participante;

     public void setParticipante (Participante participante) {
       this.participante = participante;
     }

     public void AcertoElPronostico(ArrayList <Participante> participantes, int id)
     {
        if (equipo1.getResultado() == equipo1.getExpectativa())
        {
            System.out.println(participantes.get(id-1).getNombre() + " acertó el pronóstico");
          System.out.println("-------------\nEn este Partido " + participantes.get(id - 1).getNombre()
        + " obtuvo: 1 punto.");
          participante.sumarPunto();
        }
        else
        {
            System.out.println(participantes.get(id-1).getNombre() + " no acertó el pronóstico");

            System.out.println("-------------\nEn este Partido " + participantes.get(id - 1).getNombre()
        + " obtuvo: 0 puntos.");
          
        }
    }

    public void ComprobarDatos(String[] infoPronostico, ArrayList <Participante> participantes, int id)
    {
        if(infoPronostico[3].equals("X"))
        {
            equipo1.setExpectativa(RESULTADO.ganador);
            equipo2.setExpectativa(RESULTADO.perdedor);
            System.out.println(participantes.get(id-1).getNombre() + " espera que gane el equipo 1");
        }
        else if (infoPronostico[4].equals("X"))
        {
            equipo1.setExpectativa(RESULTADO.empate);
            equipo2.setExpectativa(RESULTADO.empate);
            System.out.println(participantes.get(id-1).getNombre() + " espera que empaten");
        }
        else
        {
            equipo1.setExpectativa(RESULTADO.perdedor);
            equipo2.setExpectativa(RESULTADO.ganador);
            System.out.println(participantes.get(id-1).getNombre() + " espera que gane el equipo 2");
        }

    }
}
