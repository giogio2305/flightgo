package org.camervol.reservationvol.repository;

import org.camervol.reservationvol.model.Vol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface VolRepo extends JpaRepository<Vol, Long> {
    List<Vol> findByVilleDepartAndVilleArriveeAndDateDepart(String villeDepart, String villeArrivee, LocalDate dateDepart);
}
