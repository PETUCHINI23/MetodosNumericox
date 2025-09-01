package mx.edu.itses.CJMRA.MetodosNumericos.services;

import java.util.ArrayList;
import lombok.extern.slf4j.Slf4j;
import mx.edu.itses.CJMRA.MetodosNumericos.domain.Biseccion;
import mx.edu.itses.CJMRA.MetodosNumericos.domain.NewtonRaphson;
import mx.edu.itses.CJMRA.MetodosNumericos.domain.PuntoFijo;

import mx.edu.itses.CJMRA.MetodosNumericos.domain.ReglaFalsa;
import mx.edu.itses.CJMRA.MetodosNumericos.domain.Secante;
import mx.edu.itses.CJMRA.MetodosNumericos.domain.SecanteModificado;
import mx.edu.itses.CJMRA.MetodosNumericos.services.Funciones;
import mx.edu.itses.CJMRA.MetodosNumericos.services.UnidadIIService;
import org.springframework.stereotype.Service;

@Service
@Slf4j


public class UnidadIIServiceImpl implements UnidadIIService {
 

    @Override
    public ArrayList<Biseccion> AlgoritmoBiseccion(Biseccion biseccion) {
        ArrayList<Biseccion> respuesta = new ArrayList<>();
        double XL, XU, XRa, XRn, FXL, FXU, FXR, Ea;

        XL = biseccion.getXl();
        XU = biseccion.getXu();
        XRa = 0;
        Ea = 100;

        FXL = Funciones.Ecuacion(biseccion.getFx(), XL);
        FXU = Funciones.Ecuacion(biseccion.getFx(), XU);
        if (FXL * FXU < 0) {
            for (int i = 1; i <= biseccion.getIteracionesMaximas(); i++) {
                XRn = (XL + XU) / 2;
                FXL = Funciones.Ecuacion(biseccion.getFx(), XL);
                FXU = Funciones.Ecuacion(biseccion.getFx(), XU);
                FXR = Funciones.Ecuacion(biseccion.getFx(), XRn);
                if (i != 1) {
                    Ea = Funciones.ErrorRelativo(XRn, XRa);
                }
                Biseccion renglon = new Biseccion();
                renglon.setXl(XL);
                renglon.setXu(XU);
                renglon.setXr(XRn);
                renglon.setFXl(FXL);
                renglon.setFXu(FXU);
                renglon.setFXr(FXR);
                renglon.setEa(Ea);
                if (FXL * FXR < 0) {
                    XU = XRn;
                } else if (FXL * FXR > 0) {
                    XL = XRn;
                } else if (FXL * FXR == 0) {
                    break;
                }
                XRa = XRn;
                respuesta.add(renglon);
                if (Ea <= biseccion.getEa()) {
                    break;
                }
            }
        } else {
            Biseccion renglon = new Biseccion();
           
            respuesta.add(renglon);
        }

        return respuesta;
    }

    @Override
    public ArrayList<ReglaFalsa> AlgoritmoReglaFalsa(ReglaFalsa reglafalsa) {
        ArrayList<ReglaFalsa> respuesta = new ArrayList<>();
        double XL, XU, XRa, XRn, FXL, FXU, FXR, Ea;

        XL = reglafalsa.getXL();
        XU = reglafalsa.getXU();
        XRa = 0;
        Ea = 100;

       
        FXL = Funciones.Ecuacion(reglafalsa.getFX(), XL);
        FXU = Funciones.Ecuacion(reglafalsa.getFX(), XU);
        if (FXL * FXU < 0) {
            for (int i = 1; i <= reglafalsa.getIteracionesMaximas(); i++) {
                FXL = Funciones.Ecuacion(reglafalsa.getFX(), XL);
                FXU = Funciones.Ecuacion(reglafalsa.getFX(), XU);
                XRn = XU - ((FXU * (XL - XU)) / (FXL - FXU));
                FXR = Funciones.Ecuacion(reglafalsa.getFX(), XRn);

                if (i != 1) {
                    Ea = Funciones.ErrorRelativo(XRn, XRa);
                }

                ReglaFalsa renglon = new ReglaFalsa();
                renglon.setXL(XL);
                renglon.setXU(XU);
                renglon.setXR(XRn);
                renglon.setFXL(FXL);
                renglon.setFXU(FXU);
                renglon.setFXR(FXR);
                renglon.setEa(Ea);

                respuesta.add(renglon);

               
                if (FXL * FXR < 0) {
                    XU = XRn;
                } else if (FXL * FXR > 0) {
                    XL = XRn;
                } else {
                    break; 
                }

                XRa = XRn;

                if (Ea <= reglafalsa.getEa()) {
                    break;
                }
            }
        } else {
            ReglaFalsa renglon = new ReglaFalsa();
          
            respuesta.add(renglon);
        }

        return respuesta;
    }

    @Override
    public ArrayList<PuntoFijo> AlgoritmoPuntoFijo(PuntoFijo puntofijo) {
        ArrayList<PuntoFijo> respuesta = new ArrayList<>();
        double Xi = puntofijo.getXi();
        double Xn;                     
        double Ea = 100;               
        int maxIteraciones = puntofijo.getIteracionesMaximas();

        for (int i = 1; i <= maxIteraciones; i++) {
           
            Xn = Funciones.Ecuacion(puntofijo.getGX(), Xi);

           
            Ea = Funciones.ErrorRelativo(Xn, Xi);

            double gx = Funciones.Ecuacion(puntofijo.getGX(), Xi); 
           
            PuntoFijo iteracion = new PuntoFijo();
            iteracion.setXi(Xi);
            iteracion.setGX(String.valueOf(gx));
            iteracion.setEa(Ea);
            iteracion.setIteracionesMaximas(i); 
            respuesta.add(iteracion);

            
            if (Ea <= puntofijo.getEa()) {
                break;
            }

           
            Xi = Xn;
        }

        return respuesta;
    }

    @Override
public ArrayList<NewtonRaphson> AlgoritmoNewtonRaphson(NewtonRaphson newtonraphson) {
    ArrayList<NewtonRaphson> respuesta = new ArrayList<>();

    double Xi = newtonraphson.getXi(); 
    double Xi1 = 0;           
    double Ea = 100;           
    double h = 0.0001; 

    int maxIteraciones = newtonraphson.getIteracionesMaximas();

    for (int i = 1; i <= maxIteraciones; i++) {
        double FXi = Funciones.Ecuacion(newtonraphson.getFX(), Xi);
        double FdXi = (Funciones.Ecuacion(newtonraphson.getFX(), Xi + h) - FXi) / h;
        if (FdXi == 0) {
            System.out.println("Derivada cerca de cero, iteracion pausada");
            break;
        }
        // Xi+1
        Xi1 = Xi - (FXi / FdXi);

        Ea = Funciones.ErrorRelativo(Xi1, Xi);

      
        NewtonRaphson iteracion = new NewtonRaphson();
        iteracion.setXi(Xi);
        iteracion.setFXi(FXi);
        iteracion.setFXDerivada(String.valueOf(FdXi));
        iteracion.setXii(Xi1); 
        iteracion.setEa(Ea);
        iteracion.setIteracionesMaximas(i);

        respuesta.add(iteracion); 

       
        Xi = Xi1;

        if (Ea <= newtonraphson.getEa()) {
            break; 
        }
    }

    return respuesta;
}

@Override
    public ArrayList<Secante> AlgoritmoSecante(Secante secante) {
        ArrayList<Secante> respuesta = new ArrayList<>();

        double Xi_1 = secante.getXi_1();
        double Xi = secante.getXi();   
        double Xi1;                     
        double F_Xi_1, F_Xi, Ea = 100;

        int maxIteraciones = secante.getIteracionesMaximas();

        for (int i = 1; i <= maxIteraciones; i++) {
            F_Xi_1 = Funciones.Ecuacion(secante.getFX(), Xi_1);
            F_Xi = Funciones.Ecuacion(secante.getFX(), Xi);


            
            if ((F_Xi_1 - F_Xi) == 0) {
                System.out.println("Denominador cercano a cero, deteniendo iteración.");
                break;
            }

            Xi1 = Xi - (F_Xi * (Xi_1 - Xi)) / (F_Xi_1 - F_Xi);

      
            if (i != 1) {
                Ea = Math.abs((Xi1 - Xi) / Xi1) * 100;
            }

            // Crear iteración
            Secante iter = new Secante();
            iter.setXi(Xi);
            iter.setXi_1(Xi_1);
            iter.setXi1(Xi1);
            iter.setFXi(F_Xi);
            iter.setF_Xi_1(F_Xi_1);
            iter.setEa(Ea);
            iter.setIteracionesMaximas(i);
            iter.setFX(secante.getFX());


          
            respuesta.add(iter);

         
            
            
            if (Ea <= secante.getEa()) {
                break;
            }

          
            Xi_1 = Xi;
            Xi = Xi1;
        }

        return respuesta;
    }



    @Override
    public ArrayList<SecanteModificado> AlgoritmoSecanteModificado(SecanteModificado secantemodificado) {
        ArrayList<SecanteModificado> respuesta = new ArrayList<>();

        double Xi = secantemodificado.getXi();
        double Xi1;
        double Ea = 100;
        int maxIteraciones = secantemodificado.getIteracionesMaximas();
        double sigma = secantemodificado.getSigma();

        for (int i = 1; i <= maxIteraciones; i++) {
            double deltaXi = sigma * Xi;
            double FXi = Funciones.Ecuacion(secantemodificado.getFX(), Xi);
            double FXiSigma = Funciones.Ecuacion(secantemodificado.getFX(), Xi + deltaXi);

            double denominador = FXiSigma - FXi;

            System.out.println("Iteración " + i + " Xi=" + Xi);
            System.out.println("f(Xi)=" + FXi + " f(Xi+deltaXi)=" + FXiSigma);
            System.out.println("Denominador=" + denominador);

            if (Math.abs(denominador) < 1e-8) {
                System.out.println("Denominador muy pequeño, pausado para evitar dividir por 0.");
                break;
            }

            Xi1 = Xi - (deltaXi * FXi) / denominador;

            if (i != 1) {
                Ea = Funciones.ErrorRelativo(Xi1, Xi);
            }

            SecanteModificado iter = new SecanteModificado();
            iter.setXi(Xi);
            iter.setXi1(Xi1);
            iter.setFXi(FXi);
            iter.setFXiSigma(FXiSigma);
            iter.setEa(Ea);
            iter.setIteracionesMaximas(i);
            iter.setFX(secantemodificado.getFX());
            iter.setSigma(sigma);

            respuesta.add(iter);

            if (Ea <= secantemodificado.getEa()) {
                break;
            }

            Xi = Xi1;
        }

        return respuesta;

    }

}


