package co.edu.uniquindio.tallerprograavanzada.repository;

import co.edu.uniquindio.tallerprograavanzada.entity.VideoJuego;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VideoJuegoRepository extends JpaRepository<VideoJuego, Long> {
    List<VideoJuego> findByTitulo(String titulo);
    List<VideoJuego> findByPrecioBetween(Double min, Double max);
}
