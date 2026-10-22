package com.universidad.enviosservice.estrategia;

public class EnvioInternacionalStrategy implements EstrategiaEnvio {

    @Override
    public double calcular(double pesoKg, double distanciaKm) {
        double costo = distanciaKm * 1.8 + 50 + TramosDePeso.cargoAdicional(pesoKg, 3.0, 4.5);
        if (distanciaKm > 5000) {
            costo += 100;
        }
        return costo;
    }
}
