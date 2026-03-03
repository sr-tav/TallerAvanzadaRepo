package co.edu.uniquindio.tallerprograavanzada.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Desarrolladora {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    private String sitioWeb;

    @OneToMany(mappedBy = "desarrolladora")
    @JsonManagedReference
    private List<VideoJuego> videoJuegos;

    public Desarrolladora() {}

}
