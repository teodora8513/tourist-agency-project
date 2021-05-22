package rs.ac.bg.fon.naprednajava.touristagency.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import rs.ac.bg.fon.naprednajava.touristagency.dto.MyDto;


public interface MyService<DTO extends MyDto, ID> {

	//CRUD operacije
	Optional<DTO> findById(ID id);

	List<DTO> getAll();

	DTO save(DTO dto);

	void delete(ID id);

	Optional<DTO> update(DTO dto);

	Page<DTO> findByPage(Pageable pageable);
	
}
