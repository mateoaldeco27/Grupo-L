import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

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
    public int puntos;

    public void AcertoElPronostico()
    {
        if (equipo1.getResultado() == equipo1.getExpectativa())
        {
            puntos++;
        }
    }
    public void ComprobarDatos(String[] datos) throws IOException
    {
        for (int i = 1; i < datos.length-1; i++) {
            if(datos[1].equals("X"))
            {
                equipo1.SetExpectativa(RESULTADO.ganador);
                equipo2.SetExpectativa(RESULTADO.perdedor);

            }
            else if (datos[2].equals("X"))
            {
                equipo1.SetExpectativa(RESULTADO.empate);
                equipo2.SetExpectativa(RESULTADO.empate);
            }
            else
            {
                equipo1.SetExpectativa(RESULTADO.perdedor);
                equipo2.SetExpectativa(RESULTADO.ganador);
            }
        }
    }
}


}
