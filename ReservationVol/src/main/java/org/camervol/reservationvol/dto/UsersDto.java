package org.camervol.reservationvol.dto;

import lombok.Builder;
import org.camervol.reservationvol.model.Role;
import org.camervol.reservationvol.model.Users;

@Builder
public record UsersDto(
        Long id,
        String nom,
        String prenom,
        String Adresse,
        String email,
        String role
) {
    public static UsersDto toDto(Users user) {
        return UsersDto.builder()
                .id(user.getId())
                .nom(user.getNom())
                .prenom(user.getPrenom())
                .Adresse(user.getAdresse())
                .email(user.getEmail())
                .role(String.valueOf(user.getRole()))
                .build();
    }
    public static Users toEntity(UsersDto usersDto) {
        return Users.builder()
                .id(usersDto.id())
                .nom(usersDto.nom())
                .prenom(usersDto.prenom())
                .Adresse(usersDto.Adresse())
                .email(usersDto.email())
                .role(Role.ROLE_USER)
                .build();
    }
}
