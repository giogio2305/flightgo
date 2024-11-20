package org.camervol.reservationvol.controller;

import lombok.RequiredArgsConstructor;
import org.camervol.reservationvol.dto.ReservationDto;
import org.camervol.reservationvol.dto.VolDto;
import org.camervol.reservationvol.service.ReservationService;
import org.camervol.reservationvol.service.VolService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/vol")
@RequiredArgsConstructor
public class VolController {
    private final VolService volService;
    private final ReservationService reservationService;

    @PostMapping("/")
    public ResponseEntity<VolDto> addVol(@RequestBody VolDto volDto) {
        return ResponseEntity.ok(volService.addVol(volDto));
    }
    @GetMapping("/")
    public ResponseEntity<List<VolDto>> getAllVol() {
        return ResponseEntity.ok(volService.getVols());
    }
    @PostMapping("/{id}")
    public ResponseEntity<VolDto> getVol(@PathVariable Long id) {
        return ResponseEntity.ok(volService.getVol(id));
    }
    @GetMapping("/search")
    public ResponseEntity<List<VolDto>> rechercheVol(@RequestParam String villeDepart,
                                                     @RequestParam String villeArrivee,
                                                     @RequestParam LocalDate dateDepart) {
        return ResponseEntity.ok(volService.findByVilleDepartAndVilleArriveeAndDateDepart(villeDepart, villeArrivee, dateDepart));
    }
}
