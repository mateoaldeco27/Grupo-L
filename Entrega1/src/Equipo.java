

public class Equipo{
    public void Equipo (int id, String nombre, String descripcion)
    {

        this.descripcion=descripcion;
        this.id=id;
        this.nombre=nombre;

    }
    private String descripcion;
    private String nombre;
    private int id;


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



}


