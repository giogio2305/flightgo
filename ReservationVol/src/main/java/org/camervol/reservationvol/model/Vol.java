package org.camervol.reservationvol.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@SuperBuilder
public class Vol extends AbstractEntity{
    private String numeroVol;
    private Long placesDisponible;
    private String villeDepart;
    private String villeArrivee;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateDepart;
    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime heureDepart;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateArrivee;
    @Enumerated(EnumType.STRING)
    private ClassesVoyage classesVoyage;
    private BigDecimal prix;

    @OneToMany(mappedBy = "vol",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Reservation> reservations;


}
