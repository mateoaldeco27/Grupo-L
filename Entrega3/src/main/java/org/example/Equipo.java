package org.example;

public class Equipo {
    public Equipo (int id, String nombre, String descripcionEquipo)
    {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcionEquipo;

    }

    private String descripcion;
    private String nombre;
    private int id;
    private RESULTADO resultado;
    private RESULTADO expectativa;

    public String getNombre()
    {
        return nombre;
    }

    public void setResultado(RESULTADO resultado)
    {
        this.resultado = resultado;
    }

    public RESULTADO getExpectativa() {
        return expectativa;
    }

    public void setExpectativa(RESULTADO expectativa) {
        this.expectativa = expectativa;
    }

    public RESULTADO getResultado() {
        return resultado;
    }

    public String mostrameDatosEquipo() {
        return "Equipo{" +
                "descripcion='" + descripcion + '\'' +
                ", nombre='" + nombre + '\'' +
                ", id=" + id +
                ", resultado=" + resultado +
                ", expectativa=" + expectativa +
                '}';
    }
}
