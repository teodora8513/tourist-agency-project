package rs.ac.bg.fon.naprednajava.touristagency.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rs.ac.bg.fon.naprednajava.touristagency.entity.DestinationEntity;
import rs.ac.bg.fon.naprednajava.touristagency.entity.HotelEntity;

import java.util.Optional;

@Repository
public interface DestinationRepository extends JpaRepository<DestinationEntity, Long> {

    @Override
    Optional<DestinationEntity> findById(Long id);
	DestinationEntity findDestinationById(Long id);
}
