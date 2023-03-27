import java.io.IOException;

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
    public int puntos = 0;

    public void AcertoElPronostico()
    {
        if (equipo1.getResultado() == equipo1.getExpectativa())
        {
            puntos++;
        } else if (equipo2.getResultado() == equipo2.getExpectativa())
        {
            puntos++;
        }
        else{
            System.out.println("Mariana no acertó el pronóstico");
        }

    }
   public void ComprobarDatos(String datos)
    {
        String[] infoPronostico = datos.split(";");
            if(infoPronostico[1].equals("X"))
            {
                equipo1.setExpectativa(RESULTADO.ganador);
                equipo2.setExpectativa(RESULTADO.perdedor);
                System.out.println("Mariana espera que gane el equipo 1");
            }
            else if (infoPronostico[2].equals("X"))
            {
                equipo1.setExpectativa(RESULTADO.empate);
                equipo2.setExpectativa(RESULTADO.empate);
                System.out.println("Mariana espera que empaten");
            }
            else
            {
                equipo1.setExpectativa(RESULTADO.perdedor);
                equipo2.setExpectativa(RESULTADO.ganador);
                System.out.println("Mariana espera que gane el equipo 2");
            }
    }
}
