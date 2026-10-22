package com.universidad.enviosservice.estrategia;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EnvioInternacionalStrategyTest {

    private final EnvioInternacionalStrategy estrategia = new EnvioInternacionalStrategy();

    @ParameterizedTest
    @CsvSource({
            "3.0, 1000.0, 1850.0",  // pesoKg <= 5
            "8.0, 1000.0, 1859.0",  // 5 < pesoKg <= 20
            "25.0, 1000.0, 1917.5"  // pesoKg > 20
    })
    void calculaCostoPorTramoDePeso(double pesoKg, double distanciaKm, double esperado) {
        assertEquals(esperado, estrategia.calcular(pesoKg, distanciaKm), 0.01);
    }

    @ParameterizedTest
    @CsvSource({
            "3.0, 5000.0, 9050.0", // justo en 5000 km no hay recargo
            "3.0, 5001.0, 9151.8"  // mas de 5000 km suma 100
    })
    void aplicaRecargoSoloPorEncimaDe5000Km(double pesoKg, double distanciaKm, double esperado) {
        assertEquals(esperado, estrategia.calcular(pesoKg, distanciaKm), 0.01);
    }
}
