package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PartidoTest
{

    private Partido partido;
    private Equipo equipo1;
    private Equipo equipo2;
    @BeforeEach
    void setUp()
    {
        Equipo equipo1 = new Equipo(1,"Argentina","Seleccion Argentina");
        Equipo equipo2 = new Equipo(2,"Francia","Seleccion Francesa");
        Partido partido = new Partido(equipo1,3,0,equipo2);
        this.partido = partido;
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
    }

    @AfterEach
    void tearDown()
    {
        System.out.println("el test fue exitoso!!");
    }

    @Test
    void ganadorPartidoEquipo1()
    {
        partido.GanadorPartido(1);
        assertEquals(RESULTADO.ganador, equipo1.getResultado());
    }
    @Test
    void ganadorPartidoEquipo2()
    {
        partido.GanadorPartido(1);
        assertEquals(RESULTADO.ganador, equipo2.getResultado());
    }
}