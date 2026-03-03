package co.edu.uniquindio.tallerprograavanzada.service;

import co.edu.uniquindio.tallerprograavanzada.entity.VideoJuego;
import co.edu.uniquindio.tallerprograavanzada.exception.RecursoNoEncontradoException;
import co.edu.uniquindio.tallerprograavanzada.repository.VideoJuegoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoJuegoService {
    private final VideoJuegoRepository videoJuegoRepository;

    public VideoJuegoService(VideoJuegoRepository videoJuegoRepository) {
        this.videoJuegoRepository = videoJuegoRepository;
    }

    public VideoJuego crear(VideoJuego videoJuego) {
        return videoJuegoRepository.save(videoJuego);
    }

    public List<VideoJuego> listarTodos() {
        return videoJuegoRepository.findAll();
    }

    public VideoJuego buscarPorId(Long id) {
        return videoJuegoRepository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Recurso no encontrado con id" + id));
    }

    public void eliminar(Long id) {
        if (!videoJuegoRepository.existsById(id)) {
            throw new RuntimeException("Videojuego no encontrado");
        }
        videoJuegoRepository.deleteById(id);
    }

    public VideoJuego actualizar(Long id, VideoJuego nuevo) {
        VideoJuego existente = buscarPorId(id);

        existente.setTitulo(nuevo.getTitulo());
        existente.setPrecio(nuevo.getPrecio());
        existente.setCodigoRegistro(nuevo.getCodigoRegistro());
        existente.setGenero(nuevo.getGenero());
        existente.setDesarrolladora(nuevo.getDesarrolladora());

        return videoJuegoRepository.save(existente);
    }

    public List<VideoJuego> buscarPorTitulo(String titulo) {
        return videoJuegoRepository.findByTitulo(titulo);
    }

    public List<VideoJuego> buscarPorRango(Double min, Double max) {
        return videoJuegoRepository.findByPrecioBetween(min, max);
    }

    public VideoJuego aplicarDescuento(Long id, Double porcentaje) {
        VideoJuego juego = buscarPorId(id);

        double nuevoPrecio = juego.getPrecio() - (juego.getPrecio() * (porcentaje / 100));
        juego.setPrecio(nuevoPrecio);

        return videoJuegoRepository.save(juego);
    }

}
