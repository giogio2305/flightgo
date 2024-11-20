package org.camervol.reservationvol.dto;

public record ReservationRequestDto(
        UsersDto usersDto,
        Long volId,
        Long nombrePlacesReservation
) {
}
