package org.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

public class PronosticoTest
{

    private Participante participante1, participante2;
    private Pronostico pronostico;
    private Equipo equipo1, equipo2;

    @BeforeEach
    public void setUp ()
    {
        Participante participante1 = new Participante(1,"Mariana");
        Participante participante2 = new Participante(2,"Pedro");
        Equipo equipo1 = new Equipo(1, "Argentina","Campeon del mundo");
        Equipo equipo2 = new Equipo(2,"Francia","El segundo");
        Partido partido = new Partido(equipo1,3,2,equipo2);
        Pronostico pronostico = new Pronostico(partido, equipo1, equipo2);

        this.pronostico = pronostico;
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
        this.participante1 = participante1;
        this.participante2 = participante2;
    }

    @AfterEach
    void tearDown()
    {
        System.out.println("el test fue exitoso!!");
    }

    @Test
    public void testAcertoElPronostico ()
    {
        ArrayList<Participante> participantes = new ArrayList<>();
        participantes.add(participante1);
        participantes.add(participante2);
        pronostico.setParticipante(participante1);
        equipo1.setExpectativa(RESULTADO.ganador);
        equipo1.setResultado(RESULTADO.ganador);
        pronostico.AcertoElPronostico(participantes, 1);
        assertEquals(1, participante1.getPuntos());
    }

    @Test
    public void testComprobarDatos()
    {
        ArrayList<Participante> participantes = new ArrayList<>();
        participantes.add(participante1);
        participantes.add(participante2);
        pronostico.ComprobarDatos(new String[]{"", "", "", "X", "", ""}, participantes, 1);
        assertEquals(RESULTADO.ganador, equipo1.getExpectativa());
        assertEquals(RESULTADO.perdedor, equipo2.getExpectativa());
    }
}

