package org.camervol.reservationvol.service;

import org.camervol.reservationvol.dto.ReservationDto;
import org.camervol.reservationvol.dto.ReservationRequestDto;
import org.camervol.reservationvol.model.Reservation;
import org.camervol.reservationvol.model.Users;
import org.camervol.reservationvol.model.Vol;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReservationService {
    Reservation createReservation(Vol vol, Users user, Long nombrePlaces);
    ReservationDto findById(Long id);
    List<ReservationDto> findAll();
    List<ReservationDto> findByUser(Users user);
    List<ReservationDto> getReservationByUsersId(Long userId);

}
