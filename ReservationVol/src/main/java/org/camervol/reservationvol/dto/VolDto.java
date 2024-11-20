package org.camervol.reservationvol.dto;

import lombok.Builder;
import org.camervol.reservationvol.model.ClassesVoyage;
import org.camervol.reservationvol.model.Vol;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Builder
public record VolDto(
        Long id,
        String numeroVol,
        Long placesDisponible,
        String villeDepart,
        String villeArrivee,
        LocalDate dateDepart,
        LocalTime heureDepart,
        LocalDate dateArrivee,
        ClassesVoyage classesVoyage,
        BigDecimal prix
) {
    public static VolDto toDto(Vol vol) {
        return VolDto.builder()
                .id(vol.getId())
                .numeroVol(vol.getNumeroVol())
                .placesDisponible(vol.getPlacesDisponible())
                .villeDepart(vol.getVilleDepart())
                .villeArrivee(vol.getVilleArrivee())
                .dateDepart(vol.getDateDepart())
                .dateArrivee(vol.getDateArrivee())
                .heureDepart(vol.getHeureDepart())
                .classesVoyage(vol.getClassesVoyage())
                .prix(vol.getPrix())
                .build();
    }

    public static Vol toEntity(VolDto volDto) {
        return Vol.builder()
                .id(volDto.id())
                .numeroVol(volDto.numeroVol())
                .placesDisponible(volDto.placesDisponible())
                .villeDepart(volDto.villeDepart())
                .villeArrivee(volDto.villeArrivee())
                .dateDepart(volDto.dateDepart())
                .classesVoyage(volDto.classesVoyage())
                .prix(volDto.prix())
                .build();
    }
}
