package org.camervol.reservationvol.service;

import org.camervol.reservationvol.dto.UsersDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UsersService {
    UsersDto save(UsersDto usersDto);
    UsersDto findById(Long id);
    List<UsersDto> findAll();
    void deleteById(Long id);
}
