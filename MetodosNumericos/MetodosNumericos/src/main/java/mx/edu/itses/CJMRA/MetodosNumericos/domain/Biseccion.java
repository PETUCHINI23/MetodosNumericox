/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.edu.itses.CJMRA.MetodosNumericos.domain;

import lombok.Data;

/**
 *
 * @author Administrador
 */
@Data
public class Biseccion {
    
    private String FX;  //funcion evaluar
    private double XL;
    private double XU;
    private double XR;
    private double FXL;
    private double FXU;
    private double FXR;
    private double Ea;
    private double IteracionesMaximas;
    
    
    
    
}
