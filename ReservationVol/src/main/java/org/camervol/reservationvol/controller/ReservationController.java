package org.camervol.reservationvol.controller;

import lombok.RequiredArgsConstructor;
import org.camervol.reservationvol.dto.ReservationDto;
import org.camervol.reservationvol.dto.ReservationRequestDto;
import org.camervol.reservationvol.dto.UsersDto;
import org.camervol.reservationvol.model.Reservation;
import org.camervol.reservationvol.model.Users;
import org.camervol.reservationvol.model.Vol;
import org.camervol.reservationvol.repository.VolRepo;
import org.camervol.reservationvol.service.ReservationService;
import org.camervol.reservationvol.service.UsersService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/reservation")
@RequiredArgsConstructor
public class ReservationController {
    private final ReservationService reservationService;
    private final VolRepo volRepo;
    private final UsersService usersService;

    @PostMapping("/")
    public ResponseEntity<ReservationDto> reserveVol(@RequestBody ReservationRequestDto requestDto) {
        Optional<Vol> volOpt = volRepo.findById(requestDto.volId());
        if (volOpt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Vol vol = volOpt.get();
        UsersDto userDto = usersService.save(requestDto.usersDto());
        Users users =UsersDto.toEntity(userDto);
        if (requestDto.nombrePlacesReservation() > vol.getPlacesDisponible()) {
            throw new IllegalArgumentException("Le nombre de places demandé est supérieur au nombre de places disponibles.");
        }
        Reservation reservation = reservationService.createReservation(vol, users, requestDto.nombrePlacesReservation());

        return ResponseEntity.ok(ReservationDto.toDto(reservation));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<ReservationDto>> getReservationsByUserId(@PathVariable Long userId) {
       return ResponseEntity.ok(reservationService.getReservationByUsersId(userId));
    }
}

