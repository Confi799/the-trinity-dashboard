package com.trinity.dashboard;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Competidor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;

    // Métricas del 0 al 100
    private Integer p1 = 0;
    private Integer p2 = 0;
    private Integer p3 = 0;
    private Integer p4 = 0;
    private Integer p5 = 0;
    private Integer p6 = 0;
    private Integer p7 = 0;

    // Cálculo automático del promedio para el Ranking
    public Double getPromedio() {
        return (p1 + p2 + p3 + p4 + p5 + p6 + p7) / 7.0;
    }
}