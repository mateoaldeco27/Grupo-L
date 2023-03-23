public class Partido{
    public Partido (Equipo Equipo1, int goles1, int goles2, Equipo Equipo2){
        this.Equipo1 = Equipo1;
        this.Equipo2 = Equipo2;
        this.goles1 = goles1;
        this.goles2 = goles2;
    }
    private Equipo Equipo1;
    private Equipo Equipo2;
    private int goles1;
    private int goles2;


    public void Ganador()
    {
        if(goles1>goles2)
        {
            Equipo1.SetResultado(Resultado.ganador);
            Equipo2.SetResultado(Resultado.perdedor);

        }
        else if (goles2>goles1)
        {
            Equipo1.SetResultado(Resultado.perdedor);
            Equipo2.SetResultado(Resultado.ganador);
        }
        else
        {
            Equipo1.SetResultado(Resultado.empate);
            Equipo2.SetResultado(Resultado.empate);
        }
    }
}
