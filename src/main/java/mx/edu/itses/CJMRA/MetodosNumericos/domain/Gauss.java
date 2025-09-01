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
public class Gauss {
    private Integer dimension;
    private ArrayList<Double> matrizCoeficientes;
    private ArrayList<Double> vectorTerminosIndependientes;
    private ArrayList<Double> vectorSolucion;
    private ArrayList<String> detallesProceso;
    private ArrayList<Double> matrizSuperior;
    private boolean esSingular;
    private String resultadoMensaje;
}