package org.camervol.reservationvol.service.impl;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.camervol.reservationvol.dto.VolDto;
import org.camervol.reservationvol.model.Vol;
import org.camervol.reservationvol.repository.VolRepo;
import org.camervol.reservationvol.service.VolService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VolServiceImpl implements VolService {
    private final VolRepo volRepo;

    @Override
    public VolDto addVol(VolDto volDto) {
        Vol vol = VolDto.toEntity(volDto);
        Vol savedVol = volRepo.save(vol);
        return VolDto.toDto(savedVol);
    }

    @Override
    public VolDto updateVol(Long id, VolDto volDto) {
        Optional<Vol> vol = volRepo.findById(id);
        if (vol.isEmpty()) {
            throw new EntityNotFoundException("vol pas trouve avec cet id " + id);
        }
        Vol volToUpdate = vol.get();
        volToUpdate.setNumeroVol(volDto.numeroVol());
        volToUpdate.setPlacesDisponible(volDto.placesDisponible());
        volToUpdate.setVilleDepart(volDto.villeDepart());
        volToUpdate.setVilleArrivee(volDto.villeArrivee());
        volToUpdate.setDateDepart(volDto.dateDepart());
        volToUpdate.setDateArrivee(volDto.dateArrivee());
        volToUpdate.setHeureDepart(volDto.heureDepart());
        volToUpdate.setClassesVoyage(volDto.classesVoyage());
        volToUpdate.setPrix(volDto.prix());
        Vol volUpdate = volRepo.save(volToUpdate);
        return VolDto.toDto(volUpdate);
    }

    @Override
    public VolDto getVol(Long id) {
        Optional<Vol> vol = volRepo.findById(id);
        return vol.map(VolDto::toDto).orElseThrow(() -> new EntityNotFoundException("vol pas trouve avec cet id " + id));
    }

    @Override
    public List<VolDto> getVols() {
        return volRepo.findAll().stream().map(VolDto::toDto).toList();
    }

    @Override
    public void deleteVol(Long id) {
        Optional<Vol> vol = volRepo.findById(id);
        if (vol.isEmpty()) {
            throw new EntityNotFoundException("vol pas trouve avec cet id " + id);
        }
        volRepo.deleteById(id);

    }

    @Override
    public List<VolDto> findByVilleDepartAndVilleArriveeAndDateDepart(String villeDepart, String villeArrivee, LocalDate dateDepart) {
        List<Vol> vols = volRepo.findByVilleDepartAndVilleArriveeAndDateDepart(villeDepart, villeArrivee, dateDepart);
        if (vols.isEmpty()) {
            throw new IllegalArgumentException("Aucun vol disponible pour les critères spécifiés.");
        }
        return vols.stream().map(VolDto::toDto).toList();

    }
}
