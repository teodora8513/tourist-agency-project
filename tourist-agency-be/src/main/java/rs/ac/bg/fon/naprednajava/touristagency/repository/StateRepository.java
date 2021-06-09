package rs.ac.bg.fon.naprednajava.touristagency.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rs.ac.bg.fon.naprednajava.touristagency.entity.StateEntity;

@Repository
public interface StateRepository extends JpaRepository<StateEntity, Long> {

}
