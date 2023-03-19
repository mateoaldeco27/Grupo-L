

public class Equipo {public class Producto {
    public void Equipo(int id, String nombre, String descripcion)
    {

        this.descripcion=descripcion;
        this.id=id;
        this.nombre=nombre;

    }
    private String descripcion = "";
    private String nombre = "";
    private int id = 0;


    public void SetNombre(String nombre)
    {
        this.nombre = nombre;

    }
    public String GetNombre()
    {
        return nombre;
    }


}}
