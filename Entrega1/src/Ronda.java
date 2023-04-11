import java.util.ArrayList;

public class Ronda {
    public Ronda(Partido partido)
    {
        this.partido = partido;

    }

    private int numero;
    private int resultadoRonda;
    private Partido partido;

    ArrayList<Partido> partidosaux = new ArrayList<>();



    public void siguienteRonda() {
        this.numero++;
    }

    public int getNumero(){return numero;}

}
