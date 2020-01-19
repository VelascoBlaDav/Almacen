
package GestionDeFunciones;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Lectura {
    public static String cadena(){
        Scanner sc = new Scanner (System.in);
        String cadena=sc.nextLine();
        return cadena;
    }
    
    public static int entero(){
        Scanner sc = new Scanner (System.in);
        String string=sc.nextLine();
        int entero=0;
        try {
            entero=Integer.parseInt(string);
        } 
        catch (NumberFormatException ex) 
        {
            System.out.println(ex);
        }
        return entero;
    }
    
    public static float real(){
        Scanner sc = new Scanner (System.in);
        String string=sc.nextLine();
        float real=0;
        try {
            real = Float.parseFloat(string);
        } 
        catch (NumberFormatException ex) 
        {
            System.out.println(ex);
        }
        return real;
        
    }
    
    public static Date fecha(){
        Scanner sc = new Scanner (System.in);
        String string=sc.nextLine();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date fecha = null;
        try {
            fecha = formato.parse(string);
        } 
        catch (ParseException ex) 
        {
            System.out.println(ex);
        }
        return fecha;
    }
    
    public static boolean booleanoNumerico(){
        int entero=entero();
        if(entero==1){
            return true;
        }else{
            return false;
        }
    }
    
}
