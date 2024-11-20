package org.camervol.reservationvol.dto;

import lombok.Builder;
import org.camervol.reservationvol.model.ClassesVoyage;
import org.camervol.reservationvol.model.Reservation;
import org.camervol.reservationvol.model.Status;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Builder
public record ReservationDto(
        Long id,
        String numeroVol,
        String numeroReservation,
        LocalDateTime dateReservation,
        Status status,
        Long nombrePlacesReservation,
        String villeDepart,
        String villeArrivee,
        LocalDate dateDepart,
        LocalDate dateArrivee,
        LocalTime heureDepart,
        ClassesVoyage classesVoyage,
        BigDecimal prix



) {
    public static ReservationDto toDto(Reservation reservation) {
        return ReservationDto.builder()
                .id(reservation.getId())
                .numeroVol(reservation.getVol().getNumeroVol())
                .numeroReservation(reservation.getNumeroReservation())
                .dateReservation(reservation.getDateReservation())
                .status(reservation.getStatus())
                .nombrePlacesReservation(reservation.getNombrePlacesReservation())
                .villeDepart(reservation.getVol().getVilleDepart())
                .villeArrivee(reservation.getVol().getVilleArrivee())
                .dateDepart(reservation.getVol().getDateDepart())
                .dateArrivee(reservation.getVol().getDateArrivee())
                .heureDepart(reservation.getVol().getHeureDepart())
                .classesVoyage(reservation.getVol().getClassesVoyage())
                .prix(reservation.getVol().getPrix())
                .build();
    }

}
