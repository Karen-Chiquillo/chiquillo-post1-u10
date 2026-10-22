package com.universidad.enviosservice.estrategia;

/**
 * Cargo por peso comun a todos los metodos de envio: hasta 5 kg no se cobra
 * adicional, de 5 a 20 kg se cobra la tarifa media por kg y por encima de
 * 20 kg la tarifa alta. Cada estrategia solo aporta sus dos tarifas.
 */
final class TramosDePeso {

    private static final double LIMITE_TRAMO_BAJO = 5;
    private static final double LIMITE_TRAMO_MEDIO = 20;

    private TramosDePeso() {
    }

    static double cargoAdicional(double pesoKg, double tarifaTramoMedio, double tarifaTramoAlto) {
        if (pesoKg <= LIMITE_TRAMO_BAJO) {
            return 0;
        }
        if (pesoKg <= LIMITE_TRAMO_MEDIO) {
            return (pesoKg - LIMITE_TRAMO_BAJO) * tarifaTramoMedio;
        }
        return (LIMITE_TRAMO_MEDIO - LIMITE_TRAMO_BAJO) * tarifaTramoMedio
                + (pesoKg - LIMITE_TRAMO_MEDIO) * tarifaTramoAlto;
    }
}
