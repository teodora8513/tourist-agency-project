package rs.ac.bg.fon.naprednajava.touristagency.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import rs.ac.bg.fon.naprednajava.touristagency.entity.ReservationEntity;

@Repository
public interface ReservationRepository extends JpaRepository<ReservationEntity, Long> {

	@Query("SELECT res FROM ReservationEntity res "
			+ "WHERE res.user = (select u from UserEntity u where u.id = id)")
	List<ReservationEntity> reservationsById(@Param ("id") Long id);
}
