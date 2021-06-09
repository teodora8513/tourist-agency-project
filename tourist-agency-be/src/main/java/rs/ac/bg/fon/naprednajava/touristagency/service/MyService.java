package rs.ac.bg.fon.naprednajava.touristagency.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import rs.ac.bg.fon.naprednajava.touristagency.dto.MyDto;
import rs.ac.bg.fon.naprednajava.touristagency.exception.MyEntityAlreadyexists;
import rs.ac.bg.fon.naprednajava.touristagency.exception.MyEntityDoesntExist;


public interface MyService<DTO extends MyDto, ID> {

	//CRUD operacije
	Optional<DTO> findById(ID id);

	List<DTO> getAll();

	DTO save(DTO dto) throws MyEntityAlreadyexists, MyEntityDoesntExist;

	void delete(ID id) throws MyEntityDoesntExist;

	Optional<DTO> update(DTO dto) throws  MyEntityDoesntExist, MyEntityAlreadyexists;

	Page<DTO> findByPage(Pageable pageable);
	
}
