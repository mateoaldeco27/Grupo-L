

public class Equipo{
    public Equipo (int id, String nombre)
    {
        this.id=id;
        this.nombre=nombre;

    }
    private String descripcion;
    private String nombre;
    private int id;
    private Resultado resultado;


    public void SetNombre(String nombre)
    {
        this.nombre = nombre;

    }
    public String GetNombre()
    {
        return nombre;
    }
    public void SetDescripcion(String descripcion){
        this.descripcion = descripcion;

    }
    public String  GetDescripcion(){
        return descripcion;
    }

    public void SetId(int id){
        this.id=id;
    }

    public int GetId(){
        return id;
    }

    public void SetResultado(Resultado resultado)
    {
        this.resultado = resultado;
    }


}


