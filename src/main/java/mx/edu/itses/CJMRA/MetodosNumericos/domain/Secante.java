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
public class Secante {

    private String FX;
    private double Xi;
    private double Xi_1;
    private double FXi;
    private double Xi1;
    private double Ea;
    private int IteracionesMaximas;
    private double F_Xi_1;

}
