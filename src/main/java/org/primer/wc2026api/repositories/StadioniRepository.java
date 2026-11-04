package org.primer.wc2026api.repositories;

import org.primer.wc2026api.entities.Stadion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StadioniRepository extends JpaRepository<Stadion,Long> {

}
