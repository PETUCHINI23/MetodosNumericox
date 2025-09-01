/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.edu.itses.CJMRA.MetodosNumericos.domain;

import java.util.ArrayList;
import lombok.Data;

/**
 *
 * @author Administrador
 */
@Data
public class GaussJordan {
     private Integer MN;                       
    private ArrayList<Double> matrizA;        
    private ArrayList<Double> vectorB;        
    private ArrayList<Double> vectorX;        
    private boolean singular;                 
    private ArrayList<Double> matrizRrefAumentada;   
}
