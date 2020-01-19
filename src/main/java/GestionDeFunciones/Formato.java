
package GestionDeFunciones;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Formato {
    public static String fecha(Date fecha){
        String fechaFormateada=new SimpleDateFormat("dd/MM/yyyy").format(fecha);
        return fechaFormateada;
    }
}
