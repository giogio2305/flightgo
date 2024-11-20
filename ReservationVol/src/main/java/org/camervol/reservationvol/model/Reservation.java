package org.camervol.reservationvol.model;



import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Reservation extends AbstractEntity{
    private String numeroReservation;
    private LocalDateTime dateReservation=LocalDateTime.now();
    @Enumerated(EnumType.STRING)
    private Status status;
    private Long nombrePlacesReservation;

    @ManyToOne
    private Users users;

    @ManyToOne
    private Vol vol;


}
