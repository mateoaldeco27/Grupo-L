public class Participante {

    public Participante (int identification, String name, RESULTADO expectativa)
    {
        id = identification;
        nombre = name;
        this.expectativa = expectativa;
    }

    private int id;
    private String nombre;
    private RESULTADO expectativa;

    public String getNombre() {
        return nombre;
    }

    public RESULTADO getExpectativa() {
        return expectativa;
    }

    public int getId() {
        return id;
    }


}
