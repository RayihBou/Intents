package comrayihbou.github.intents;

/* El uso de esta clase es exclusivo para alojar la informacion de los contactos.
   a los cuales se le realizaran el llamado de las demas clases para minimizar el codigo.
*/
public class Contacto {
    //Declaracion de variables
    private String nombre;
    private String telefono;
    private String email;

    public Contacto(String nombre, String telefono, String email) { //Constuctor del objeto contacto.
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
    }

    //Creacion de los Getters y Setters.
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
