public class Partido extends Equipo {
    public void partido(String Equipo1, int goles1, int goles2, String Equipo2){
        this.Equipo1 = Equipo1;
        this.Equipo2 = Equipo2;
        this.goles1 = goles1;
        this.goles2 = goles2;
    }
    private String Equipo1;
    private String Equipo2;
    private int goles1;
    private int goles2;

    public static void CrearPartido(String partido)
    {
        String[] arrayPartido = partido.split(",");
        String Equipo1 = arrayPartido[1];
        System.out.println(Equipo1);
        String Equipo2 = arrayPartido[4];
        int goles1 = Integer.parseInt(arrayPartido[2]);
        int goles2 = Integer.parseInt(arrayPartido[3]);

    }


}
