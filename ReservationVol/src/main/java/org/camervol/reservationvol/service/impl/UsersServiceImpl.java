package org.camervol.reservationvol.service.impl;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.camervol.reservationvol.dto.UsersDto;
import org.camervol.reservationvol.dto.VolDto;
import org.camervol.reservationvol.model.Users;
import org.camervol.reservationvol.model.Vol;
import org.camervol.reservationvol.repository.UsersRepo;
import org.camervol.reservationvol.service.UsersService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsersServiceImpl implements UsersService {
    private final UsersRepo usersRepo;
    @Override
    public UsersDto save(UsersDto usersDto) {
        Users user = UsersDto.toEntity(usersDto);
        Users savedUser = usersRepo.save(user);
        return UsersDto.toDto(savedUser);
    }

    @Override
    public UsersDto findById(Long id) {
        Optional<Users> user = usersRepo.findById(id);
        return user.map(UsersDto::toDto).orElseThrow(()-> new EntityNotFoundException("utilisateur pas trouve avec cet id "+id));
    }

    @Override
    public List<UsersDto> findAll() {
        return usersRepo.findAll().stream().map(UsersDto::toDto).toList();
    }

    @Override
    public void deleteById(Long id) {
        Optional<Users> vol = usersRepo.findById(id);
        if (vol.isEmpty()) {
            throw new EntityNotFoundException("utilisateur pas trouve avec cet id "+id);
        }
        usersRepo.deleteById(id);
    }
}
