/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.edu.itses.CJMRA.MetodosNumericos.domain;

/**
 *
 * @author Administrador
 */
import java.util.ArrayList;
import lombok.Data;

@Data
public class ReglaCramer {
    private int MN; //tamaño de la matriz
    private ArrayList<Double> matrizA;
    private ArrayList<Double> vectorB;
    private ArrayList<Double> vectorX;
    private ArrayList<Double> Determinantes;
    private int NumeroRenglon;
    
    public int IncrementarRenglon(){
    return NumeroRenglon++;
    }
}
