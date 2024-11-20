package org.camervol.reservationvol.service;

import org.camervol.reservationvol.dto.VolDto;
import org.camervol.reservationvol.model.Vol;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public interface VolService {
    VolDto addVol(VolDto volDto);
    VolDto updateVol(Long id,VolDto volDto);
    VolDto getVol(Long id);
    List<VolDto> getVols();
    void deleteVol(Long id);
    List<VolDto> findByVilleDepartAndVilleArriveeAndDateDepart(String villeDepart, String villeArrivee, LocalDate dateDepart);
}
