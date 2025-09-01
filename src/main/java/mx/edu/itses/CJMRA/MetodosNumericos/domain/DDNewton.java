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
public class DDNewton {
    private Integer gradoPolinomio;
    private ArrayList<Double> puntosX;
    private ArrayList<Double> valoresY;
    private Double valorAInterpolar;
    private ArrayList<Double> coeficientesNewton;
    private ArrayList<Double> tablaDD;
    private Double resultadoInterpolacion;
}