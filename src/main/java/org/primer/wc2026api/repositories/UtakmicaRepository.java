package org.primer.wc2026api.repositories;

import org.primer.wc2026api.entities.Utakmica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UtakmicaRepository extends JpaRepository<Utakmica,Long> {

    @Query(value = "SELECT * FROM wc2026 ORDER BY id",nativeQuery = true)
    List<Utakmica> findAll();


}
