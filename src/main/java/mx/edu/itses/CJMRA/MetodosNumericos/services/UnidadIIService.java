
package mx.edu.itses.CJMRA.MetodosNumericos.services;

import java.util.ArrayList;
import mx.edu.itses.CJMRA.MetodosNumericos.domain.Biseccion;
import mx.edu.itses.CJMRA.MetodosNumericos.domain.NewtonRaphson;
import mx.edu.itses.CJMRA.MetodosNumericos.domain.PuntoFijo;
import mx.edu.itses.CJMRA.MetodosNumericos.domain.ReglaFalsa;
import mx.edu.itses.CJMRA.MetodosNumericos.domain.Secante;
import mx.edu.itses.CJMRA.MetodosNumericos.domain.SecanteModificado;



public interface UnidadIIService {
    
   public ArrayList<Biseccion> AlgoritmoBiseccion(Biseccion biseccion);
        
   public ArrayList<ReglaFalsa> AlgoritmoReglaFalsa(ReglaFalsa reglafalsa);

   public ArrayList<PuntoFijo> AlgoritmoPuntoFijo(PuntoFijo puntofijo);
 
   public ArrayList<NewtonRaphson> AlgoritmoNewtonRaphson(NewtonRaphson newtonraphson);
   
    public ArrayList<Secante> AlgoritmoSecante(Secante secante);

  public ArrayList<SecanteModificado> AlgoritmoSecanteModificado(SecanteModificado secantemodificado);
   
  
  
}