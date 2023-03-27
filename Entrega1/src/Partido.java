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


    public int getGoles1() {
        return goles1;
    }

    public int getGoles2() {
        return goles2;
    }

    public void GanadorPartido() {
        if (goles1 > goles2) {
            Equipo1.SetResultado(RESULTADO.ganador);
            Equipo2.SetResultado(RESULTADO.perdedor);
            System.out.println("Ganó el equipo 1");

        } else if (goles2 > goles1) {
            Equipo1.SetResultado(RESULTADO.perdedor);
            Equipo2.SetResultado(RESULTADO.ganador);
            System.out.println("Ganó el equipo 2");
        } else {
            Equipo1.SetResultado(RESULTADO.empate);
            Equipo2.SetResultado(RESULTADO.empate);
            System.out.println("Empataron");
        }
    }
    //
}
