import java.util.ArrayList;

public class Ronda {

    public Ronda()
    {
        //this.partido = partido;
        //partidos.add(partido);

    }

    ArrayList<Partido> partidos = new ArrayList<>();

    private int numero;
    private int resultadoRonda;

    private int resultadoRondaFinal;

    public int getPartidosxronda() {
        return partidosxronda;
    }

    private int partidosxronda = 3;


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
    public void setResultadoRonda(int resultadoRonda) {
        this.resultadoRonda = resultadoRonda;
    }

    public int getResultadoRonda() {
        return resultadoRonda;
    }

    public int getResultadoRondaFinal() {
        return resultadoRondaFinal;
    }

    public void setResultadoRondaFinal(int resultadoRondaFinal) {
        this.resultadoRondaFinal = resultadoRondaFinal;
    }


}
