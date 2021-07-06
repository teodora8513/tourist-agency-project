package rs.ac.bg.fon.naprednajava.touristagency.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rs.ac.bg.fon.naprednajava.touristagency.entity.DestinationEntity;
import rs.ac.bg.fon.naprednajava.touristagency.entity.HotelEntity;

@Repository
public interface HotelRepository extends JpaRepository<HotelEntity, Long>{
	Optional<HotelEntity> findHotelByAddress(String address);

	List<HotelEntity> findHotelEntityByDestination(DestinationEntity destinationEntity);
	Optional<HotelEntity> findByImageName(String name);

}
