package rs.ac.bg.fon.naprednajava.touristagency.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rs.ac.bg.fon.naprednajava.touristagency.entity.TransportationEntity;

import java.util.Optional;

@Repository
public interface TransportationRepository extends JpaRepository<TransportationEntity, Long> {

    Optional<TransportationEntity> findById(Long id);
}
