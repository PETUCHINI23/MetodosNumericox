
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.edu.itses.CJMRA.MetodosNumericos.domain;

/**
 *
 * @author Administrador
 */


import lombok.Data;

@Data   
public class ReglaFalsa {
      private String FX;
       private double XL;
    private double XU;
    private double XR;
    private double FXL;
    private double FXU;
    private double FXR;
    private double ProductoFXL_FXR; 
    private double Ea;
    private int IteracionesMaximas;
}

