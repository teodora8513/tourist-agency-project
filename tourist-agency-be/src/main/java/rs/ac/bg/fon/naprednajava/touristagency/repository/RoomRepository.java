package rs.ac.bg.fon.naprednajava.touristagency.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rs.ac.bg.fon.naprednajava.touristagency.entity.RoomEntity;
import rs.ac.bg.fon.naprednajava.touristagency.entity.RoomIdentity;

@Repository
public interface RoomRepository extends JpaRepository<RoomEntity, RoomIdentity>{

}

