<<<<<<< HEAD
package mx.edu.itses.CJMRA.MetodosNumericos.services;

import static java.lang.Math.abs;
import org.mariuszgromada.math.mxparser.*;

public class Funciones {

    public static double Ecuacion(String f1, double x) {

        double f;
        Function funcion = new Function(f1);
        Expression evaluacion = new Expression("f(" + x + ")", funcion);
        f = evaluacion.calculate();

        return f;
    }
    
    public static double ErrorRelativo(double ValorNuevo, double ValorAnterior) {
        return abs((ValorNuevo - ValorAnterior) / ValorNuevo * 100);
    }


}
=======
package mx.edu.itses.CJMRA.MetodosNumericos.services;

import static java.lang.Math.abs;
import org.mariuszgromada.math.mxparser.*;

public class Funciones {

    public static double Ecuacion(String f1, double x) {

        double f;
        Function funcion = new Function(f1);
        Expression evaluacion = new Expression("f(" + x + ")", funcion);
        f = evaluacion.calculate();

        return f;
    }
    
    public static double ErrorRelativo(double ValorNuevo, double ValorAnterior) {
        return abs((ValorNuevo - ValorAnterior) / ValorNuevo * 100);
    }


}
>>>>>>> b5b7271 ( metodo de New Raphson)
