/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boletin14;

import javax.swing.JOptionPane;

/**
 *
 * @author sherlyn
 */
public class Garaxe {
   static int numC = 0; // saber se o garaxe esta cheo ou valeiro 
   private String matri; //para rexistrar o coche
   private float tempo; //saber el tiempo que echan tengo que restar el tiempo de salida menos el de entrada
   private float precio; // la tarifa 3 horas 1.5 la hora y luego 0.20 la hora
   private long tE; //es el tiempo en el que entra el coche
   private long tS; //el el tiempo en el que sale el coche, nos dice lo que pasó dentro
   
   public boolean saberPlazas (){
       if (numC < 5) {
           JOptionPane.showMessageDialog(null, "Hay "+(5-numC)+" plazas disponibles");
           return true;
       } else {
           JOptionPane.showMessageDialog(null, "No hay ninguna plaza disponible");
           return false;
       }
   }
   
   public long aparcarParking (){
       if (saberPlazas() == true){
           tE=System.currentTimeMillis();
           matri = JOptionPane.showInputDialog("Ingrese la matrícula de su coche para poder entrar.");
           numC++;
       }
   return tE;
           }
   
   public long salirParking (){
       tS = System.currentTimeMillis();
       numC--;
       return tS;
   }
   
   public float tiempoParking (){
       tempo = (tS - tE) /1000;
       return tempo;
   }
   
   public float precioPagar (){
       precio = (((tempo/3) * 1.5f)*0.20f);
       return precio;
   }
   
   public void laFactura(){
       salirParking();
       this.tiempoParking();
       this.precioPagar();
       float pagar = Float.parseFloat(JOptionPane.showInputDialog("Total a pagar: " + precioPagar() + "\nIntroduce el dinero"));
        if (pagar < precio) {
            do {
                pagar = Float.parseFloat(JOptionPane.showInputDialog("No le llega eld inero\nDebe pagar: " + precioPagar() + "\nIntroduce el importe"));
            } while (pagar < precio);
        }
        float devolver = pagar - precio;
        JOptionPane.showMessageDialog(null, "SU FACTURA\nMatrícula coche: " + matri + "\nTiempo: " + tempo + " segundos" + "\nPrecio: " + precioPagar() + "€" + "\nDinero recibido: " + pagar + "€" + "\nDinero devuelto: " + devolver + "€");
    }
   
}

