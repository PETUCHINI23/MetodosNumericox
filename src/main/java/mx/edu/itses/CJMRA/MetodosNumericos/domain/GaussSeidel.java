/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.edu.itses.CJMRA.MetodosNumericos.domain;

import java.util.ArrayList;
import lombok.Data;

@Data
public class GaussSeidel {
    private Integer dimension;
    private ArrayList<Double> matrizCoeficientes;
    private ArrayList<Double> vectorTerminosIndependientes;
    private ArrayList<Double> vectorSolucion;
    private Integer maxIteraciones;
    private Double toleranciaError;
    private boolean converge;
    private ArrayList<String> pasos;
} 