/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.edu.itses.CJMRA.MetodosNumericos.services;

import java.util.ArrayList;
import lombok.extern.slf4j.Slf4j;
import mx.edu.itses.CJMRA.MetodosNumericos.domain.DDNewton;
import mx.edu.itses.CJMRA.MetodosNumericos.domain.Lagrange;

import org.springframework.stereotype.Service;

/**
 *
 * @author administrador
 */
@Service
@Slf4j
public class UnidadIVServiceImpl implements UnidadIVService {

  
@Override
public DDNewton AlgoritmoDDNewton(DDNewton model) {
    DDNewton out = new DDNewton();
    if (model == null) {
        return out;
    }

    Integer gradoPolinomio = model.getGradoPolinomio();
    var puntosX = model.getPuntosX();
    var valoresY = model.getValoresY();
    Double valorAInterpolar = model.getValorAInterpolar();

    out.setGradoPolinomio(gradoPolinomio);
    out.setPuntosX(puntosX);
    out.setValoresY(valoresY);
    out.setValorAInterpolar(valorAInterpolar);

    if (gradoPolinomio == null || gradoPolinomio < 1 || gradoPolinomio > 4) {
        return out;
    }
    int n = gradoPolinomio + 1;
    if (puntosX == null || valoresY == null || puntosX.size() != n || valoresY.size() != n) {
        return out;
    }

    double[][] T = new double[n][n];
    for (int i = 0; i < n; i++) {
        T[i][0] = valoresY.get(i);
    }
    for (int j = 1; j < n; j++) {
        for (int i = 0; i < n - j; i++) {
            double denom = puntosX.get(i + j) - puntosX.get(i);
            T[i][j] = (T[i + 1][j - 1] - T[i][j - 1]) / denom;
        }
    }

    ArrayList<Double> coef = new ArrayList<>(n);
    for (int j = 0; j < n; j++) {
        coef.add(T[0][j]);
    }
    out.setCoeficientesNewton(coef);

    Double resultadoInterpolacion = null;
    if (valorAInterpolar != null) {
        double acc = coef.get(n - 1);
        for (int k = n - 2; k >= 0; k--) {
            acc = coef.get(k) + (valorAInterpolar - puntosX.get(k)) * acc;
        }
        resultadoInterpolacion = acc;
    }
    out.setResultadoInterpolacion(resultadoInterpolacion);

    ArrayList<Double> flat = new ArrayList<>(n * n);
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            flat.add(T[i][j]);
        }
    }
    out.setTablaDD(flat);

    return out;
}


    @Override
    public Lagrange AlgoritmoLagrange(Lagrange model) {
Lagrange out = new Lagrange();
        if (model == null) return out;

        Integer orden = model.getOrden();
        var xs = model.getXs();
        var ys = model.getYs();
        Double xEval = model.getXEval();

        out.setOrden(orden);
        out.setXs(xs);
        out.setYs(ys);
        out.setXEval(xEval);

        if (orden == null || orden < 1 || orden > 4) return out;
        int n = orden + 1;
        if (xs == null || ys == null || xs.size() != n || ys.size() != n) return out;
        if (xEval == null) return out;

        double sum = 0.0;
        for (int i = 0; i < n; i++) {
            double Li = 1.0;
            for (int j = 0; j < n; j++) {
                if (j == i) continue;
                double denom = xs.get(i) - xs.get(j);
                Li *= (xEval - xs.get(j)) / denom;
            }
            sum += ys.get(i) * Li;
        }
        out.setYEval(pretty(sum));
        return out;    }
    
  private static double pretty(double v) {
        if (Math.abs(v) < 1e-12) return 0.0;
        double r = Math.rint(v);
        if (Math.abs(v - r) < 1e-9) return r;
        return Math.round(v * 1e6) / 1e6;
    }
}
