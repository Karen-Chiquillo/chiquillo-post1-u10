package com.universidad.enviosservice.estrategia;

public class EnvioOvernightStrategy implements EstrategiaEnvio {

    @Override
    public double calcular(double pesoKg, double distanciaKm) {
        if (distanciaKm > 300) {
            throw new IllegalArgumentException("OVERNIGHT no disponible para mas de 300 km");
        }
        return distanciaKm * 2.0 + 20 + TramosDePeso.cargoAdicional(pesoKg, 2.5, 3.0);
    }
}
