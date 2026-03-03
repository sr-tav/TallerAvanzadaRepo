package co.edu.uniquindio.tallerprograavanzada.controller;

import co.edu.uniquindio.tallerprograavanzada.entity.Desarrolladora;
import co.edu.uniquindio.tallerprograavanzada.repository.DesarrolladoraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/api/desarrolladora"})
public class DesarrolladoraController {

    private DesarrolladoraRepository desarrolladoraRepository;

    public DesarrolladoraController(DesarrolladoraRepository desarrolladoraRepository) {
        this.desarrolladoraRepository = desarrolladoraRepository;
    }
    
    @GetMapping
    public ResponseEntity<List<Desarrolladora>> listarDesarrolladoras() {
        return ResponseEntity.ok(desarrolladoraRepository.findAll());
    }
    @PostMapping
    public ResponseEntity<Desarrolladora> crear(@RequestBody Desarrolladora desarrolladora) {
        return ResponseEntity.status(201).body(desarrolladoraRepository.save(desarrolladora));
    }
}
