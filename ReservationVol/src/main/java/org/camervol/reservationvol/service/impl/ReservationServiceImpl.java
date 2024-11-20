package org.camervol.reservationvol.service.impl;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.camervol.reservationvol.dto.ReservationDto;
import org.camervol.reservationvol.model.Reservation;
import org.camervol.reservationvol.model.Status;
import org.camervol.reservationvol.model.Users;
import org.camervol.reservationvol.model.Vol;
import org.camervol.reservationvol.repository.ReservationRepo;
import org.camervol.reservationvol.repository.VolRepo;
import org.camervol.reservationvol.service.ReservationService;
import org.camervol.reservationvol.utils.RandomNumberResevation;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService {
    private final ReservationRepo reservationRepo;
    private final VolRepo volRepo;
    @Override
    public Reservation createReservation(Vol vol, Users user, Long nombrePlaces) {
        if (nombrePlaces <= 0) {
            throw new IllegalArgumentException("Le nombre de places doit être supérieur à zéro.");
        }
        if (vol == null) {
            throw new IllegalArgumentException("Le vol ne peut pas être null.");
        }
        long placesRestantes = vol.getPlacesDisponible() - nombrePlaces;
        vol.setPlacesDisponible(placesRestantes);
        volRepo.save(vol);
        Reservation reservation = Reservation.builder()
                .vol(vol)
                .users(user)
                .nombrePlacesReservation(nombrePlaces)
                .numeroReservation(RandomNumberResevation.generateNumeroReservation())
                .dateReservation(LocalDateTime.now())
                .status(Status.EN_ATTENTE)
                .build();
        return reservationRepo.save(reservation);

    }

    @Override
    public ReservationDto findById(Long id) {
        return null;
    }

    @Override
    public List<ReservationDto> findAll() {
        return reservationRepo.findAll().stream().map(ReservationDto::toDto).toList();
    }

    @Override
    public List<ReservationDto> findByUser(Users user) {
        return List.of();
    }

    @Override
    public List<ReservationDto> getReservationByUsersId(Long userId) {
        List<Reservation> reservations = reservationRepo.findByUsersId(userId);
        if (reservations.isEmpty()) {
            throw new EntityNotFoundException("Pas de reservation pour cet utilisateur");
        }
        return reservations.stream()
                .map(ReservationDto::toDto).toList();
    }
}
