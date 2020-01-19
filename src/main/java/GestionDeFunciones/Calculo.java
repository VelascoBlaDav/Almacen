
package GestionDeFunciones;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class Calculo {
    public static int diasRestantes(Date fecha){
        Date hoy = Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant());
        int dias=(int) (fecha.getTime()-hoy.getTime())/86400000;
        return dias;       
    }
}
