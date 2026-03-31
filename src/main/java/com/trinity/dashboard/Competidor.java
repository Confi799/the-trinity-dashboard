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
    private Integer p8 = 0;

    // Cálculo automático del promedio blindado contra NULLs de la base de datos vieja
    public Double getPromedio() {
        int v1 = (p1 != null) ? p1 : 0;
        int v2 = (p2 != null) ? p2 : 0;
        int v3 = (p3 != null) ? p3 : 0;
        int v4 = (p4 != null) ? p4 : 0;
        int v5 = (p5 != null) ? p5 : 0;
        int v6 = (p6 != null) ? p6 : 0;
        int v7 = (p7 != null) ? p7 : 0;
        int v8 = (p8 != null) ? p8 : 0;

        return (v1 + v2 + v3 + v4 + v5 + v6 + v7 + v8) / 8.0;
    }
}