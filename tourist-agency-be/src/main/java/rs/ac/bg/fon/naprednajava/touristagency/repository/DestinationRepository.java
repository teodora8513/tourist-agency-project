package rs.ac.bg.fon.naprednajava.touristagency.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rs.ac.bg.fon.naprednajava.touristagency.entity.DestinationEntity;

@Repository
public interface DestinationRepository extends JpaRepository<DestinationEntity, Long> {

}
