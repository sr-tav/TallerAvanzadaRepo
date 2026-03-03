package co.edu.uniquindio.tallerprograavanzada.service;

import co.edu.uniquindio.tallerprograavanzada.entity.Desarrolladora;
import co.edu.uniquindio.tallerprograavanzada.repository.DesarrolladoraRepository;
import org.springframework.stereotype.Service;

import javax.print.DocFlavor;
import java.util.List;

@Service
public class DesarrolladoraService {
    private final DesarrolladoraRepository desarrolladoraRepository;

    public DesarrolladoraService(DesarrolladoraRepository desarrolladoraRepository) {
        this.desarrolladoraRepository = desarrolladoraRepository;
    }

    public Desarrolladora crearDesarrolladora(Desarrolladora desarrolladora) {
        return desarrolladoraRepository.save(desarrolladora);
    }

    public List<Desarrolladora> listarDesarrolladoras() {
        return desarrolladoraRepository.findAll();
    }
}
