
package GestionDeClientes;

public class Cliente {
    private String nombre;
    private String NIF;
    private String direccion;
    private String codCliente;
    private float credito;

    public Cliente(String nombre, String NIF, String direccion, float credito) {
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

    public float getCredito() {
        return credito;
    }
    public void setCredito(float credito) {
        this.credito = credito;
    }
    
    public String getCodCliente() {
        return codCliente;
    }
    
    public void setCodCliente(String codCliente) {
        this.codCliente = codCliente;
    }
    
    public void aumentaCredito(float credito) {
        this.credito = getCredito()+credito;
    }
    
    public void reduceCredito(float credito) {
        this.credito = getCredito()-credito;
    }
    @Override
    public String toString() {
        return "Cliente:{" + "codigoCliente=" + codCliente + 
                ", nombre=" + nombre + 
                ", NIF=" + NIF + 
                ", direccion=" + direccion + 
                ", credito=" + credito+
                "}";
                
    }
}
