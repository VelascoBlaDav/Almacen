
package GestionDeFunciones;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class Calculo {
    public static int diasRestantes(Date fecha){    //Devuelve <0 si la fecha es anterior al dia de hoy
        Date hoy = Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant());
        int dias=(int) (fecha.getTime()-hoy.getTime())/86400000;
        return dias;       
    }
    public static int diasDiferencia(Date fecha1,Date fecha2){  //Devuelve <0 si la fecha1 es anterior a la fecha2
        int dias=(int) (fecha1.getTime()-fecha2.getTime())/86400000;
        return dias;       
    }
}
