import java.util.ArrayList;

public class Ronda {
    public Ronda(Partido partido)
    {
        this.partido = partido;

    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    private int numero;
    private int resultadoRonda;
    private Partido partido;
    private static final int partidosxronda = 3;

    public void siguienteRonda() {
        this.numero++;
    }

    public int getNumero(){return numero;}

}
