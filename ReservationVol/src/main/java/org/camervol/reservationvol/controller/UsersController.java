package org.camervol.reservationvol.controller;

import lombok.RequiredArgsConstructor;
import org.camervol.reservationvol.dto.UsersDto;
import org.camervol.reservationvol.service.UsersService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class UsersController {
    private final UsersService usersService;

    @PostMapping("/")
    public ResponseEntity<UsersDto> save(@RequestBody UsersDto usersDto) {
        return ResponseEntity.ok(usersService.save(usersDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsersDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(usersService.findById(id));
    }
    @GetMapping("/")
    public ResponseEntity<List<UsersDto>> findAll() {
        return ResponseEntity.ok(usersService.findAll());
    }
}
