
package GestionDeClientes;

public class Cliente {
    private String nombre;
    private String NIF;
    private String direccion;
    private String codCliente;
    private int credito; //con la compra se reduce, con la devolucion se aumenta

    public Cliente(String nombre, String NIF, String direccion, int credito) {
        this.nombre = nombre;
        this.NIF = NIF;
        this.direccion = direccion;
        this.codCliente = nombre.concat(NIF); //concateno el nombre del cliente con el NIF para generar el codigo
        this.credito = credito;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNIF() {
        return NIF;
    }

    public void setNIF(String NIF) {
        this.NIF = NIF;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getCredito() {
        return credito;
    }

    public void setCredito(int credito) {
        this.credito = credito;
    }
    
    
}
