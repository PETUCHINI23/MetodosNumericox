package mx.edu.itses.CJMRA.MetodosNumericos.services;

import java.util.ArrayList;
import lombok.extern.slf4j.Slf4j;
import mx.edu.itses.CJMRA.MetodosNumericos.domain.Biseccion;
import mx.edu.itses.CJMRA.MetodosNumericos.domain.NewtonRaphson;

import mx.edu.itses.CJMRA.MetodosNumericos.domain.ReglaFalsa;
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
        // Verificamos que en el intervalo definido haya un cambio de signo
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
                renglon.setXl(XU);
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
            //renglon.setIntervaloInvalido(true);
            respuesta.add(renglon);
        }

        return respuesta;
    }

    @Override

    public ArrayList<ReglaFalsa> AlgoritmoReglaFalsa(ReglaFalsa reglafalsa) {
        ArrayList<ReglaFalsa> respuestaReglaFalsa = new ArrayList<>();
        double XL, XU, XRa = 0, XRn, FXL, FXU, FXR, Ea = 100;
        XL = reglafalsa.getXL();
        XU = reglafalsa.getXU();

        FXL = Funciones.Ecuacion(reglafalsa.getFX(), XL);
        FXU = Funciones.Ecuacion(reglafalsa.getFX(), XU);

        if (FXL * FXU < 0) {
            for (int i = 1; i <= reglafalsa.getIteracionesMaximas(); i++) {
                // Fórmula de Regla Falsa
                XRn = XU - (FXU * (XL - XU)) / (FXL - FXU);
                FXR = Funciones.Ecuacion(reglafalsa.getFX(), XRn);

                if (i != 1) {
                    Ea = Funciones.ErrorRelativo(XRn, XRa);
                }

                ReglaFalsa renglon = new ReglaFalsa();
                renglon.setIteracionesMaximas(i);
                renglon.setXL(XL);
                renglon.setXU(XU);
                renglon.setXR(XRn);
                renglon.setFXL(FXL);
                renglon.setFXU(FXU);
                renglon.setFXR(FXR);
                renglon.setEa(Ea);

                // AGREGAR ESTA LÍNEA PARA CALCULAR EL PRODUCTO
                renglon.setProductoFXL_FXR(FXL * FXR);

                if (FXL * FXR < 0) {
                    XU = XRn;
                    FXU = FXR;
                } else {
                    XL = XRn;
                    FXL = FXR;
                }

                XRa = XRn;
                respuestaReglaFalsa.add(renglon);

                if (Ea <= reglafalsa.getEa()) {
                    break;
                }
            }
        } else {
            respuestaReglaFalsa.add(new ReglaFalsa());
        }
        return respuestaReglaFalsa;
    }

    public ArrayList<NewtonRaphson> AlgoritmoNewtonRaphson(NewtonRaphson newtonRaphson) {
        ArrayList<NewtonRaphson> respuestaNewtonRaphson = new ArrayList<>();
        double Xi, Xii = 0, Xia = 0, FXi, FXii, Ea = 100;

        Xi = newtonRaphson.getXi();

        FXii = Funciones.Ecuacion(newtonRaphson.getFXDerivada(), Xi);
        if (Math.abs(FXii) < 1e-10) {

            NewtonRaphson error = new NewtonRaphson();
            error.setIteracionesMaximas(0);
            error.setXi(Xi);
            error.setEa(-1); // Indicador de error
            respuestaNewtonRaphson.add(error);
            return respuestaNewtonRaphson;
        }

        for (int i = 1; i <= newtonRaphson.getIteracionesMaximas(); i++) {

            FXi = Funciones.Ecuacion(newtonRaphson.getFX(), Xi);

            FXii = Funciones.Ecuacion(newtonRaphson.getFXDerivada(), Xi);

            if (Math.abs(FXii) < 1e-10) {
                break;
            }

            Xii = Xi - (FXi / FXii);

            if (i != 1) {
                Ea = Funciones.ErrorRelativo(Xii, Xia);
            }

            // Crear objeto para almacenar resultados de esta iteración
            NewtonRaphson renglon = new NewtonRaphson();
            renglon.getIteracionesMaximas();
            renglon.setXi(Xi);
            renglon.setFXi(FXi);
            renglon.setFXii(FXii);
            renglon.setXii(Xii);
            renglon.setEa(Ea);

            respuestaNewtonRaphson.add(renglon);

            if (i > 1 && Ea <= newtonRaphson.getEa()) {
                break;
            }

            Xia = Xi;
            Xi = Xii;
        }

        return respuestaNewtonRaphson;
    }
}
