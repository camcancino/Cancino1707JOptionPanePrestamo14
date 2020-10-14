package cancino1707joptionpaneprestamo;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


public class Cancino1707JOptionPanePrestamo {

   public static void main(String[] args) {
        ImageIcon logoBanco = new ImageIcon("src/img/banklogo.png");
        //bienvenida
        JOptionPane.showMessageDialog(null, "                       Bienvenido a WORLD BANK ARGENTINA"
                + "\n Por favor rellene la siguiente solicitud de préstamo con sus datos. "
                + "\n Recuerde que debe cumplir con los requisitos para ser aprobado. "
                + "\n El estado de su solicitud le será informado al finalizar el trámite. "
               
                + "\n Muchas gracias", 
            "Solicitudes de Préstamos", JOptionPane.INFORMATION_MESSAGE, logoBanco);
       
        //pedido de datos
        String nombre = JOptionPane.showInputDialog(null, "Ingrese su nombre completo: ", "Ingreso de datos", JOptionPane.QUESTION_MESSAGE);
        int dni = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese su DNI: ", "Ingreso de datos", JOptionPane.QUESTION_MESSAGE));
        float sueldo = Float.parseFloat(JOptionPane.showInputDialog(null, "Ingrese el importe mensual de su sueldo: ", "Ingreso de datos", 
                                            JOptionPane.QUESTION_MESSAGE));
            
        float cantidadSolicitada = Float.parseFloat(JOptionPane.showInputDialog(null, "A continuación deberá indicar las características del préstamo."
                + "\n Por favor indique el importe a solicitar: ", "Datos del préstamo", JOptionPane.QUESTION_MESSAGE));
        
        int cuotasSolicitadas;
        do{    
            cuotasSolicitadas = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la cantidad de cuotas a solicitar: ", "Datos del préstamo", 
                                    JOptionPane.QUESTION_MESSAGE));
            if((cuotasSolicitadas<1) || (cuotasSolicitadas>12)){
                JOptionPane.showMessageDialog(null, "La cantidad de cuotas debe ser de 1 a 12", null, JOptionPane.WARNING_MESSAGE);
            }
        
        }while((cuotasSolicitadas<1) || (cuotasSolicitadas>12));
        
        //evualuacion y aprobacion/desaprobacion de la solicitud
        boolean aprobado = estadoDelPrestamo(sueldo, cantidadSolicitada, cuotasSolicitadas);
        
        respuestaDeSolicitud(aprobado, sueldo, cantidadSolicitada, cuotasSolicitadas, dni, nombre);
        
        
   }
   
   public static boolean estadoDelPrestamo(float sueldo, float solicitado, int cuotas){
        boolean aprobado = false;
        
        if(((sueldo*12)>=200000.0)&&((sueldo*10)>=solicitado)&&(solicitado<=100000.0)){
            aprobado = true;
        }
   
    return aprobado;
   }
   
   public static void respuestaDeSolicitud(boolean aprobado, float sueldo, float solicitado, int cuotas, int dni, String nombre){
    ImageIcon logoBanco = new ImageIcon("src/img/banklogo.png");
    float importe = solicitado/cuotas;
    
    if (aprobado){
        
        JOptionPane.showMessageDialog(null, "ESTADO DE LA SOLICITUD: \n--- APROBADA --- \n" 
            +"\nDATOS DE LA SOLICITUD: "
            + "\nNombre del solicitante: "+nombre
            +"\nDNI: "+dni
            +"\nSueldo mensual: "+sueldo
            +"\nCantidad solicitada: "+solicitado
            +"\nCantidad de cuotas solicitadas: "+cuotas
            +"\nImporte a pagar: "+(double)Math.round(importe * 100d)/100
            +"\nMUCHAS GRACIAS"
            , "Estado de la solicitud", JOptionPane.INFORMATION_MESSAGE,logoBanco);
        
    } else {
        
        JOptionPane.showMessageDialog(null, "ESTADO DE LA SOLICITUD: \nDESAPROBADA \n"
            +"\nDATOS DE LA SOLICITUD: "
            + "\nNombre del solicitante: "+nombre
            +"\nDNI: "+dni
            +"\nSueldo mensual: "+sueldo
            +"\nCantidad solicitada: "+solicitado
            +"\nCantidad de cuotas solicitadas: "+cuotas
            +"\nMUCHAS GRACIAS"
            , "Estado de la solicitud", JOptionPane.ERROR_MESSAGE, logoBanco);
        
        }
   
   
   }
   

}
