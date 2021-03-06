package rs.ac.bg.fon.naprednajava.touristagency.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import rs.ac.bg.fon.naprednajava.touristagency.entity.HotelEntity;
import rs.ac.bg.fon.naprednajava.touristagency.entity.RoomEntity;
import rs.ac.bg.fon.naprednajava.touristagency.entity.RoomIdentity;

@Repository
public interface RoomRepository extends JpaRepository<RoomEntity, RoomIdentity>{

	List<RoomEntity> findRoomsByHotelId(Long id);
}

