public class Equipo {
    public Equipo (int id, String nombre, String descripcionEquipo)
    {
        this.id = id;
        this.nombre = nombre;
        descripcion = descripcionEquipo;

    }

    private String descripcion;
    private String nombre;
    private int id;
    private Resultado resultado;

    public String GetNombre()
    {
        return nombre;
    }

    public String  GetDescripcion(){
        return descripcion;
    }

    public int GetId(){
        return id;
    }

    public void SetResultado(Resultado resultado)
    {
        this.resultado = resultado;
    }


}