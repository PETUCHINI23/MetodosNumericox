/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package mx.edu.itses.CJMRA.MetodosNumericos.services;

import mx.edu.itses.CJMRA.MetodosNumericos.domain.DDNewton;
import mx.edu.itses.CJMRA.MetodosNumericos.domain.Lagrange;

/**
 *
 * @author administrador
 */
public interface UnidadIVService {

        public DDNewton AlgoritmoDDNewton(DDNewton model);
        public Lagrange AlgoritmoLagrange(Lagrange model);
}
