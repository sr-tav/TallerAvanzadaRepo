package co.edu.uniquindio.tallerprograavanzada.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class VideoJuego {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 100)
    private String titulo;

    @Column(nullable = false)
    private Double precio;

    @Column(nullable = false, unique = true)
    private String codigoRegistro;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Genero genero;

    @ManyToOne
    @JoinColumn(name = "desarolladora_id", nullable = false)
    @JsonBackReference
    private Desarrolladora desarrolladora;

    @Column(updatable = false)
    private LocalDateTime fechaCreacion;

    private LocalDateTime fechaActualizacion;

    @Transient
    private Double precioConIva;

    public VideoJuego() {}

    /**
     * ////////////////////////////////////// AUDITORIA /////////////////////////////////////////////////
     */
    @PrePersist
    public void prePersist() {
        this.fechaCreacion = LocalDateTime.now();
        this.fechaActualizacion = LocalDateTime.now();
    }
    @PreUpdate
    public void preUpdate() {
        this.fechaActualizacion = LocalDateTime.now();
    }
    /**
     * ///////////////////////////////////////// CAMPO CALCULADO ///////////////////////////////////////////
     */
    public Double getPrecioConIva() {
        if(precio == null) return null;
        return precio * 1.19;
    }
}
