package com.trinity.dashboard;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/competidores")
@CrossOrigin(origins = "*")
public class CompetidorController {

    private final CompetidorRepository repo;

    public CompetidorController(CompetidorRepository repo) {
        this.repo = repo;
    }

    // Devuelve el Ranking ordenado por promedio (Mayor a menor)
    @GetMapping("/ranking")
    public List<Competidor> obtenerRanking() {
        return repo.findAll().stream()
                .sorted((c1, c2) -> c2.getPromedio().compareTo(c1.getPromedio()))
                .collect(Collectors.toList());
    }

    // Actualiza los puntos de un competidor
    @PutMapping("/{id}")
    public Competidor actualizar(@PathVariable Integer id, @RequestBody Competidor datos) {
        Competidor c = repo.findById(id).orElseThrow();
        c.setP1(datos.getP1());
        c.setP2(datos.getP2());
        c.setP3(datos.getP3());
        c.setP4(datos.getP4());
        c.setP5(datos.getP5());
        c.setP6(datos.getP6());
        c.setP7(datos.getP7());
        c.setP8(datos.getP8());
        return repo.save(c);
    }
}