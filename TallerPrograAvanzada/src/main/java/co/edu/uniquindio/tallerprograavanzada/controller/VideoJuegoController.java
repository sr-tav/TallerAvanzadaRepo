package co.edu.uniquindio.tallerprograavanzada.controller;

import co.edu.uniquindio.tallerprograavanzada.entity.VideoJuego;
import co.edu.uniquindio.tallerprograavanzada.service.VideoJuegoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/api/videojuegos"})
public class VideoJuegoController {
    private final VideoJuegoService videoJuegoService;

    public VideoJuegoController(VideoJuegoService videoJuegoService) {
        this.videoJuegoService = videoJuegoService;
    }

    @GetMapping
    public ResponseEntity<List<VideoJuego>> listarVideoJuego(){
        return ResponseEntity.ok(videoJuegoService.listarTodos());
    }
    @GetMapping("/{id:[0-9]+}")
    public ResponseEntity<VideoJuego> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(videoJuegoService.buscarPorId(id));
    }
    @GetMapping("/titulo/{titulo}")
    public ResponseEntity<List<VideoJuego>> buscarPorTitulo(@PathVariable String titulo) {
        return ResponseEntity.ok(videoJuegoService.buscarPorTitulo(titulo));
    }
    @GetMapping("/precio")
    public ResponseEntity<List<VideoJuego>> buscarPorRango(@RequestParam Double min, @RequestParam Double max) {
        return ResponseEntity.ok(videoJuegoService.buscarPorRango(min, max));
    }
    @PostMapping
    public ResponseEntity<VideoJuego> crear(@RequestBody VideoJuego videoJuego){
        return ResponseEntity.status(201).body(videoJuegoService.crear(videoJuego));
    }
    @PutMapping("/{id}")
    public ResponseEntity<VideoJuego> actualizar(@PathVariable Long id, @RequestBody VideoJuego videoJuego){
        return ResponseEntity.ok(videoJuegoService.actualizar(id, videoJuego));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        videoJuegoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
    @PatchMapping("/{id}/descuento/{porcentaje}")
    public ResponseEntity<VideoJuego> aplicarDescuento(
            @PathVariable Long id,
            @PathVariable Double porcentaje) {

        return ResponseEntity.ok(videoJuegoService.aplicarDescuento(id, porcentaje));
    }
}
