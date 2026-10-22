package com.universidad.enviosservice.estrategia;

public class EnvioExpressStrategy implements EstrategiaEnvio {

    @Override
    public double calcular(double pesoKg, double distanciaKm) {
        double costo = distanciaKm * 1.2 + TramosDePeso.cargoAdicional(pesoKg, 1.5, 2.0);
        if (distanciaKm > 500) {
            costo += 25;
        }
        return costo * 1.3;
    }
}
