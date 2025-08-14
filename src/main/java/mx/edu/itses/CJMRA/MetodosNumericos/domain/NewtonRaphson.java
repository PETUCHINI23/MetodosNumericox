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
public class NewtonRaphson {
      private String FX;              
    private String FXDerivada;      
    private double Xi;              
    private double FXi;            
    private double FXii;        
    private double Xii;           
    private double Ea;              
    private int IteracionesMaximas; 
}