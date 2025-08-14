
package mx.edu.itses.CJMRA.MetodosNumericos.services;

import java.util.ArrayList;
import mx.edu.itses.CJMRA.MetodosNumericos.domain.Biseccion;
import mx.edu.itses.CJMRA.MetodosNumericos.domain.NewtonRaphson;
import mx.edu.itses.CJMRA.MetodosNumericos.domain.ReglaFalsa;

public interface UnidadIIService {
     public ArrayList<Biseccion> AlgoritmoBiseccion(Biseccion biseccion);
     
     public ArrayList<ReglaFalsa> AlgoritmoReglaFalsa(ReglaFalsa reglafalsa);
     
     public ArrayList<NewtonRaphson> AlgoritmoNewtonRaphson(NewtonRaphson newtonRaphson);

     
}

