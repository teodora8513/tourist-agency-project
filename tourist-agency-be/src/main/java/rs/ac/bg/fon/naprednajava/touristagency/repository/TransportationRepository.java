package rs.ac.bg.fon.naprednajava.touristagency.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rs.ac.bg.fon.naprednajava.touristagency.entity.TransportationEntity;

@Repository
public interface TransportationRepository extends JpaRepository<TransportationEntity, Long> {

}
