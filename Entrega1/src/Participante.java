public class Participante {

    public Participante (int identification, String name)
    {
        id = identification;
        nombre = name;
    }

    private int id;
    private String nombre;
    private int puntos;
    private int puntosFinales;

    public void sumarPunto () {
      puntos++;
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
    public void sumaPuntosFinales() {
       puntosFinales += puntos;
    }

}
